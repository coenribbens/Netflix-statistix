package models;

import java.sql.Date;

public class Profile {

    private int profileId;
    private String profileName;
    private Date dateOfBirth;
    private int accountId;

    public Profile() {
    }

    public Profile(String profileName, Date dateOfBirth) {
        this.profileName = profileName;
        this.dateOfBirth = dateOfBirth;
    }

    public Profile(String profileName, Date dateOfBirth, int profileId, int accountId) {
        this.profileName = profileName;
        this.dateOfBirth = dateOfBirth;
        this.profileId = profileId;
        this.accountId = accountId;
    }

    public Profile(int profileId, String profileName, Date dateOfBirth, int accountId) {
        this.profileId = profileId;
        this.profileName = profileName;
        this.dateOfBirth = dateOfBirth;
        this.accountId = accountId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
