package processing;

import java.util.Arrays;

/**
 * Represents an Article transformed into numerical and textual features.
 */
public class FeatureVector {
    
    private double[] numericalFeatures; // Holds the 8 numbers
    private String[] textualFeatures;   // Holds the 2 strings
    private String label;               // The true class (e.g., "usa", "japan")

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