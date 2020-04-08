package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    void TestIsDurationValidWithUnvalidDurationTypeReturnsFalse() {
        //Arrange
        Episode episode = new Episode();
        //Act
        boolean returnValue = episode.isDurationValid("Twintig minuten"); //Ongeldige data, moet een getal zijn in String-vorm.
        //Assert
        Assertions.assertFalse(returnValue);
    }
}