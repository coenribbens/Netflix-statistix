package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TextField nameInput = new TextField();
        nameInput.setPromptText("Account Name");
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("Password");
        Button logInButton = new Button("Log In");
        Button registerButton = new Button("Register");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(logInButton, registerButton);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(nameInput, passInput, hBox);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(vBox);
        Scene scene = new Scene(borderPane);

        stage.setScene(scene);
        stage.show();

    }
}
