package processing;

import java.util.BitSet;

public class Metrics {

    /**
     * (Wzór 26) Uogólniona miara n-gramów z ograniczeniami dla n1=2 (bigramy) i n2=3 (trigramy).
     * Zwraca wartość z przedziału [0, 1].
     */
    public static double calculateNgramSimilarity(String s1, String s2) {
        if (s1 == null) s1 = "";
        if (s2 == null) s2 = "";
        
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s1.equals(s2)) return 1.0;
        if (s1.length() < 2 || s2.length() < 2) return 0.0;

        int N1 = s1.length();
        int N2 = s2.length();
        int N = Math.max(N1, N2); 

        int n1 = 2; // bigramy
        int n2 = 3; // trigramy

        double denominator = (N - n1 + 1.0) * (N - n1 + 2.0) - (N - n2 + 1.0) * (N - n2);
        if (denominator <= 0) return 0.0;
        double f = 2.0 / denominator;

        int matchCount = 0;

        for (int i = n1; i <= n2; i++) {
            if (N1 < i) continue; 
            
            for (int j = 0; j <= N1 - i; j++) {
                String ngram = s1.substring(j, j + i);
                if (s2.contains(ngram)) {
                    matchCount++;
                }
            }
        }

        return f * matchCount;
    }

    public static double convertTextFeature(String s1, String s2) {
        return 1.0 - calculateNgramSimilarity(s1, s2);
    }

    /**
     * Nowa metoda obliczająca odległość z uwzględnieniem MASKI CECH.
     * Używana do włączania/wyłączania poszczególnych cech w trakcie eksperymentów.
     * mask: bity 0-7 to cechy liczbowe, bity 8-11 to cechy tekstowe.
     */
    public static double calculateDistance(FeatureVector v1, FeatureVector v2, KNNClassifier.DistanceMetric metric, BitSet mask) {
        double[] num1 = v1.getNumericalFeatures();
        String[] txt1 = v1.getTextualFeatures();
        
        double[] num2 = v2.getNumericalFeatures();
        String[] txt2 = v2.getTextualFeatures();

        double sum = 0;
        double maxDiff = 0;

        // Cechy liczbowe (0-7)
        for (int i = 0; i < num1.length; i++) {
            if (mask.get(i)) {
                double diff = Math.abs(num1[i] - num2[i]);
                if (metric == KNNClassifier.DistanceMetric.EUCLIDEAN) sum += diff * diff;
                else if (metric == KNNClassifier.DistanceMetric.MANHATTAN) sum += diff;
                else if (metric == KNNClassifier.DistanceMetric.CHEBYSHEV) maxDiff = Math.max(maxDiff, diff);
            }
        }

        // Cechy tekstowe (8-11)
        for (int i = 0; i < txt1.length; i++) {
            if (mask.get(8 + i)) {
                double diff = convertTextFeature(txt1[i], txt2[i]);
                if (metric == KNNClassifier.DistanceMetric.EUCLIDEAN) sum += diff * diff;
                else if (metric == KNNClassifier.DistanceMetric.MANHATTAN) sum += diff;
                else if (metric == KNNClassifier.DistanceMetric.CHEBYSHEV) maxDiff = Math.max(maxDiff, diff);
            }
        }

        if (metric == KNNClassifier.DistanceMetric.EUCLIDEAN) return Math.sqrt(sum);
        if (metric == KNNClassifier.DistanceMetric.CHEBYSHEV) return maxDiff;
        return sum; // Manhattan
    }

    // Klasyczne metody (zostawione dla kompatybilności wstecznej, jeśli byś ich potrzebowała)
    private static double[] getFeatureDifferences(FeatureVector v1, FeatureVector v2) {
        double[] num1 = v1.getNumericalFeatures();
        String[] txt1 = v1.getTextualFeatures();
        double[] num2 = v2.getNumericalFeatures();
        String[] txt2 = v2.getTextualFeatures();
        int totalFeatures = num1.length + txt1.length;
        double[] differences = new double[totalFeatures];
        for (int i = 0; i < num1.length; i++) differences[i] = num1[i] - num2[i];
        for (int i = 0; i < txt1.length; i++) differences[num1.length + i] = convertTextFeature(txt1[i], txt2[i]);
        return differences;
    }

    public static double euclideanDistance(FeatureVector v1, FeatureVector v2) {
        double[] diffs = getFeatureDifferences(v1, v2);
        double sum = 0;
        for (double diff : diffs) sum += diff * diff;
        return Math.sqrt(sum);
    }

    public static double manhattanDistance(FeatureVector v1, FeatureVector v2) {
        double[] diffs = getFeatureDifferences(v1, v2);
        double sum = 0;
        for (double diff : diffs) sum += Math.abs(diff);
        return sum;
    }

    public static double chebyshevDistance(FeatureVector v1, FeatureVector v2) {
        double[] diffs = getFeatureDifferences(v1, v2);
        double max = 0;
        for (double diff : diffs) if (Math.abs(diff) > max) max = Math.abs(diff);
        return max;
    }
}