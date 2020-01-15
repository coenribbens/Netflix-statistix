import Database.DatabaseConnection;
import Interface.BeginnersInterface;
import Interface.UserInterface;


public class main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection("jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=NetflixStatitics;integratedSecurity=true;");
        new Thread() { //Hiermee wordt de beginnersinterface geladen.
            @Override
            public void run() {
                javafx.application.Application.launch(BeginnersInterface.class);


            }
        }.start();





    }


}
