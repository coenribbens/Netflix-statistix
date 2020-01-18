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


public class ProfielInterfaces {
    public static Scene addInterface (Stage stage, Account account){

        stage.setTitle("Toevoegen");
        stage.setMinWidth(250);
        stage.setMinHeight(150);

        TextField accountInput = new TextField(account.getAccountName());
            accountInput.setDisable(true);
        TextField nameInput = new TextField();
            nameInput.setPromptText("Profiel Name");
        DatePicker datePicker = new DatePicker();
            datePicker.setPromptText("Geboortedatum");

        Label infoLabel = new Label();

        AddController controller = new AddController(stage, account, nameInput, datePicker, infoLabel);

        Button aanmakenButton = new Button("Toevoegen");
        aanmakenButton.setOnAction(controller);


        HBox hBox = new HBox();
        hBox.getChildren().addAll(aanmakenButton);
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(accountInput, nameInput, datePicker, infoLabel, hBox);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        return scene;
    }

    public static Scene editInterface (Stage stage,Account account, Profile profile){

        stage.setTitle("Bewerken");
        stage.setMinWidth(250);
        stage.setMinHeight(150);

        TextField accountInput = new TextField(profile.getProfileName());
            accountInput.setDisable(true);
        TextField nameInput = new TextField();
            nameInput.setPromptText("Profiel Name");
        DatePicker datePicker = new DatePicker();
            datePicker.setPromptText("Geboortedatum");

        Label infoLabel = new Label();

        EditController controller = new EditController(stage, nameInput, datePicker, infoLabel, profile);

        Button aanmakenButton = new Button("Bewerken");
        aanmakenButton.setOnAction(controller);


        HBox hBox = new HBox();
        hBox.getChildren().addAll(aanmakenButton);
        hBox.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(accountInput, nameInput, datePicker, infoLabel, hBox);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        return scene;
    }
}
