package processing;

import java.util.*;
import model.Article;

public class FeatureExtractor {

    private static final Set<String> STOP_WORDS = Set.of(
        "reuters", "said", "pct", "percent", "mln", "million", "bln", "billion", "january", "february", 
        "march", "april", "may", "june", "july", "august", "september", "october", "november", "december",
        "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours", "yourself", 
        "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its", "itself", 
        "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that", 
        "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", 
        "having", "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", 
        "until", "while", "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", 
        "during", "before", "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", 
        "over", "under", "again", "further", "then", "once", "here", "there", "when", "where", "why", "how", 
        "all", "any", "both", "each", "few", "more", "most", "other", "some", "such", "no", "nor", "not", 
        "only", "own", "same", "so", "than", "too", "very", "s", "t", "can", "will", "just", "don", "should", "now", "reuter"
    );

    private static final Set<String> POLITICIANS = Set.of(
        "kohl", "genscher", "stoltenberg", "strauss", "weizsaecker",
        "thatcher", "lawson", "hurd", "howe", "tebbit",
        "mulroney", "wilson", "chretien", "broadbent"
    );

    private static final Set<String> CITIES = Set.of(
         "frankfurt", "bonn", "hamburg", "munich", "stuttgart", "dusseldorf", "cologne", "essen", "bremen", "berlin",
        "london", "birmingham", "manchester", "glasgow", "liverpool", "bristol", "edinburgh",
        "ottawa", "toronto", "montreal", "calgary", "vancouver", "winnipeg", "edmonton", "hamilton", "quebec", "halifax" 
    );

    private static final Set<String> DATELINE_CITIES = Set.of(
         "washington", "new york","chicago","los angeles","san francisco","boston","atlanta","dallas","houston","philadelphia","miami", "london", "birmingham", "glasgow", "edinburgh",
        "manchester","liverpool","bristol", "bonn", "frankfurt", "munich",
        "hamburg", "berlin", "dusseldorf", "stuttgart", "cologne", "essen", "bremen",
         "ottawa", "toronto", "montreal", "vancouver", "calgary", "winnipeg","edmonton", "hamilton", "quebec", "halifax",
         "paris", "lyon", "marseille", "strasbourg", "tokyo", "osaka", "yokohama", "nagoya"
    );

    private static final List<String> CURRENCIES = Arrays.asList("ypy", "frf", "dem", "cad", "usd", "gbp");

    private static final Set<String> KW_JAPAN = Set.of("japan", "japanese", "japans", "japan's");
    private static final Set<String> KW_GERMANY = Set.of("west germany", "west german", "west german's");
    private static final Set<String> KW_USA = Set.of("usa", "us", "u.s.", "america", "american");
    private static final Set<String> KW_FRANCE = Set.of("france", "french");
    private static final Set<String> KW_UK = Set.of("uk", "british", "britain", "england");
    private static final Set<String> KW_CANADA = Set.of("canada", "canadian");

    public FeatureVector extractFeatures(Article article) {
        String text = article.getText();
        String label = article.getLabel();

        if (text == null || text.trim().isEmpty()) {
            return new FeatureVector(new double[8], new String[]{"None", "None", "None", "None"}, label);
        }

        String lowerText = text.toLowerCase();
        lowerText = lowerText.replace("west germany", "west_germany")
                             .replace("west german", "west_german")
                             .replace("new york", "new_york")
                             .replace("los angeles", "los_angeles")
                             .replace("san francisco", "san_francisco");

        String[] rawWords = lowerText.split("[^a-z0-9_\\.\\']+");
        List<String> cleanWords = new ArrayList<>();
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : rawWords) {
            if (word.endsWith(".") && !word.equals("u.s.")) {
                word = word.substring(0, word.length() - 1);
            }
            if (!word.isEmpty() && !STOP_WORDS.contains(word)) {
                cleanWords.add(word);
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        double totalWords = cleanWords.size();
        if (totalWords == 0) totalWords = 1; 

        // --- Zmienne pomocnicze dla cech liczbowych ---
        double countJapan = 0, countGermany = 0, countUsa = 0, countFrance = 0, countUk = 0, countCanada = 0;
        double countPoliticians = 0, countCities = 0;

        // --- Zmienne pomocnicze dla cech tekstowych ---
        Map<String, Integer> currencyCount = new HashMap<>();
        for (String c : CURRENCIES) currencyCount.put(c, 0);
        
        String firstCountry = "None";
        String mostFrequentWord = "None";
        int maxFreq = 0;

        for (String w : cleanWords) {
            if (KW_JAPAN.contains(w)) {
                countJapan++;
                if (firstCountry.equals("None")) firstCountry = "japan";
            } else if (KW_GERMANY.contains(w.replace("_", " "))) {
                countGermany++;
                if (firstCountry.equals("None")) firstCountry = "west-germany";
            } else if (KW_USA.contains(w)) {
                countUsa++;
                if (firstCountry.equals("None")) firstCountry = "usa";
            } else if (KW_FRANCE.contains(w)) {
                countFrance++;
                if (firstCountry.equals("None")) firstCountry = "france";
            } else if (KW_UK.contains(w)) {
                countUk++;
                if (firstCountry.equals("None")) firstCountry = "uk";
            } else if (KW_CANADA.contains(w)) {
                countCanada++;
                if (firstCountry.equals("None")) firstCountry = "canada";
            }

            if (POLITICIANS.contains(w)) countPoliticians++;
            if (CITIES.contains(w.replace("_", " "))) countCities++;

            if (currencyCount.containsKey(w)) {
                currencyCount.put(w, currencyCount.get(w) + 1);
            }

            int freq = wordFrequency.get(w);
            if (freq > maxFreq) {
                maxFreq = freq;
                mostFrequentWord = w;
            }
        }

        double[] numericalFeatures = {
            countJapan / totalWords,
            countGermany / totalWords,
            countUsa / totalWords,
            countFrance / totalWords,
            countUk / totalWords,
            countCanada / totalWords,
            countPoliticians / totalWords,
            countCities / totalWords
        };

        String bestCurrency = "None";
        int maxCurrCount = 0;
        for (Map.Entry<String, Integer> entry : currencyCount.entrySet()) {
            if (entry.getValue() > maxCurrCount) {
                maxCurrCount = entry.getValue();
                bestCurrency = entry.getKey();
            }
        }

        String datelineCity = "None";
        String rawDateline = article.getDateline();

        if (rawDateline != null && !rawDateline.trim().isEmpty()) {
            String extractedCity = rawDateline.split(",")[0].trim().toLowerCase();
            
            if (DATELINE_CITIES.contains(extractedCity)) {
                datelineCity = extractedCity.toUpperCase();
            }
        }

        String[] textualFeatures = {
            bestCurrency.toUpperCase(),   // F7
            datelineCity,                 // F9
            mostFrequentWord,             // F10
            firstCountry.toUpperCase()    // F11
        };

        return new FeatureVector(numericalFeatures, textualFeatures, label);
    }
}