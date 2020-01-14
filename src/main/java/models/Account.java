package models;

import java.util.ArrayList;
import java.util.UUID;

public class Account {
    private UUID accountId;
    private String accountName;
    private String streetName;
    private String zipcode;

    public Account() {
    }

    public Account(UUID accountId, String accountName, String streetName, String zipcode) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.streetName = streetName;
        this.zipcode = zipcode;
    }

    public Account(String accountName, String streetName, String zipcode) {
        this.accountName = accountName;
        this.streetName = streetName;
        this.zipcode = zipcode;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}