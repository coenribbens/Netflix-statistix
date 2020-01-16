package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        stage.setScene(logInScene(stage));
        stage.show();

    }

    public static Scene logInScene(Stage stage){
        Label label = new Label("Log In");
        TextField nameInput = new TextField();
            nameInput.setPromptText("Account Name");
        PasswordField passInput = new PasswordField();
            passInput.setPromptText("Password");
        Button logInButton = new Button("Log In");
        Button registerButton = new Button("Register a new account");
        LogInController controller = new LogInController(label, stage, nameInput);
        logInButton.setOnAction(controller);
        registerButton.setOnAction(controller);

        HBox hBox = new HBox();
            hBox.getChildren().addAll(logInButton, registerButton);
        VBox vBox = new VBox();
            vBox.getChildren().addAll(label, nameInput, passInput, hBox);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane);
        return scene;
    }

    public static Scene registerScene(Stage stage){
        Label label = new Label("Register");
        TextField nameInput = new TextField();
            nameInput.setPromptText("Account Name");

        PasswordField passInput = new PasswordField();
            passInput.setPromptText("Password");

        PasswordField passInputRepeat = new PasswordField();
        Button logInButton = new Button("Log In");
        Button registerButton = new Button("Register");

        LogInController controller = new LogInController(label, stage, nameInput);
        logInButton.setOnAction(controller);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(logInButton, registerButton);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(label, nameInput, passInput, passInputRepeat, hBox);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane);
        return scene;

    }
}
