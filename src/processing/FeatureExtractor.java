package processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Article;

public class FeatureExtractor {

    private static final Set<String> STOP_WORDS = Set.of(
            "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours", "yourself", "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its", "itself", "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that", "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having", "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while", "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before", "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again", "further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each", "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than", "too", "very", "s", "t", "can", "will", "just", "don", "should", "now", "said", "reuters"
    );

    public FeatureVector extractFeatures(Article article) {
        String text = article.getText();
        String label = article.getLabel();

        // empty texts
        if (text == null || text.trim().isEmpty()) {
            return new FeatureVector(new double[9], new String[]{"", ""}, label);
        }

        String[] rawWords = text.split("\\s+");

        List<String> cleanWords = new ArrayList<>();
        double uppercaseWordCount = 0;
        double digitWordCount = 0;
        double keywordExportCount = 0;
        double keywordDlrsCount = 0;
        double keywordBankCount = 0;
        String longestWord = "";

        for (String word : rawWords) {
            // 1. Numerical counts that rely on the raw words
            if (word.matches("[A-Z]+")) uppercaseWordCount++;
            if (word.matches(".*\\d+.*")) digitWordCount++;
            
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            if (cleanWord.equals("export")) keywordExportCount++;
            if (cleanWord.equals("dlrs")) keywordDlrsCount++;
            if (cleanWord.equals("bank")) keywordBankCount++;

            // removing stopwords
            if (!cleanWord.isEmpty() && !STOP_WORDS.contains(cleanWord)) {
                cleanWords.add(cleanWord);
                
                // Find the longest meaningful word
                if (cleanWord.length() > longestWord.length()) {
                    longestWord = cleanWord;
                }
            }
        }

        // --- Numerical Features
        double totalChars = text.length();
        double totalMeaningfulWords = cleanWords.size();
        double avgWordLength = totalMeaningfulWords > 0 ? totalChars / totalMeaningfulWords : 0;
        double sentenceCount = text.split("\\.\\s+").length;

        double[] numericalFeatures = {
            totalChars,          // Feature 1
            totalMeaningfulWords,// Feature 2
            avgWordLength,       // Feature 3
            sentenceCount,       // Feature 4
            uppercaseWordCount,  // Feature 5
            digitWordCount,      // Feature 6
            keywordExportCount,  // Feature 7
            keywordDlrsCount,    // Feature 8
            keywordBankCount     // Feature 9
        };

        // --- Textual Features
        // first MEANINGFUL word of the text 
        String firstWord = cleanWords.isEmpty() ? "" : cleanWords.get(0);
        
        // longest MEANINGFUL word 
        String[] textualFeatures = {
            firstWord, 
            longestWord
        };

        return new FeatureVector(numericalFeatures, textualFeatures, label);
    }
}