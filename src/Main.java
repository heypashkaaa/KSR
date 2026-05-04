import loader.DocumentLoader;
import model.Article;
import processing.*;
import java.util.*;
import java.io.*;

public class Main {
    
    // Zdefiniowane klasy jako stała, żeby łatwo było przekazywać do macierzy pomyłek
    private static final String[] CLASS_NAMES = {"west-germany", "usa", "france", "uk", "canada", "japan"};

    public static void main(String[] args) {
        System.out.println("Rozpoczynam ładowanie danych...");
        
        // 1. Ładowanie i ekstrakcja
        DocumentLoader loader = new DocumentLoader();
        List<Article> articles = loader.loadFromDirectory("data");
        
        // --- NOWE: Eksport próbki danych do podejrzenia ---
        // Zrzuca 10 pierwszych artykułów do pliku, żebyś mógł pooglądać jak wygląda tekst i dateline
        exportArticleSamples(articles, 10, "raw_articles_sample.md");
        // ----------------------------------------------------

        FeatureExtractor extractor = new FeatureExtractor();
        List<FeatureVector> allVectors = new ArrayList<>();

        Map<String, Integer> countsPerCategory = new HashMap<>();
        for (String cls : CLASS_NAMES) countsPerCategory.put(cls, 0);  

        for (Article a : articles) {
            FeatureVector fv = extractor.extractFeatures(a);
            allVectors.add(fv);
            String label = fv.getLabel();
            countsPerCategory.put(label, countsPerCategory.getOrDefault(label, 0) + 1);
        }

        System.out.println("Zbiór danych załadowany. Liczba tekstów: " + allVectors.size());

        // Stałe ziarno dla powtarzalności
        Collections.shuffle(allVectors, new Random(42)); 

        BitSet allFeatures = new BitSet(12);
        allFeatures.set(0, 12);
        BitSet noDateline = new BitSet(12);
        noDateline.set(0,12 );
        noDateline.clear(9); 

        //int bestK = runExperiment1_KTuning(allVectors, noDateline, countsPerCategory);
        //int bestK = runExperiment1_KTuning(allVectors, allFeatures, countsPerCategory);
        int bestK = 6;

        //runExperiment2_Splits(allVectors, noDateline, bestK);
        //runExperiment3_Metrics(allVectors, noDateline, bestK);
        runExperiment4_Features(allVectors, bestK);
        
        System.out.println("\nWszystkie eksperymenty zakończone. Raporty zapisane do plików.");
    }

    // ===================================================================================
    // INSPEKCJA SUROWYCH DANYCH
    // ===================================================================================
    
    private static void exportArticleSamples(List<Article> articles, int count, String filename) {
        System.out.println(">>> Eksportowanie " + count + " przykładowych artykułów do " + filename + "...");
        StringBuilder sb = new StringBuilder();
        sb.append("# Przykładowe teksty ze zbioru (do analizy cech)\n\n");
        sb.append("Przydatne do analizy budowy sekcji np. `dateline`.\n\n");
        
        int limit = Math.min(count, articles.size());
        
        for (int i = 0; i < limit; i++) {
            Article a = articles.get(i);
            sb.append("## Artykuł ").append(i + 1).append("\n");
            
            // UWAGA: Jeśli Twoja klasa Article ma inne metody, podmień je poniżej!
            // Jeśli masz np. metody getPlaces(), getTitle() czy getDateline(), odkomentuj je:
            // sb.append("- **Title:** ").append(a.getTitle()).append("\n");
            // sb.append("- **Dateline:** ").append(a.getDateline()).append("\n");
            
            sb.append("\n**Surowy tekst:**\n");
            sb.append("```text\n");
            
            // Zakładam, że klasa ma metodę getText(), ew. zmień na getBody() lub po prostu a.toString()
            sb.append(a.getText()); 
            
            sb.append("\n```\n\n---\n\n");
        }
        
        saveToFile(filename, sb.toString());
    }

    // ===================================================================================
    // EKSPERYMENT 1: Wpływ parametru K
    // ===================================================================================
    private static int runExperiment1_KTuning(List<FeatureVector> allVectors, BitSet allFeatures, Map<String, Integer> datasetStats) {
        System.out.println(">>> Start: Eksperyment 1 (Parametr K)...");
        StringBuilder sb = new StringBuilder();
        sb.append("# EXPERIMENT 1: K-Value Tuning\n\n");
        appendDatasetStats(sb, allVectors.size(), datasetStats);

        // K=0 usunięte, rozszerzono górną granicę i zagęszczono wokół 5
        int[] kValues = {0, 1, 4, 5, 6, 7, 10, 15, 25, 30, 50, 80, 100, 150, 200, 251};
        double bestAcc = -1;
        int bestK = 5;
        
        for (int k : kValues) {
            sb.append("## K = ").append(k).append(" (Metric: EUCLIDEAN, Split: 60/40)\n");
            Evaluator res = runTest(allVectors, 0.6, k, KNNClassifier.DistanceMetric.EUCLIDEAN, allFeatures);
            
            appendMetricsAndMatrix(sb, res);
            
            if (res.getAccuracy() > bestAcc) {
                bestAcc = res.getAccuracy();
                bestK = k;
            }
        }
        sb.append("\n**Selected Best K for next experiments: ").append(bestK).append("**\n");
        saveToFile("exp1_k_tuning.md", sb.toString());
        return bestK;
    }

