package view.account.sub;

import datalayer.AccountDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Account;

public class EditController implements EventHandler<ActionEvent> {
    private Stage stage;
    private TextField nameInput;
    private TextField streetInput;
    private TextField houseNumberInput;
    private TextField zipCodeInput;
    private Label infoLabel;
    private Account account;

    public EditController(Stage stage, TextField nameInput,  TextField streetInput, TextField houseNumberInput,
                         TextField zipCodeInput, Label infoLabel, Account account){
        this.stage = stage;
        this.nameInput = nameInput;
        this.streetInput = streetInput;
        this.houseNumberInput = houseNumberInput;
        this.zipCodeInput = zipCodeInput;
        this.infoLabel = infoLabel;
        this.account = account;

        this.nameInput.setText(this.account.getAccountName());
        this.streetInput.setText(this.account.getStreetName());
        this.houseNumberInput.setText(this.account.getHouseNumber());
        this.zipCodeInput.setText(this.account.getZipcode());
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getTarget();
        if(btn.getText().equalsIgnoreCase("Bewerken")){
            if(!this.nameInput.getText().isEmpty() && !this.streetInput.getText().isEmpty() && !this.houseNumberInput.getText().isEmpty() && !this.zipCodeInput.getText().isEmpty()){
                Account a = new Account(this.nameInput.getText(), this.streetInput.getText(), this.houseNumberInput.getText(), this.zipCodeInput.getText());
                AccountDAO aDAO = new AccountDAO();
                aDAO.updateAccount(a);
                this.stage.close();
            }
            else {
                this.infoLabel.setText("Niet alle velden zijn ingevuld.");
            }
        }

    }
}
