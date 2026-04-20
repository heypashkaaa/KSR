import loader.DocumentLoader;
import model.Article;
import processing.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder finalReport = new StringBuilder();
        finalReport.append("# AUTOMATED KSR EXPERIMENTS REPORT\n\n");

        // 1. Loading and Extraction
        DocumentLoader loader = new DocumentLoader();
        List<Article> articles = loader.loadFromDirectory("data");
        FeatureExtractor extractor = new FeatureExtractor();
        List<FeatureVector> allVectors = new ArrayList<>();
        
        for (Article a : articles) {
            allVectors.add(extractor.extractFeatures(a));
        }
        // Fixed seed for reproducibility
        Collections.shuffle(allVectors, new Random(42)); 

        // Default mask (all 12 features active)
        BitSet allFeatures = new BitSet(12);
        allFeatures.set(0, 12);

        // List of all classes for detailed reporting
        String[] classNames = {"west-germany", "usa", "france", "uk", "canada", "japan"};

        // --- EXPERIMENT 1: K-Value Tuning ---
        finalReport.append("## 1. Performance depending on K parameter (Metric: EUCLIDEAN, Split: 60/40)\n");
        int[] kValues = {1, 2, 3, 5, 7, 10, 15, 20, 30, 50};
        double bestAcc = -1;
        int bestK = 5;
        
        for (int k : kValues) {
            Evaluator res = runTest(allVectors, 0.6, k, KNNClassifier.DistanceMetric.EUCLIDEAN, allFeatures);
            finalReport.append(String.format("- K=%2d: Global Accuracy=%.4f\n", k, res.getAccuracy()));
            
            if (res.getAccuracy() > bestAcc) {
                bestAcc = res.getAccuracy();
                bestK = k;
            }
        }
        finalReport.append("\n**Selected Best K: ").append(bestK).append("**\n\n");

        // --- EXPERIMENT 2: Train/Test Split Ratio ---
        finalReport.append("## 2. Performance depending on Train/Test Split (K=").append(bestK).append(", Metric: EUCLIDEAN)\n");
        double[] splits = {0.2, 0.4, 0.6, 0.8, 0.9};
        for (double s : splits) {
            Evaluator res = runTest(allVectors, s, bestK, KNNClassifier.DistanceMetric.EUCLIDEAN, allFeatures);
            finalReport.append(String.format("- Split %2.0f/%2.0f: Global Accuracy=%.4f\n", 
                    s*100, (1-s)*100, res.getAccuracy()));
        }

        // --- EXPERIMENT 3: Distance Metrics ---
        finalReport.append("\n## 3. Performance depending on Distance Metric (K=").append(bestK).append(", Split: 60/40)\n");
        for (KNNClassifier.DistanceMetric m : KNNClassifier.DistanceMetric.values()) {
            Evaluator res = runTest(allVectors, 0.6, bestK, m, allFeatures);
            finalReport.append(String.format("- %-10s: Global Accuracy=%.4f\n", m.name(), res.getAccuracy()));
        }

        // --- EXPERIMENT 4: Feature Subsets (Detailed Class Report) ---
        finalReport.append("\n## 4. Impact of Feature Subsets (K=").append(bestK).append(", Metric: EUCLIDEAN, Split: 60/40)\n");
        
        Map<String, BitSet> subsets = new LinkedHashMap<>();
        
        // Subset 1: All features
        subsets.put("All Features (12)", allFeatures);
        
        // Subset 2: Only Numerical (F1-F6, F8, F12 -> indices 0 to 7)
        BitSet onlyNumeric = new BitSet(12); 
        onlyNumeric.set(0, 8);
        subsets.put("Numeric Only (F1-F6, F8, F12)", onlyNumeric);
        
        // Subset 3: Only Textual (F7, F9, F10, F11 -> indices 8 to 11)
        BitSet onlyText = new BitSet(12); 
        onlyText.set(8, 12);
        subsets.put("Textual Only (F7, F9-F11)", onlyText);
        
        // Subset 4: Country-Specific Only (F1-F6 and F11) - Smartest subset
        BitSet countrySpecific = new BitSet(12); 
        countrySpecific.set(0, 6); // F1 to F6 (indices 0-5)
        countrySpecific.set(11);   // F11 (First Country mentioned -> index 11)
        subsets.put("Country-Specific Only (F1-F6, F11)", countrySpecific);

        for (Map.Entry<String, BitSet> entry : subsets.entrySet()) {
            Evaluator res = runTest(allVectors, 0.6, bestK, KNNClassifier.DistanceMetric.EUCLIDEAN, entry.getValue());
            finalReport.append(String.format("\n### Subset: %s\n", entry.getKey()));
            finalReport.append(String.format("**Global Accuracy : %.4f**\n\n", res.getAccuracy()));
            
            // Generate Markdown Table for individual classes
            finalReport.append("| Class Name | Precision | Recall | F1-Score |\n");
            finalReport.append("|------------|-----------|--------|----------|\n");
            
            for (String c : classNames) {
                finalReport.append(String.format("| %-10s | %.4f    | %.4f | %.4f   |\n", 
                        c, res.getPrecision(c), res.getRecall(c), res.getF1Score(c)));
            }
        }

        // FINAL OUTPUT
        System.out.println(finalReport.toString());
        
        // Save to Markdown file
        try (PrintWriter out = new PrintWriter("experiments_report.md")) {
            out.println(finalReport.toString());
            System.out.println("\n>>> Report successfully saved to: experiments_report.md");
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
    }

    /**
     * Helper method to run a single KNN experiment configuration.
     */
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

    /**
     * KNN Classification logic incorporating the feature mask.
     */
    private static String classifyWithMask(FeatureVector test, List<FeatureVector> train, int k, KNNClassifier.DistanceMetric metric, BitSet mask) {
        PriorityQueue<Object[]> pq = new PriorityQueue<>((a, b) -> Double.compare((double)b[1], (double)a[1]));
        
        for (FeatureVector tr : train) {
            double distance = Metrics.calculateDistance(test, tr, metric, mask);
            pq.add(new Object[]{tr.getLabel(), distance});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        Map<String, Integer> classVotes = new HashMap<>();
        while (!pq.isEmpty()) {
            String label = (String)pq.poll()[0];
            classVotes.put(label, classVotes.getOrDefault(label, 0) + 1);
        }
        
        return Collections.max(classVotes.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}