package models;

public class Episode extends Program {

    private int season;

    public Episode() {
    }

    public Episode(String title, int duration, int season) {
        super(title, duration);
        this.season = season;
    }

    public Episode(int programId, String title, int duration, int season) {
        super(programId, title, duration);
        this.season = season;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String toString() {
      return this.getTitle();
    }
}
