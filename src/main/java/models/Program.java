package models;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public abstract class Program {

    private int programId;
    private String title;
    private String duration;

    public Program() {
    }

    public Program(String title, String duration) {
        isDurationValid(duration);{ // Controleert of de duration een getal is.

        this.title = title;
        this.duration = duration;
    }}

    public Program(int programId, String title, String duration) {
        isDurationValid(duration);{
        this.programId = programId;
        this.title = title;
        this.duration = duration;
    }}

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        if(isDurationValid(duration)){
        this.duration = duration;
    } }

    public boolean isDurationValid(String duration) { // Controleert of duration een getal is.
        boolean isDurationValid = true;

        try {
           Integer.parseInt(duration);

        } catch (NumberFormatException E){
            isDurationValid = false;
            System.out.println(duration + " is not a valid number");
        }
    return isDurationValid;}
}
