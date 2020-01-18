package view.profiel.sub;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Account;
import models.Profile;
import view.account.sub.AddController;
import view.account.sub.EditController;


public class ProfielInterfaces {
    public static Scene addInterface (Stage stage){

        stage.setTitle("Toevoegen");
        stage.setMinWidth(250);
        stage.setMinHeight(250);

        TextField nameInput = new TextField();
            nameInput.setPromptText("Profiel Name");
        DatePicker datePicker = new DatePicker();

        Label infoLabel = new Label();

//        AddController controller = new AddController(stage, nameInput, streetInput, houseNumberInput, zipCodeInput, infoLabel);

        Button aanmakenButton = new Button("Toevoegen");
//        aanmakenButton.setOnAction(controller);


        HBox hBox = new HBox();
        hBox.getChildren().addAll(aanmakenButton);
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
//        vBox.getChildren().addAll(nameInput, streetInput, houseNumberInput, zipCodeInput, infoLabel, hBox);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        return scene;
    }

    public static Scene editInterface (Stage stage, Profile profile){

        stage.setTitle("Bewerken");
        stage.setMinWidth(250);
        stage.setMinHeight(250);

        TextField nameInput = new TextField();
        nameInput.setPromptText("account Name");
        TextField streetInput = new TextField();
        streetInput.setPromptText("Street name");
        TextField houseNumberInput = new TextField();
        houseNumberInput.setPromptText("House number");
        TextField zipCodeInput = new TextField();
        zipCodeInput.setPromptText("Zipcode");

        Label infoLabel = new Label();

//        EditController controller = new EditController(stage, nameInput, streetInput, houseNumberInput, zipCodeInput, infoLabel, account);

        Button aanmakenButton = new Button("Bewerken");
//        aanmakenButton.setOnAction(controller);


        HBox hBox = new HBox();
        hBox.getChildren().addAll(aanmakenButton);
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(nameInput, streetInput, houseNumberInput, zipCodeInput, infoLabel, hBox);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        return scene;
    }
}
