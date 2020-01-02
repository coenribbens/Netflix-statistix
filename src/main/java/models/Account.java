package models;

import java.util.ArrayList;
import java.util.UUID;

public class Account {
    private UUID accountId;
    private String accountName;
    private String profilePicture;
    private ArrayList<AccountProfiles> profiles;
    private String accountPassword;


    //Start of constructor
    public Account(String accountName, String profilePicture, ArrayList<AccountProfiles> profiles) {
        this.accountName = accountName;
        this.profilePicture = profilePicture;
        this.profiles = profiles;
    }


    //Getters and setter for the class
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public ArrayList<AccountProfiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<AccountProfiles> profiles) {
        this.profiles = profiles;
    }
}
