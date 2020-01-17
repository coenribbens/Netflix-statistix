package view;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainInterface extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(mainScene(stage));
        stage.show();
    }

    public static Scene mainScene(Stage stage){
        stage.setTitle("Netflix Statistics");

        Tab tabAccount = new Tab("Account", accountVbox(stage));
            tabAccount.setClosable(false);
        Tab tabProfiel = new Tab("Profiel", profielVbox(stage));
            tabProfiel.setClosable(false);
        Tab tabFilm = new Tab("Film", filmVbox(stage));
            tabFilm.setClosable(false);
        Tab tabSerie = new Tab("Serie", serieVbox(stage));
            tabSerie.setClosable(false);
        TabPane mainTP = new TabPane();
            mainTP.getTabs().addAll(tabAccount, tabProfiel, tabFilm, tabSerie);
            mainTP.setSide(Side.LEFT);


        Scene scene = new Scene(mainTP);
        return scene;
    }

    public static VBox accountVbox(Stage stage){
        //Objecten toolBar
        Button buttonToevoegen = new Button("Toevoegen");
        Button buttonBewerken = new Button("Bewerken");
        Button buttonVerwijderen = new Button("Verwijderen");

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


        ToolBar toolBar = new ToolBar();
            toolBar.getItems().addAll(buttonToevoegen, buttonBewerken, buttonVerwijderen);
        HBox listView = new HBox();
            listView.getChildren().addAll(accountNaam, accountStraat, accountHuisNummer, accountPostcode, accountWoonplaats);
        HBox detailBox = new HBox();
            detailBox.getChildren().addAll(detailFilmsBekeken, detailSeriesBekeken);

        VBox resultingVbox = new VBox();
            resultingVbox.getChildren().addAll(toolBar, listView, detailBox);

        return resultingVbox;
    }

    public static VBox profielVbox(Stage stage){
        //Objecten toolBar
        ChoiceBox<String> choiceBoxNaam = new ChoiceBox<>();
        Button buttonToevoegen = new Button("Toevoegen");
        Button buttonBewerken = new Button("Bewerken");
        Button buttonVerwijderen = new Button("Verwijderen");

        //Objecten voor de listView
        ListView<String> profielNaam = new ListView<String>();
        profielNaam.getItems().add("Naam");
        ListView<String> profielGeboorteDatum = new ListView<String>();
        profielGeboorteDatum.getItems().add("Geboortedatum");

        ToolBar toolBar = new ToolBar();
        toolBar.getItems().addAll(choiceBoxNaam, buttonToevoegen, buttonBewerken, buttonVerwijderen);
        HBox listView = new HBox();
        listView.getChildren().addAll(profielNaam, profielGeboorteDatum);

        VBox resultingVbox = new VBox();
        resultingVbox.getChildren().addAll(toolBar, listView);

        return resultingVbox;
    }

    public static VBox filmVbox(Stage stage){
        return null;
    }

    public static VBox serieVbox(Stage stage){
        return null;
    }
}
