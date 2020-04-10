package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    @Test
    void testIsHouseNumberValidWithInValidDataReturnsFalse() {
        //Arrange
        Account account = new Account();
        //Act
        boolean returnValue = account.isHouseNumberValid("Vijf A"); //Ongeldig huisnummer
        //Assert
        Assertions.assertFalse(returnValue);


    }

    @Test
    void testSetAccountIdWithValidDataReturnsTrue() {
        //Arrange
        Account account = new Account();
        //Act
        account.setAccountId(1);
        //Assert
        Assertions.assertEquals(1, account.getAccountId());
    }


}