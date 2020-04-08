package view;

import datalayer.MovieDAO;
import datalayer.ProfileDAO;
import datalayer.SerieDAO;
import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import models.*;
import view.account.AccountController;
import view.movie.MovieController;
import view.movie.MovieController2;
import view.serie.SerieController;
import view.serie.SerieController2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Account;
import view.account.AccountController;
import models.Profile;
import view.account.AccountController;
import view.profiel.ProfielController;
import view.serie.SerieControllerTextArea;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

public class MainInterface extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(mainScene(stage));
        stage.setMinHeight(500);
        stage.setHeight(700);
        stage.setMinWidth(700);
        stage.setWidth(1400);
        stage.show();
    }

    public static Scene mainScene(Stage stage){
        stage.setTitle("Netflix Statistics - Marcello Haddeman 2152991, Thomas Meeusen 2151718, Coen Ribbens 2151482");

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
        Label filterLabel = new Label("Filter:");
        ChoiceBox<String> choiceBoxFilter = new ChoiceBox<>();
            choiceBoxFilter.getItems().addAll("", "Accounts met 1 profiel");
            choiceBoxFilter.getSelectionModel().selectFirst();
        Button buttonZoek = new Button("Zoek");
            buttonZoek.setTooltip(new Tooltip("Zoek voor accounts met de filter"));
        Button buttonToevoegen = new Button("Toevoegen");
        Button buttonBewerken = new Button("Bewerken");
        Button buttonVerwijderen = new Button("Verwijderen");
        Button buttonVernieuwen = new Button("Vernieuwen");

        //Objecten voor Tableview
        TableView tableView = new TableView();
            tableView.setMinWidth(650);
        TableColumn<String, Account> columnNaam = new TableColumn<>("Naam");
            columnNaam.setCellValueFactory(new PropertyValueFactory<String, Account>("accountName"));
        TableColumn<String, Account> columnStraat = new TableColumn<>("Straat");
            columnStraat.setCellValueFactory(new PropertyValueFactory<String, Account>("streetName"));
        TableColumn<String, Account> columnHuisNummer = new TableColumn<>("Huisnummer");
            columnHuisNummer.setCellValueFactory(new PropertyValueFactory<String, Account>("houseNumber"));
        TableColumn<String, Account> columnPostcode = new TableColumn<>("Postcode");
            columnPostcode.setCellValueFactory(new PropertyValueFactory<String, Account>("zipcode"));
        tableView.getColumns().addAll(columnNaam, columnStraat, columnHuisNummer, columnPostcode);

        //Controller object aanmaken
        AccountController controller = new AccountController(tableView, choiceBoxFilter);
        buttonZoek.setOnAction(controller);
        buttonToevoegen.setOnAction(controller);
        buttonBewerken.setOnAction(controller);
        buttonVerwijderen.setOnAction(controller);
        buttonVernieuwen.setOnAction(controller);

        ToolBar toolBar = new ToolBar();
        toolBar.getItems().addAll(filterLabel, choiceBoxFilter, buttonZoek, buttonToevoegen, buttonBewerken, buttonVerwijderen, buttonVernieuwen);
        HBox mainContent = new HBox();
            mainContent.getChildren().addAll(tableView);

        VBox resultingVbox = new VBox();
            resultingVbox.getChildren().addAll(toolBar, mainContent);


        return resultingVbox;
    }

    public static VBox profielVbox(Stage stage){
              //Objecten toolBar
        Label choiceBoxLabel = new Label("Account:");
        ChoiceBox<Account> choiceBoxNaam = new ChoiceBox<>();
            choiceBoxNaam.setTooltip(new Tooltip("Selecteer een account"));
        Button buttonZoek = new Button("Zoek");
            buttonZoek.setTooltip(new Tooltip("Zoek alle profielen van de geselecteerde account"));
        Button buttonToevoegen = new Button("Toevoegen");
        Button buttonBewerken = new Button("Bewerken");
        Button buttonVerwijderen = new Button("Verwijderen");
        Button buttonVernieuwen = new Button("Vernieuwen");
            buttonVernieuwen.setTooltip(new Tooltip("Vernieuw de account lijst"));
        Button buttonProfielInfo = new Button("Profiel Info");
            buttonProfielInfo.setTooltip(new Tooltip("Geeft info over de geselecteerde profiel"));

        //Objecten voor de tableView
        TableView tableView = new TableView();
            tableView.setMinWidth(650);
        TableColumn<String, Profile> columnNaam = new TableColumn<>("Naam");
        columnNaam.setCellValueFactory(new PropertyValueFactory<String, Profile>("profileName"));
        TableColumn<Date, Profile> columnDateOfBirth = new TableColumn<>("Geboortedatum");
        columnDateOfBirth.setCellValueFactory(new PropertyValueFactory<Date, Profile>("dateOfBirth"));
        tableView.getColumns().addAll(columnNaam, columnDateOfBirth);

        //Objecten detailBox
        TextArea detailFilmsBekeken = new TextArea("Bekeken films:\n\n");
        detailFilmsBekeken.setEditable(false);
        detailFilmsBekeken.setPrefWidth(325);
        TextArea detailSeriesBekeken = new TextArea("Bekeken series:\n\n");
        detailSeriesBekeken.setEditable(false);
        detailSeriesBekeken.setPrefWidth(325);

        //Controllers object aanmaken
        ProfielController controller = new ProfielController(tableView, choiceBoxNaam, detailFilmsBekeken, detailSeriesBekeken);
            buttonToevoegen.setOnAction(controller);
            buttonBewerken.setOnAction(controller);
            buttonVerwijderen.setOnAction(controller);
            buttonVernieuwen.setOnAction(controller);
            buttonZoek.setOnAction(controller);
            buttonProfielInfo.setOnAction(controller);


        ToolBar toolBar = new ToolBar();
            toolBar.getItems().addAll(choiceBoxLabel, choiceBoxNaam, buttonZoek, buttonVernieuwen, buttonToevoegen, buttonBewerken, buttonVerwijderen, buttonProfielInfo);
        HBox mainContent = new HBox();
            mainContent.getChildren().addAll(tableView);
        HBox detailBox = new HBox();
            detailBox.getChildren().addAll(detailFilmsBekeken, detailSeriesBekeken);

        VBox resultingVbox = new VBox();
        resultingVbox.getChildren().addAll(toolBar, mainContent, detailBox);

        return resultingVbox;
    }
  
    public static VBox filmVbox(Stage stage){

        Label choiceBoxLabel = new Label("Profiel:");

        // Het toevoegen van Profiles aan de ChoiceBox!
        ChoiceBox<Profile> choiceBox = new ChoiceBox<Profile>();
        choiceBox.setMinWidth(500);
        choiceBox.getItems().add(new Profile(-1, "Geen Profiel", new Date(1), -1));
        ProfileDAO profileDAO = ProfileDAO.getInstance();
        List<Profile> profiles = profileDAO.getAllProfiles();
        for (Profile profile: profiles) {
            choiceBox.getItems().add(profile);

        }

        TextArea langsteOnder16 = new TextArea("Langste film onder 16 jaar is:\n\n");
        langsteOnder16.setEditable(false);

        TextArea Bekekendoor = new TextArea("Klik op een film voor het aantal weergaven");
        Bekekendoor.setEditable(false);
        Bekekendoor.setMinSize(600,50);
        langsteOnder16.setMinSize(600,50);


        HBox textgebieden = new HBox();
        textgebieden.setSpacing(10);
        textgebieden.getChildren().addAll(langsteOnder16,Bekekendoor);

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



        Movie xx = new Movie("De smurfen", "30", "horror", "Frans", 18);
        tableView.getItems().add(xx);


        ToolBar choiceBoxToolbar = new ToolBar();

        choiceBoxToolbar.getItems().add(choiceBoxLabel);
        choiceBoxToolbar.getItems().add(choiceBox);
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(choiceBoxToolbar,tableView,textgebieden);
        MovieController filmcontroller = new MovieController(tableView, langsteOnder16);
        MovieController2 filmcontroller2 = new MovieController2(tableView, Bekekendoor);
        choiceBox.setOnAction(filmcontroller);
        tableView.setOnMouseClicked(filmcontroller2);

        MovieDAO movieDAO = MovieDAO.getInstance();

        try{
            String ax = movieDAO.getLongestMovieForAgeLowerThen16().getTitle();
            langsteOnder16.setText("De langste film voor onder de 16 is: " + ax );
        }
        catch (Exception e){
            e.printStackTrace();
        }



        return vbox;
    }

    public static VBox serieVbox(Stage stage){
        ChoiceBox<Serie> choiceBox = new ChoiceBox<Serie>();
        choiceBox.setMinWidth(500);
        SerieDAO serieDAO = SerieDAO.getInstance();
        List<Serie> Series = serieDAO.getAllSeries();
        for (Serie serie: Series
        ) {choiceBox.getItems().add(serie);

        }
        ChoiceBox<Profile> profileChoiceBox = new ChoiceBox<>();
        ProfileDAO profileDAO = ProfileDAO.getInstance();
        List<Profile> profiles = profileDAO.getAllProfiles();
        for(Profile item : profiles){
            profileChoiceBox.getItems().add(item);
        }
            profileChoiceBox.getSelectionModel().selectFirst();

        //Maak de spinner aan en zet de restricties in plek.
        Spinner<Integer> percentageWatched = new Spinner<>();
        percentageWatched.setEditable(true);
        SpinnerValueFactory<Integer> percentageWatchedFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 100);
        percentageWatchedFactory.setConverter(new StringConverter<Integer>() {
            @Override
            public String toString(Integer integer) {
                return integer + "%";
            }

            @Override
            public Integer fromString(String s) {
                String valueWithoutUnits = s.replaceAll("%", "").trim();
                if (valueWithoutUnits.isEmpty()) {
                    return  100;
                } else {
                    return Integer.valueOf(valueWithoutUnits);
                }
            }
        });
        percentageWatched.setValueFactory(percentageWatchedFactory);

        Button buttonWatched = new Button("Watched");


        TableView tableView = new TableView();
        tableView.setMinWidth(1300);


        TableColumn<String, Episode> kolumnEpisodetitel = new TableColumn<>("Episodetitel");
        kolumnEpisodetitel.setCellValueFactory(new PropertyValueFactory<String,Episode>("title"));

        TableColumn<Integer, Episode> kolumnEpisodeSeason = new TableColumn<>("Season");
        kolumnEpisodeSeason.setCellValueFactory(new PropertyValueFactory<Integer, Episode>("season"));

        TableColumn<String, Episode> kolumnEpisodeDuration = new TableColumn<>("duration");
        kolumnEpisodeDuration.setCellValueFactory(new PropertyValueFactory<String, Episode>("duration"));



        tableView.getColumns().addAll(kolumnEpisodetitel,kolumnEpisodeSeason,kolumnEpisodeDuration);
        tableView.setMaxSize(500,900);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TextArea gemiddeldbekeken = new TextArea("Deze serie is gemiddeld");
        gemiddeldbekeken.setEditable(false);
        gemiddeldbekeken.setMinSize(600,50);



        ToolBar choiceBoxToolbar = new ToolBar();
        choiceBoxToolbar.getItems().addAll(choiceBox, profileChoiceBox, percentageWatched, buttonWatched);
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(choiceBoxToolbar,tableView,gemiddeldbekeken);
        SerieController serieController = new SerieController(tableView, gemiddeldbekeken);
        choiceBox.setOnAction(serieController);
        SerieController2 serieController2 = new SerieController2(tableView, profileChoiceBox, percentageWatched);
        buttonWatched.setOnAction(serieController2);
        SerieControllerTextArea serieControllerTextArea = new SerieControllerTextArea(tableView, gemiddeldbekeken);
        tableView.setOnMouseClicked(serieControllerTextArea);






//        TableColumn<String, Episode> kolumnEpisodeTaal = new TableColumn<>("FilmTaal");
//        kolumnFilmTaal.setCellValueFactory(new PropertyValueFactory<String, Episode>("language"));
//
//        TableColumn<Integer, Episode> kolumnEpisodeAgerating = new TableColumn<>("FilmAgeRating");
//        kolumnFilmAgerating.setCellValueFactory(new PropertyValueFactory<Integer, Episode>("ageRating"));

        return vbox;
    }
}