    // ===================================================================================
    // EKSPERYMENT 2: Podział Train/Test
    // ===================================================================================
    private static void runExperiment2_Splits(List<FeatureVector> allVectors, BitSet noDateline, int bestK) {
        System.out.println(">>> Start: Eksperyment 2 (Train/Test Splits)...");
        StringBuilder sb = new StringBuilder();
        sb.append("# EXPERIMENT 2: Train/Test Split Ratios\n\n");
        sb.append("Using K=").append(bestK).append(", Metric: EUCLIDEAN\n\n");

        // Skrajne przypadki (5/95 i 95/5) oraz standardowe
        double[] splits = {0.05, 0.2, 0.4, 0.6, 0.7, 0.8, 0.95};
        
        for (double s : splits) {
            sb.append(String.format("## Split: %.0f%% Train / %.0f%% Test\n", s*100, (1-s)*100));
            Evaluator res = runTest(allVectors, s, bestK, KNNClassifier.DistanceMetric.EUCLIDEAN, noDateline);
            appendMetricsAndMatrix(sb, res);
        }
        saveToFile("exp2_splits.md", sb.toString());
    }

    // ===================================================================================
    // EKSPERYMENT 3: Metryki dystansu
    // ===================================================================================
    private static void runExperiment3_Metrics(List<FeatureVector> allVectors, BitSet allFeatures, int bestK) {
        System.out.println(">>> Start: Eksperyment 3 (Distance Metrics)...");
        StringBuilder sb = new StringBuilder();
        sb.append("# EXPERIMENT 3: Distance Metrics\n\n");
        sb.append("Using K=").append(bestK).append(", Split: 80/20\n\n");

        for (KNNClassifier.DistanceMetric m : KNNClassifier.DistanceMetric.values()) {
            sb.append("## Metric: ").append(m.name()).append("\n");
            Evaluator res = runTest(allVectors, 0.8, bestK, m, allFeatures);
            appendMetricsAndMatrix(sb, res);
        }
        saveToFile("exp3_metrics.md", sb.toString());
    }

    // ===================================================================================
    // EKSPERYMENT 4: Cechy (Feature Subsets)
    // ===================================================================================
    private static void runExperiment4_Features(List<FeatureVector> allVectors, int bestK) {
        System.out.println(">>> Start: Eksperyment 4 (Feature Subsets)...");
        StringBuilder sb = new StringBuilder();
        sb.append("# EXPERIMENT 4: Feature Subsets\n\n");
        sb.append("Using K=").append(bestK).append(", Metric: MANHATTAN, Split: 80/20\n\n");
        
        Map<String, BitSet> subsets = new LinkedHashMap<>();

        BitSet allFeatures = new BitSet(12); allFeatures.set(0, 12);
        subsets.put("All Features (F1-F12)", allFeatures);
        
        BitSet noDateline = new BitSet(12); noDateline.set(0, 12);
        noDateline.clear(9); 
        subsets.put("F7-F9, F12", noDateline);
        
        BitSet onlyNumeric = new BitSet(12); onlyNumeric.set(0, 8);
        subsets.put("Numeric Only (F1-F6, F8, F12)", onlyNumeric);
        
        BitSet onlyText = new BitSet(12); onlyText.set(8, 12);
        subsets.put("Textual Only (F7, F9-F11)", onlyText);
        
        BitSet countrySpecific = new BitSet(12); countrySpecific.set(0, 6); countrySpecific.set(11);   
        subsets.put("Country-Specific Only (F1-F6, F11)", countrySpecific);

        for (Map.Entry<String, BitSet> entry : subsets.entrySet()) {
            sb.append("## Subset: ").append(entry.getKey()).append("\n");
            Evaluator res = runTest(allVectors, 0.8, bestK, KNNClassifier.DistanceMetric.MANHATTAN, entry.getValue());
            appendMetricsAndMatrix(sb, res);
        }
        saveToFile("exp4_features.md", sb.toString());
    }

    // ===================================================================================
    // FUNKCJE POMOCNICZE WSPÓLNE DLA EKSPERYMENTÓW
    // ===================================================================================
    
