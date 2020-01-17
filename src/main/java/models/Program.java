package models;

import java.util.Date;

public abstract class Program {

    private int programId;
    private String title;
    private int duration;

    public Program() {
    }

    public Program(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Program(int programId, String title, int duration) {
        this.programId = programId;
        this.title = title;
        this.duration = duration;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
