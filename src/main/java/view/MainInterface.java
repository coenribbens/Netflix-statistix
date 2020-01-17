package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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

        //Objecten detailBox
        TextArea detailFilmsBekeken = new TextArea("Bekeken films:\n\n");
            detailFilmsBekeken.setEditable(false);
        TextArea detailSeriesBekeken = new TextArea("Bekeken series:\n\n");
        detailSeriesBekeken.setEditable(false);

        //Objecten leftPanel
        Button buttonAccount = new Button("Account");
            buttonAccount.setDisable(true);
        Button buttonProfiel = new Button("Profiel");
        Button buttonFilm = new Button("Film");
        Button buttonSerie = new Button("Serie");

        //Objecten toolBar
        Button buttonToevoegen = new Button("Toevoegen");
        Button buttonBewerken = new Button("Bewerken");
        Button buttonVerwijderen = new Button("Verwijderen");



        VBox leftPanel = new VBox();
            leftPanel.getChildren().addAll(buttonAccount, buttonProfiel, buttonFilm, buttonSerie);
        HBox listView = new HBox();
            listView.getChildren().addAll(accountNaam, accountStraat, accountHuisNummer, accountPostcode, accountWoonplaats);
        HBox detailBox = new HBox();
            detailBox.getChildren().addAll(detailFilmsBekeken, detailSeriesBekeken);
        VBox centerView = new VBox();
            centerView.getChildren().addAll(listView, detailBox);
        HBox toolBar = new HBox();
            toolBar.getChildren().addAll(buttonToevoegen, buttonBewerken, buttonVerwijderen);
            toolBar.setAlignment(Pos.CENTER_RIGHT);

        BorderPane mainBP = new BorderPane();
            mainBP.setCenter(centerView);
            mainBP.setLeft(leftPanel);
            mainBP.setTop(toolBar);


        Scene scene = new Scene(mainBP);
        return scene;
    }
}
