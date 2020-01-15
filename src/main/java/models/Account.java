package models;

import java.util.ArrayList;
import java.util.UUID;

public class Account {
    private int accountId;
    private String accountName;
    private String streetName;
    private String houseNumber;
    private String zipcode;

    public Account() {
    }

    public Account(int accountId, String accountName, String streetName, String houseNumber, String zipcode) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
    }

    public Account(String accountName, String streetName, String houseNumber, String zipcode) {
        this.accountName = accountName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
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

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

}