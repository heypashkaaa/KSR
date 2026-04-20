package processing;

import java.util.*;


public class KNNClassifier {

    public enum DistanceMetric {
        EUCLIDEAN, 
        MANHATTAN, 
        CHEBYSHEV
    }

    private int k;
    private DistanceMetric metric;
    private List<FeatureVector> trainingSet;

    public KNNClassifier(int k, DistanceMetric metric) {
        this.k = k;
        this.metric = metric;
    }

    
    public void train(List<FeatureVector> trainingSet) {
        this.trainingSet = trainingSet;
    }

   
    public String classify(FeatureVector testVector) {
        if (trainingSet == null || trainingSet.isEmpty()) {
            throw new IllegalStateException("Zbiór uczący jest pusty! Najpierw wywołaj metodę train().");
        }

        List<Neighbor> distances = new ArrayList<>();
        
        for (FeatureVector trainVector : trainingSet) {
            double dist = 0.0;
            
            switch (metric) {
                case EUCLIDEAN:
                    dist = Metrics.euclideanDistance(testVector, trainVector);
                    break;
                case MANHATTAN:
                    dist = Metrics.manhattanDistance(testVector, trainVector);
                    break;
                case CHEBYSHEV:
                    dist = Metrics.chebyshevDistance(testVector, trainVector);
                    break;
            }
            distances.add(new Neighbor(trainVector.getLabel(), dist));
        }

        distances.sort(Comparator.comparingDouble(n -> n.distance));

        Map<String, Integer> classVotes = new HashMap<>();
        
        int limit = Math.min(k, distances.size()); 
        
        for (int i = 0; i < limit; i++) {
            String label = distances.get(i).label;
            classVotes.put(label, classVotes.getOrDefault(label, 0) + 1);
        }

        String bestClass = null;
        int maxVotes = -1;
        
        for (Map.Entry<String, Integer> entry : classVotes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                bestClass = entry.getKey();
            }
        }

        return bestClass;
    }

   
    private static class Neighbor {
        String label;
        double distance;

        Neighbor(String label, double distance) {
            this.label = label;
            this.distance = distance;
        }
    }
}