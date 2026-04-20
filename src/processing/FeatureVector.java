package processing;

import java.util.Arrays;


public class FeatureVector {
    
    // Cechy liczbowe: F1(Japonia), F2(Niemcy), F3(USA), F4(Francja), F5(UK), F6(Kanada), F8(Politycy), F12(Miasta)
    private double[] numericalFeatures; 
    
    // Cechy tekstowe: F7(Waluta), F9(Miasto Dateline), F10(Najczęstsze słowo), F11(Pierwsze Państwo)
    private String[] textualFeatures;   
    
    // Prawdziwa etykieta klasy (np. "usa")
    private String label;               

    public FeatureVector(double[] numericalFeatures, String[] textualFeatures, String label) {
        this.numericalFeatures = numericalFeatures;
        this.textualFeatures = textualFeatures;
        this.label = label;
    }

    public double[] getNumericalFeatures() {
        return numericalFeatures;
    }

    public String[] getTextualFeatures() {
        return textualFeatures;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "FeatureVector{" +
                "label='" + label + '\'' +
                ", num=" + Arrays.toString(numericalFeatures) +
                ", text=" + Arrays.toString(textualFeatures) +
                '}';
    }
}