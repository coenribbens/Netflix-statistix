package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainInterface extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(accountScene(stage));
        stage.show();
    }

    public static Scene accountScene(Stage stage){
        stage.setTitle("Netflix Statistics - Account");

        //Objecten voor de listView
        ListView<String> accountNaam = new ListView<String>();
            accountNaam.getItems().add("Naam");
        ListView<String> accountStraat = new ListView<String>();
            accountStraat.getItems().add("Straat");
        ListView<String> accountHuisNummer = new ListView<String>();
            accountHuisNummer.getItems().add("HuisNummer");
        ListView<String> accountPostcode = new ListView<String>();
            accountPostcode.getItems().add("Postcode");
        ListView<String> accountWoonplaats = new ListView<String>();
            accountWoonplaats.getItems().add("Woonplaats");

        //Objecten leftPanel
        Button buttonAccount = new Button("Account");



        BorderPane mainBP = new BorderPane();
        VBox leftPanel = new VBox();
        mainBP.setLeft(leftPanel);
        HBox listView = new HBox();
            listView.getChildren().addAll(accountNaam, accountStraat, accountHuisNummer, accountPostcode, accountWoonplaats);
        mainBP.setCenter(listView);


        Scene scene = new Scene(mainBP);
        return scene;
    }
}
