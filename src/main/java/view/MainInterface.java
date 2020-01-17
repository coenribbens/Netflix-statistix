package view;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Serie;

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
        return null;
    }

    public static VBox filmVbox(Stage stage){
        return null;
    }

    public static VBox serieVbox(Stage stage){
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.setMinWidth(500);




        TextArea Gemiddeldekijtijd = new TextArea("Gemiddelde kijktijd\n\n");
        Gemiddeldekijtijd.setEditable(false);

        TextArea Bekekendoor = new TextArea("Gemiddeld aantal bekeken afleveringen");
        Bekekendoor.setEditable(false);
        Bekekendoor.setMinSize(600,50);
        Gemiddeldekijtijd.setMinSize(600,50);



        HBox textgebieden = new HBox();
        textgebieden.setSpacing(10);
        textgebieden.getChildren().addAll(Gemiddeldekijtijd,Bekekendoor);

//
        TableView tableView = new TableView();
        tableView.setMinWidth(1300);


        TableColumn<String, Serie> kolumnSerietitel = new TableColumn<>("Titel");
        kolumnSerietitel.setCellValueFactory(new PropertyValueFactory<String, Serie>("name"));

        TableColumn<Integer, Serie> kolumnSeriesuggestions = new TableColumn<>("Suggesties");
        kolumnSeriesuggestions.setCellValueFactory(new PropertyValueFactory<Integer, Serie>("suggestions"));

        TableColumn<String, Serie> kolumnSerieSeizoen = new TableColumn<>("Seizoen");
        kolumnSerieSeizoen.setCellValueFactory(new PropertyValueFactory<String, Serie>("genre"));

        TableColumn<String, Serie> kolumnSerieTaal = new TableColumn<>("Genre");
        kolumnSerieTaal.setCellValueFactory(new PropertyValueFactory<String, Serie>("language"));

        TableColumn<Integer, Serie> kolumnFilmAgerating = new TableColumn<>("FilmAgeRating");
        kolumnFilmAgerating.setCellValueFactory(new PropertyValueFactory<Integer, Serie>("ageRating"));


        tableView.getColumns().addAll(kolumnSerietitel,kolumnSerieSeizoen, kolumnSerieTaal, kolumnFilmAgerating);
        tableView.setMaxSize(500,900);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Serie xx = new Serie("De smurfen", 30, "Frans", "Kinder", "Lalala");
        tableView.getItems().add(xx);


        HBox choiceBoxhbox = new HBox();
        choiceBoxhbox.getChildren().add(choiceBox);
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(choiceBoxhbox,tableView,textgebieden);
        return vbox;

    }
}
