package models;

public class Movie extends Program {

    private String genre;
    private String language;
    private int ageRating;

    public Movie() {
    }

    public Movie(String title, String duration, String genre, String language, int ageRating) {
        super(title, duration);
        this.genre = genre;
        this.language = language;
        this.ageRating = ageRating;
    }

    public Movie(int programId, String title, String duration, String genre, String language, int ageRating) {
        super(programId, title, duration);
        this.genre = genre;
        this.language = language;
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }
}
