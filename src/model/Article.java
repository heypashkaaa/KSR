package model;

/**
 * Represents a single text document from the Reuters dataset.
 */
public class Article {
    
   
    private String text;  
    private String label; 

  
    public Article(String text, String label) {
        this.text = text;
        this.label = label;
    }

  

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    @Override
    public String toString() {
        return "Article{" +
                "label='" + label + '\'' +
                ", textLength=" + (text != null ? text.length() : 0) +
                " characters}";
    }
}