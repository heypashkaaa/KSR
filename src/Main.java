import loader.DocumentLoader;
import model.Article;
import processing.FeatureExtractor;
import processing.FeatureVector;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting Reuters Document Loader...");

        DocumentLoader loader = new DocumentLoader();

        String dataDirectoryPath = "data"; 

        System.out.println("Scanning directory: " + dataDirectoryPath + " for .sgm files...");
        List<Article> articles = loader.loadFromDirectory(dataDirectoryPath);

        System.out.println("\n--- Loading Complete ---");
        System.out.println("Total valid articles found: " + articles.size());
        System.out.println("\nFirst 5 articles extracted:");
        for (int i = 0; i < Math.min(5, articles.size()); i++) {
            System.out.println((i + 1) + ". " + articles.get(i).toString());
            FeatureExtractor extractor = new FeatureExtractor();
            System.out.println("\nExtracting features for the article...");
            FeatureVector vec = extractor.extractFeatures(articles.get(i));
            System.out.println(vec.toString());
        }
    }
}