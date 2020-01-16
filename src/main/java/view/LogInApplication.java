package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        stage.setScene(logInScene(stage));
        stage.setTitle("Log In");
        stage.show();

    }

    public static Scene logInScene(Stage stage){
        Label label = new Label("Log In");
        TextField nameInput = new TextField();
            nameInput.setPromptText("Account Name");
        PasswordField passInput = new PasswordField();
            passInput.setPromptText("Password");

        Label infoLabel = new Label();

        LogInController controller = new LogInController(label, stage, nameInput, passInput, infoLabel);

        Button logInButton = new Button("Log In");
            logInButton.setOnAction(controller);
        Button registerButton = new Button("Register a new account");
            registerButton.setOnAction(controller);

        HBox hBox = new HBox();
            hBox.getChildren().addAll(logInButton, registerButton);
        VBox vBox = new VBox();
            vBox.getChildren().addAll(label, nameInput, passInput, infoLabel, hBox);
        Scene scene = new Scene(vBox);
        return scene;
    }

    public static Scene registerScene(Stage stage){
        Label label = new Label("Register");
        TextField nameInput = new TextField();
            nameInput.setPromptText("Account Name*");

        PasswordField passInput = new PasswordField();
            passInput.setPromptText("Password*");

        PasswordField passInputRepeat = new PasswordField();
            passInputRepeat.setPromptText("Repeat Password*");

        TextField streetInput = new TextField();
            streetInput.setPromptText("Street name");

        TextField houseNumberInput = new TextField();
            houseNumberInput.setPromptText("House number");

        TextField zipCodeInput = new TextField();
            zipCodeInput.setPromptText("Zipcode");

        Label infoLabel = new Label("Fields with a '*' are required.");

        LogInController controller = new LogInController(label, stage, nameInput, passInput, passInputRepeat, streetInput, houseNumberInput, zipCodeInput, infoLabel);

        Button registerButton = new Button("Register");
            registerButton.setOnAction(controller);
        Button logInScreenButton = new Button("Log in with existing account");
            logInScreenButton.setOnAction(controller);


        HBox hBox = new HBox();
        hBox.getChildren().addAll(registerButton, logInScreenButton);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, nameInput, passInput, passInputRepeat, streetInput, houseNumberInput, zipCodeInput, infoLabel, hBox);
        Scene scene = new Scene(vBox);
        return scene;

    }
}
