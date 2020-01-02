package models;

import java.util.Date;

public class Program {
    private String programName;
    private int runTimeInMinutes;
    private Date releasedIn;

    //Full constructor
    public Program(String programName, int runTimeInMinutes, Date releasedIn) {
        this.programName = programName;
        this.runTimeInMinutes = runTimeInMinutes;
        this.releasedIn = releasedIn;
    }
    //Extra constructor in case relase date isn't known.
    public Program(String programName, int runTimeInMinutes) {
        this.programName = programName;
        this.runTimeInMinutes = runTimeInMinutes;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getRunTimeInMinutes() {
        return runTimeInMinutes;
    }

    public void setRunTimeInMinutes(int runTimeInMinutes) {
        this.runTimeInMinutes = runTimeInMinutes;
    }

    public Date getReleasedIn() {
        return releasedIn;
    }

    public void setReleasedIn(Date releasedIn) {
        this.releasedIn = releasedIn;
    }
}
