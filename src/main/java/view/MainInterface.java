package view;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Movie;

public class MainInterface extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(mainScene(stage));
        stage.show();
    }

    public static Scene mainScene(Stage stage){
        stage.setTitle("Netflix Statistics");
        stage.resizableProperty();

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
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.setMinWidth(500);


        ListView<String> filmTitel = new ListView<String>();
        filmTitel.getItems().add("titel");
        ListView<String> filmDuratie = new ListView<String>();
        filmDuratie.getItems().add("Duratie");
        ListView<String> filmTaal = new ListView<String>();
        filmTaal.getItems().add("taal");
        ListView<String> filmGenre = new ListView<String>();
        filmGenre.getItems().add("genre");

        TextArea Gemiddeldekijtijd = new TextArea("Gemiddelde kijktijd\n\n");
        Gemiddeldekijtijd.setEditable(false);

        TextArea Bekekendoor = new TextArea("Bekeken door: " + " aantal personen");
        Bekekendoor.setEditable(false);
        Bekekendoor.setMinSize(600,50);
        Gemiddeldekijtijd.setMinSize(600,50);



        HBox textgebieden = new HBox();
        textgebieden.setSpacing(10);
        textgebieden.getChildren().addAll(Gemiddeldekijtijd,Bekekendoor);

//
        TableView tableView = new TableView();
        tableView.setMinWidth(1300);


        TableColumn<String, Movie> kolumnFilmtitel = new TableColumn<>("Filmtitel");
        kolumnFilmtitel.setCellValueFactory(new PropertyValueFactory<String, Movie>("title"));

        TableColumn<Integer, Movie> kolumnFilmDuratie = new TableColumn<>("FilmDuratie");
        kolumnFilmDuratie.setCellValueFactory(new PropertyValueFactory<Integer, Movie>("duration"));

        TableColumn<String, Movie> kolumnFilmGenre = new TableColumn<>("FilmGenre");
        kolumnFilmGenre.setCellValueFactory(new PropertyValueFactory<String, Movie>("Genre"));

        TableColumn<String, Movie> kolumnFilmTaal = new TableColumn<>("FilmTaal");
        kolumnFilmTaal.setCellValueFactory(new PropertyValueFactory<String, Movie>("language"));

        TableColumn<Integer, Movie> kolumnFilmAgerating = new TableColumn<>("FilmAgeRating");
        kolumnFilmAgerating.setCellValueFactory(new PropertyValueFactory<Integer, Movie>("ageRating"));


        tableView.getColumns().addAll(kolumnFilmtitel,kolumnFilmDuratie,kolumnFilmGenre, kolumnFilmTaal, kolumnFilmAgerating);
        tableView.setMaxSize(500,900);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Movie xx = new Movie("De smurfen", 30, "horror", "Frans", 18);
        tableView.getItems().add(xx);


        HBox choiceBoxhbox = new HBox();
        choiceBoxhbox.getChildren().add(choiceBox);
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(choiceBoxhbox,tableView,textgebieden);

        return vbox;
    }

    public static VBox serieVbox(Stage stage){
        return null;
    }
}
