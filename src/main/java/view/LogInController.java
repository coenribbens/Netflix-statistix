package view;

import datalayer.AccountDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Account;

import java.security.Principal;


public class LogInController implements EventHandler<ActionEvent> {
    private Label label;
    private Stage stage;
    private TextField nameInput;
    private PasswordField passInput;
    private PasswordField passInputRepeat;
    private TextField streetInput;
    private TextField houseNumberInput;
    private TextField zipCodeInput;
    private Label infoLabel;

    public LogInController(Label label, Stage stage, TextField nameInput, PasswordField passInput,
                           PasswordField passInputRepeat, TextField streetInput, TextField houseNumberInput,
                           TextField zipCodeInput, Label infoLabel){
        this.label = label;
        this.stage = stage;
        this.nameInput = nameInput;
        this.passInput = passInput;
        this.passInputRepeat = passInputRepeat;
        this.streetInput = streetInput;
        this.houseNumberInput = houseNumberInput;
        this.zipCodeInput = zipCodeInput;
        this.infoLabel = infoLabel;
    }

    public LogInController(Label label, Stage stage, TextField nameInput, PasswordField passInput, Label infoLabel){
        this(label, stage, nameInput, passInput, null, null, null, null, infoLabel);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getTarget();
        if(this.label.getText().equalsIgnoreCase("Log In")){
            if(btn.getText().equalsIgnoreCase("Log in")){

            }
            else if(btn.getText().equalsIgnoreCase("Register a new account")){
                this.stage.setTitle("Register");
                this.stage.setScene(LogInApplication.registerScene(this.stage));
            }
        }
        else if(this.label.getText().equalsIgnoreCase("Register")){
            if(btn.getText().equalsIgnoreCase("Register")){
                if(this.passInput.getText().equals(this.passInputRepeat.getText())){
                    Account a = new Account(this.nameInput.getText(), this.streetInput.getText(), this.houseNumberInput.getText(), this.zipCodeInput.getText());
                    AccountDAO aDAO = new AccountDAO();
                    aDAO.createAccount(a);

                }
                else{
                    this.infoLabel.setText("Passwords don't match");
                }

            }
            else if(btn.getText().contains("Log in")){
                this.stage.setTitle("Log In");
                this.stage.setScene(LogInApplication.logInScene(this.stage));
            }

        }
    }
}
