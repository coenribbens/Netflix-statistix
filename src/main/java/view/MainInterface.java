package view;

import datalayer.MovieDAO;
import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Account;
import models.Movie;
import view.account.AccountController;
import view.movie.MovieController;

import java.util.ArrayList;
import java.util.List;

public class MainInterface extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(mainScene(stage));
        stage.show();
    }

    public static Scene mainScene(Stage stage){
        stage.setTitle("Netflix Statistics");

        Tab tabAccount = new Tab("account", accountVbox(stage));
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
        Button buttonVernieuwen = new Button("Vernieuwen");

        //Objecten voor Tableview
        TableView tableView = new TableView();
        TableColumn<String, Account> columnNaam = new TableColumn<>("Naam");
            columnNaam.setCellValueFactory(new PropertyValueFactory<String, Account>("accountName"));
        TableColumn<String, Account> columnStraat = new TableColumn<>("Straat");
            columnStraat.setCellValueFactory(new PropertyValueFactory<String, Account>("streetName"));
        TableColumn<String, Account> columnHuisNummer = new TableColumn<>("Huisnummer");
            columnHuisNummer.setCellValueFactory(new PropertyValueFactory<String, Account>("houseNumber"));
        TableColumn<String, Account> columnPostcode = new TableColumn<>("Postcode");
            columnPostcode.setCellValueFactory(new PropertyValueFactory<String, Account>("zipcode"));
        tableView.getColumns().addAll(columnNaam, columnStraat, columnHuisNummer, columnPostcode);


        //Objecten detailBox
        TextArea detailFilmsBekeken = new TextArea("Bekeken films:\n\n");
            detailFilmsBekeken.setEditable(false);
        TextArea detailSeriesBekeken = new TextArea("Bekeken series:\n\n");
            detailSeriesBekeken.setEditable(false);


        //Controller object aanmaken
        AccountController controller = new AccountController(tableView);
        buttonToevoegen.setOnAction(controller);
        buttonBewerken.setOnAction(controller);
        buttonVerwijderen.setOnAction(controller);
        buttonVernieuwen.setOnAction(controller);

        ToolBar toolBar = new ToolBar();
            toolBar.getItems().addAll(buttonToevoegen, buttonBewerken, buttonVerwijderen, buttonVernieuwen);
        HBox mainContent = new HBox();
            mainContent.getChildren().addAll(tableView);
        HBox detailBox = new HBox();
            detailBox.getChildren().addAll(detailFilmsBekeken, detailSeriesBekeken);

        VBox resultingVbox = new VBox();
            resultingVbox.getChildren().addAll(toolBar, mainContent, detailBox);

        return resultingVbox;
    }

    public static VBox profielVbox(Stage stage){
        return null;
    }

    public static VBox filmVbox(Stage stage){

        // Het toevoegen van Films aan de ChoiceBox!
        ChoiceBox<Movie> choiceBox = new ChoiceBox<Movie>();
        choiceBox.setMinWidth(500);
        MovieDAO movieDAO = new MovieDAO();
        List<Movie> movies = movieDAO.getAllMovies();
        for (Movie movie: movies
             ) {choiceBox.getItems().add(movie);

        }




//        ListView<String> filmTitel = new ListView<String>();
//        filmTitel.getItems().add("titel");
//        ListView<String> filmDuratie = new ListView<String>();
//        filmDuratie.getItems().add("Duratie");
//        ListView<String> filmTaal = new ListView<String>();
//        filmTaal.getItems().add("taal");
//        ListView<String> filmGenre = new ListView<String>();
//        filmGenre.getItems().add("genre");

        TextArea Gemiddeldekijtijd = new TextArea("Gemiddelde kijktijd\n\n");
        Gemiddeldekijtijd.setEditable(false);

        TextArea Bekekendoor = new TextArea("Bekeken door: " + " aantal personen");
        Bekekendoor.setEditable(false);
        Bekekendoor.setMinSize(600,50);
        Gemiddeldekijtijd.setMinSize(600,50);


//
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
        MovieController filmcontroller = new MovieController(tableView);
        choiceBox.setOnAction(filmcontroller);



        return vbox;
    }

    public static VBox serieVbox(Stage stage){
        return null;
    }
}
