package models;

import view.Toast;

import javax.persistence.criteria.CriteriaBuilder;
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
        if (isHouseNumberValid(houseNumber)) // controleert eerst of huisnummer geldig is.
        this.accountId = accountId;
        this.accountName = accountName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
    }

    public Account(String accountName, String streetName, String houseNumber, String zipcode) {
        if (isHouseNumberValid(houseNumber)) // controleert eerst of huisnummer geldig is.
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
        if (isHouseNumberValid(houseNumber)){
            this.houseNumber = houseNumber;
        }}

    public boolean isHouseNumberValid (String houseNumber){

        if (Character.isDigit(houseNumber.charAt(0)))
        {
            return true;
        }
        else {
            System.out.println("Invalid housenumber, first character should be a number.");
            return false; // Kan hier helaas geen Exeption bij throwen.



        }


    }

    public String toString(){
        return getAccountName();
    }

}