package loader;

import model.Article;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class DocumentLoader {

    // Country labels
    private static final Set<String> ALLOWED_PLACES = Set.of(
            "west-germany", "usa", "france", "uk", "canada", "japan"
    );


    public List<Article> loadFromDirectory(String directoryPath) {
        List<Article> loadedArticles = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            paths.filter(Files::isRegularFile)
                 .filter(p -> p.toString().endsWith(".sgm"))
                 .forEach(path -> {
                     try {
                        // bcs this file 'data\reut2-017.sgm' is not utf-8
                         String content = Files.readString(path, java.nio.charset.StandardCharsets.ISO_8859_1);
                         loadedArticles.addAll(extractArticles(content));
                     } catch (IOException e) {
                         System.err.println("Could not read file: " + path);
                     }
                 });
        } catch (IOException e) {
            System.err.println("Error reading directory: " + directoryPath);
        }

        return loadedArticles;
    }


    private List<Article> extractArticles(String fileContent) {
        List<Article> articles = new ArrayList<>();

        // Regex to find everything between <REUTERS> and </REUTERS>
        Pattern reutersPattern = Pattern.compile("<REUTERS.*?</REUTERS>", Pattern.DOTALL);
        Matcher reutersMatcher = reutersPattern.matcher(fileContent);

        while (reutersMatcher.find()) {
            String reutersBlock = reutersMatcher.group();

            // 1. Extract <PLACES>
            String placesContent = extractTagContent(reutersBlock, "<PLACES>", "</PLACES>");
            List<String> placesList = extractAllTags(placesContent, "<D>", "</D>");

            // Only one label from the ones weneed 
            if (placesList.size() == 1) {
                String label = placesList.get(0).toLowerCase();
                
                if (ALLOWED_PLACES.contains(label)) {
                    String bodyText = extractTagContent(reutersBlock, "<BODY>", "</BODY>");
                    
                    if (bodyText != null && !bodyText.trim().isEmpty()) {
                        bodyText = bodyText.replace("&#3;", "").trim();
                        articles.add(new Article(bodyText, label));
                    }
                }
            }
        }
        return articles;
    }


    private String extractTagContent(String text, String startTag, String endTag) {
        int startIndex = text.indexOf(startTag);
        if (startIndex == -1) return null;
        startIndex += startTag.length();
        
        int endIndex = text.indexOf(endTag, startIndex);
        if (endIndex == -1) return null;
        
        return text.substring(startIndex, endIndex);
    }

    private List<String> extractAllTags(String text, String startTag, String endTag) {
        List<String> results = new ArrayList<>();
        if (text == null) return results;

        int currentIndex = 0;
        while (true) {
            int startIndex = text.indexOf(startTag, currentIndex);
            if (startIndex == -1) break;
            startIndex += startTag.length();

            int endIndex = text.indexOf(endTag, startIndex);
            if (endIndex == -1) break;

            results.add(text.substring(startIndex, endIndex));
            currentIndex = endIndex + endTag.length();
        }
        return results;
    }
}