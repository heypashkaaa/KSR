package processing;

import java.util.*;

/**
 * Klasa oceniająca skuteczność klasyfikatora na podstawie Macierzy Pomyłek.
 * Implementuje wzory ze sprawozdania (Tydzień 04) oraz zbiera dane do macierzy pomyłek.
 */
public class Evaluator {

    // Lista badanych klas
    private static final List<String> CLASSES = Arrays.asList(
            "west-germany", "usa", "france", "uk", "canada", "japan"
    );

    private int totalPredictions = 0;
    private int correctPredictions = 0;

    // Tk: poprawne trafienia dla klasy k
    private Map<String, Integer> truePositives = new HashMap<>();
    
    // Fk: fałszywe alarmy (przewidziano k, ale było coś innego)
    private Map<String, Integer> falsePositives = new HashMap<>();
    
    // F~k: chybienia (było k, ale przewidziano coś innego)
    private Map<String, Integer> falseNegatives = new HashMap<>();
    
    // nk: całkowita liczba dokumentów w rzeczywistości należących do klasy k
    private Map<String, Integer> actualCounts = new HashMap<>();

    // Macierz pomyłek: [Klasa Rzeczywista] -> [Klasa Przewidziana] -> Liczba wystąpień
    private Map<String, Map<String, Integer>> confusionMatrix = new HashMap<>();

    public Evaluator() {
        for (String c : CLASSES) {
            truePositives.put(c, 0);
            falsePositives.put(c, 0);
            falseNegatives.put(c, 0);
            actualCounts.put(c, 0);
            
            // Inicjalizacja macierzy pomyłek zerami dla każdej pary klas
            Map<String, Integer> predictionsForClass = new HashMap<>();
            for (String predClass : CLASSES) {
                predictionsForClass.put(predClass, 0);
            }
            confusionMatrix.put(c, predictionsForClass);
        }
    }

    /**
     * Rejestruje pojedynczą predykcję z klasyfikatora.
     */
    public void addPrediction(String actual, String predicted) {
        if (!CLASSES.contains(actual) || !CLASSES.contains(predicted)) {
            return; // Ignorujemy śmieciowe dane
        }

        totalPredictions++;
        actualCounts.put(actual, actualCounts.get(actual) + 1);
        
        // Zapis do macierzy pomyłek
        confusionMatrix.get(actual).put(predicted, confusionMatrix.get(actual).get(predicted) + 1);

        if (actual.equals(predicted)) {
            // Sukces! (Tk)
            correctPredictions++;
            truePositives.put(actual, truePositives.get(actual) + 1);
        } else {
            // Porażka
            // Przewidzieliśmy "predicted", ale to błąd (Fk dla predicted)
            falsePositives.put(predicted, falsePositives.get(predicted) + 1);
            // Było "actual", ale go nie wykryto (F~k dla actual)
            falseNegatives.put(actual, falseNegatives.get(actual) + 1);
        }
    }

    /**
     * Zwraca liczbę wystąpień danej pary (Rzeczywista, Przewidziana) do budowy tabeli.
     */
    public int getCount(String actual, String predicted) {
        if (!confusionMatrix.containsKey(actual) || !confusionMatrix.get(actual).containsKey(predicted)) {
            return 0;
        }
        return confusionMatrix.get(actual).get(predicted);
    }

    /**
     * (Wzór 15) Dokładność całkowita (Accuracy).
     */
    public double getAccuracy() {
        if (totalPredictions == 0) return 0;
        return (double) correctPredictions / totalPredictions;
    }

    /**
     * (Wzór 16) Precyzja dla pojedynczej klasy.
     */
    public double getPrecision(String className) {
        int tk = truePositives.get(className);
        int fk = falsePositives.get(className);
        if (tk + fk == 0) return 0; // Zabezpieczenie przed dzieleniem przez zero
        return (double) tk / (tk + fk);
    }

    /**
     * (Wzór 18) Czułość dla pojedynczej klasy.
     */
    public double getRecall(String className) {
        int tk = truePositives.get(className);
        int fnk = falseNegatives.get(className);
        if (tk + fnk == 0) return 0;
        return (double) tk / (tk + fnk);
    }

    /**
     * (Wzór 20) Miara F1 dla pojedynczej klasy.
     */
    public double getF1Score(String className) {
        double p = getPrecision(className);
        double r = getRecall(className);
        if (p + r == 0) return 0;
        return 2 * (p * r) / (p + r);
    }

    /**
     * (Wzór 17) Średnia ważona Precyzji.
     */
    public double getWeightedPrecision() {
        if (totalPredictions == 0) return 0;
        double sum = 0;
        for (String c : CLASSES) {
            sum += actualCounts.get(c) * getPrecision(c);
        }
        return sum / totalPredictions;
    }

    /**
     * (Wzór 19) Średnia ważona Czułości.
     */
    public double getWeightedRecall() {
        if (totalPredictions == 0) return 0;
        double sum = 0;
        for (String c : CLASSES) {
            sum += actualCounts.get(c) * getRecall(c);
        }
        return sum / totalPredictions;
    }

    /**
     * (Wzór 21) Średnia ważona Miary F1.
     */
    public double getWeightedF1Score() {
        if (totalPredictions == 0) return 0;
        double sum = 0;
        for (String c : CLASSES) {
            sum += actualCounts.get(c) * getF1Score(c);
        }
        return sum / totalPredictions;
    }

    /**
     * Metoda wypisująca sformatowany raport na konsolę.
     */
    public void printReport() {
        System.out.println("\n=======================================================");
        System.out.println("               RAPORT Z KLASYFIKACJI                   ");
        System.out.println("=======================================================");
        System.out.printf("Dokładność (Accuracy): %.4f\n", getAccuracy());
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-15s | %-10s | %-10s | %-10s\n", "Klasa", "Precyzja", "Czułość", "F1-Score");
        System.out.println("-------------------------------------------------------");
        
        for (String c : CLASSES) {
            System.out.printf("%-15s | %.4f     | %.4f     | %.4f\n", 
                    c, getPrecision(c), getRecall(c), getF1Score(c));
        }
        
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-15s | %.4f     | %.4f     | %.4f\n", 
                "ŚREDNIA WAŻONA", getWeightedPrecision(), getWeightedRecall(), getWeightedF1Score());
        System.out.println("=======================================================\n");
    }
}