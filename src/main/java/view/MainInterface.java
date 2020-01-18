package view;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Account;
import models.Profile;
import view.account.AccountController;
import view.profiel.ProfielController;

import java.sql.Date;

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

        VBox resultingVbox = new VBox();
            resultingVbox.getChildren().addAll(toolBar, mainContent);

        return resultingVbox;
    }

    public static VBox profielVbox(Stage stage){
        //Objecten toolBar
        ChoiceBox<Account> choiceBoxNaam = new ChoiceBox<>();
        Button buttonZoek = new Button("Zoek");
        Button buttonToevoegen = new Button("Toevoegen");
        Button buttonBewerken = new Button("Bewerken");
        Button buttonVerwijderen = new Button("Verwijderen");
        Button buttonVernieuwen = new Button("Vernieuwen");

        //Objecten voor de tableView
        TableView tableView = new TableView();
        TableColumn<String, Profile> columnNaam = new TableColumn<>("Naam");
        columnNaam.setCellValueFactory(new PropertyValueFactory<String, Profile>("profileName"));
        TableColumn<Date, Profile> columnDateOfBirth = new TableColumn<>("Geboortedatum");
        columnDateOfBirth.setCellValueFactory(new PropertyValueFactory<Date, Profile>("dateOfBirth"));
        tableView.getColumns().addAll(columnNaam, columnDateOfBirth);
        tableView.getItems().add(new Profile("Pipo", new Date(1)));

        //Objecten detailBox
        TextArea detailFilmsBekeken = new TextArea("Bekeken films:\n\n");
        detailFilmsBekeken.setEditable(false);
        TextArea detailSeriesBekeken = new TextArea("Bekeken series:\n\n");
        detailSeriesBekeken.setEditable(false);

        //Controller object aanmaken
        ProfielController controller = new ProfielController(tableView, choiceBoxNaam);
        buttonToevoegen.setOnAction(controller);
        buttonBewerken.setOnAction(controller);
        buttonVerwijderen.setOnAction(controller);
        buttonVernieuwen.setOnAction(controller);
        buttonZoek.setOnAction(controller);


        ToolBar toolBar = new ToolBar();
            toolBar.getItems().addAll(choiceBoxNaam, buttonZoek, buttonToevoegen, buttonBewerken, buttonVerwijderen, buttonVernieuwen);
        HBox mainContent = new HBox();
            mainContent.getChildren().addAll(tableView);
        HBox detailBox = new HBox();
            detailBox.getChildren().addAll(detailFilmsBekeken, detailSeriesBekeken);

        VBox resultingVbox = new VBox();
        resultingVbox.getChildren().addAll(toolBar, mainContent, detailBox);

        return resultingVbox;
    }

    public static VBox filmVbox(Stage stage){
        return null;
    }

    public static VBox serieVbox(Stage stage){
        return null;
    }
}
