package models;

import datalayer.MysqlDAO;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainInterface;

import javax.swing.*;
import java.sql.Connection;
import view.MainInterface;

public class main {
    public static void main(String args[]) {
        Connection conn;


        new Thread() {
            @Override
            public void run() {
                Application.launch(MainInterface.class);
            }
        }.start();

        if (MysqlDAO.getInstance().connect() != null) {
            new Thread() {
                @Override
                public void run() {
                    Application.launch(MainInterface.class);
                }
            }.start();
        } else {
            System.out.println("Unable to connect to the database");
        }

    }
}