    private static void appendDatasetStats(StringBuilder sb, int total, Map<String, Integer> counts) {
        sb.append("## Dataset Statistics\n");
        sb.append("- **Total texts processed (filtered):** ").append(total).append("\n");
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            sb.append(String.format("- %s: %d texts\n", entry.getKey(), entry.getValue()));
        }
        sb.append("\n");
    }

    /**
     * Uniwersalna funkcja drukująca macierz pomyłek i metryki dla każdej z klas
     */
    private static void appendMetricsAndMatrix(StringBuilder sb, Evaluator res) {
        sb.append(String.format("**Overall Accuracy : %.4f**\n\n", res.getAccuracy()));
        
        // Tabela metryk per klasa
        sb.append("### Metrics by Class\n");
        sb.append("| Class Name | Precision | Recall | F1-Score |\n");
        sb.append("|------------|-----------|--------|----------|\n");
        for (String c : CLASS_NAMES) {
            sb.append(String.format("| %-10s | %.4f    | %.4f | %.4f   |\n", 
                    c, res.getPrecision(c), res.getRecall(c), res.getF1Score(c)));
        }

        // Macierz pomyłek (Confusion Matrix)
        sb.append("\n### Confusion Matrix\n");
        sb.append("*Wiersze: Klasa Rzeczywista | Kolumny: Klasa Przewidziana*\n\n");
        sb.append("| Klasa | ").append(String.join(" | ", CLASS_NAMES)).append(" |\n");
        sb.append("|---").append("|---".repeat(CLASS_NAMES.length)).append("|\n");

        for (String actual : CLASS_NAMES) {
            sb.append("| **").append(actual).append("** | ");
            for (String predicted : CLASS_NAMES) {
                int count = res.getCount(actual, predicted); 
                sb.append(count).append(" | ");
            }
            sb.append("\n");
        }
        sb.append("\n---\n\n");
    }

    private static void saveToFile(String filename, String content) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(content);
            System.out.println("  -> Zapisano pomyślnie: " + filename);
        } catch (Exception e) { 
            System.err.println("  -> Błąd zapisu pliku: " + filename);
            e.printStackTrace(); 
        }
    }

    // ===================================================================================
    // LOGIKA KLASYFIKACJI KNN
    // ===================================================================================
    
    private static Evaluator runTest(List<FeatureVector> data, double splitRatio, int k, KNNClassifier.DistanceMetric metric, BitSet mask) {
        int trainSize = (int)(data.size() * splitRatio);
        List<FeatureVector> train = data.subList(0, trainSize);
        List<FeatureVector> test = data.subList(trainSize, data.size());
        
        Evaluator eval = new Evaluator();
        for (FeatureVector tv : test) {
            String predicted = classifyWithMask(tv, train, k, metric, mask);
            eval.addPrediction(tv.getLabel(), predicted);
        }
        return eval;
    }

    private static String classifyWithMask(FeatureVector test, List<FeatureVector> train, int k, KNNClassifier.DistanceMetric metric, BitSet mask) {
        if (k <= 0) {
            return "UNKNOWN_CLASS"; 
        }
        
        if (train == null || train.isEmpty()) {
            return "UNKNOWN_CLASS";
        }
        
        // Kolejka priorytetowa (Max-Heap) przechowująca K najbliższych sąsiadów
        PriorityQueue<Object[]> pq = new PriorityQueue<>((a, b) -> Double.compare((double)b[1], (double)a[1]));
        
        for (FeatureVector tr : train) {
            double distance = Metrics.calculateDistance(test, tr, metric, mask);
            pq.add(new Object[]{tr.getLabel(), distance});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        // 1. Wyciągamy sąsiadów z kolejki i układamy od NAJBLIŻSZEGO do najdalszego
        List<Object[]> nearestNeighbors = new ArrayList<>();
        while (!pq.isEmpty()) {
            nearestNeighbors.add(pq.poll()); // Kolejka wydaje od najdalszego
        }
        Collections.reverse(nearestNeighbors); // Odwracamy, by na początku był ten najbliżej
        
        // 2. Liczymy głosy
        Map<String, Integer> classVotes = new HashMap<>();
        for (Object[] neighbor : nearestNeighbors) {
            String label = (String) neighbor[0];
            classVotes.put(label, classVotes.getOrDefault(label, 0) + 1);
        }

        if (classVotes.isEmpty()) {
            return "UNKNOWN_CLASS";
        }
        
        // 3. Znajdujemy maksymalną liczbę głosów
        int maxVotes = Collections.max(classVotes.values());
        
        // 4. Sprawdzamy, ile klas zdobyło ten maksymalny wynik
        List<String> tiedClasses = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : classVotes.entrySet()) {
            if (entry.getValue() == maxVotes) {
                tiedClasses.add(entry.getKey());
            }
        }
        
        // 5. ROZSTRZYGANIE REMISU
        if (tiedClasses.size() == 1) {
            // Brak remisu, wygrywa klasa z największą liczbą głosów
            return tiedClasses.get(0);
        } else {
            // Mamy remis! (tiedClasses.size() > 1)
            // Przeszukujemy listę sąsiadów (od najbliższego). 
            // Pierwszy napotkany sąsiad, którego klasa jest na liście remisujących, przesądza o zwycięstwie.
            for (Object[] neighbor : nearestNeighbors) {
                String label = (String) neighbor[0];
                if (tiedClasses.contains(label)) {
                    return label; 
                }
            }
        }
        
        return "UNKNOWN_CLASS"; // Awaryjny zwrot (nigdy nie powinno tu dojść)
    }
}