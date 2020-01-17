package view.Account;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.LogInController;

public class AccountInterfaces{
    public static Scene addInterface (Stage stage){

        stage.setTitle("Add Account");
        stage.setMinWidth(250);
        stage.setMinHeight(250);

        TextField nameInput = new TextField();
            nameInput.setPromptText("Account Name");
        TextField streetInput = new TextField();
            streetInput.setPromptText("Street name");
        TextField houseNumberInput = new TextField();
            houseNumberInput.setPromptText("House number");
        TextField zipCodeInput = new TextField();
            zipCodeInput.setPromptText("Zipcode");

        Label infoLabel = new Label();

        AddController controller = new AddController(stage, nameInput, streetInput, houseNumberInput, zipCodeInput, infoLabel);

        Button aanmakenButton = new Button("Aanmaken");
        aanmakenButton.setOnAction(controller);


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
