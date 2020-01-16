package view;

import datalayer.AccountDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LogInController implements EventHandler<ActionEvent> {
    private Label label;
    private Stage stage;
    private TextField nameInput;
    public LogInController(Label label, Stage stage, TextField nameInput){
        this.label = label;
        this.nameInput = nameInput;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getTarget();
        if(this.label.getText().equalsIgnoreCase("Log In")){
            if(btn.getText().equalsIgnoreCase("Log in")){
                AccountDAO a = new AccountDAO();

            }
            else if(btn.getText().equalsIgnoreCase("Register a new account")){
                this.stage.setScene(LogInApplication.registerScene(this.stage));
            }
        }
    }
}
