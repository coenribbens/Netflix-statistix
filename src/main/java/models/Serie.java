package models;

import java.util.ArrayList;

public class Serie {

    private int serieId;
    private String name;
    private int ageRating;
    private String language;
    private String genre;
    private String suggestions;
    private ArrayList<Episode> Episodes;

    public Serie() {
    }

    public Serie(String name, int ageRating,  String genre, String suggestions) {
        this.name = name;
        this.ageRating = ageRating;

        this.genre = genre;
        this.suggestions = suggestions;
        this.Episodes = Episodes;
    }

    public Serie(int serieId, String name, int ageRating,  String genre, String suggestions) {
        this.serieId = serieId;
        this.name = name;
        this.ageRating = ageRating;

        this.genre = genre;
        this.suggestions = suggestions;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
