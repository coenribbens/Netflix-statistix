package models;

import java.util.ArrayList;

public class AccountProfiles {
    private String profileName;
    private String profilePicture;
    private ArrayList<Program> programsWatched;


    public AccountProfiles(String profileName, String profilePicture) {
        this.profileName = profileName;
        this.profilePicture = profilePicture;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
