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
import view.account.AccountController;
import models.Profile;
import view.account.AccountController;
import view.profiel.ProfielController;

import java.sql.Date;

public class MainInterface extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(mainScene(stage));
        stage.setMinHeight(500);
        stage.setHeight(500);
        stage.setMinWidth(700);
        stage.setWidth(700);
        stage.show();
    }

    public static Scene mainScene(Stage stage){
        stage.setTitle("Netflix Statistics - Marcello Haddeman 2152991, Thomas Meeusen 2151718, Coen Ribbens");

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
        return null;
    }

    public static VBox serieVbox(Stage stage){
        return null;
    }
}
