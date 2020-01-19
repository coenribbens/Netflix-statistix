package models;

import datalayer.MysqlDAO;
import javafx.stage.Stage;
import view.MainInterface;

import javax.swing.*;
import java.sql.Connection;
import view.MainInterface;

public class main {
    public static void main(String args[]) {
        Connection conn;
        Stage stage = new Stage();

        if (MysqlDAO.getInstance().connect() != null) {
            MainInterface mainInterface = new MainInterface();
            javafx.application.Application.launch(MainInterface.class);
        } else {
            System.out.println("Geen database connection");
        }

    }
}
