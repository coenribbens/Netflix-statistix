package view.account.sub;

import datalayer.AccountDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Account;
import view.Toast;

public class AddController implements EventHandler<ActionEvent> {
    private Stage stage;
    private TextField nameInput;
    private TextField streetInput;
    private TextField houseNumberInput;
    private TextField zipCodeInput;
    private Label infoLabel;

    public AddController(Stage stage, TextField nameInput,  TextField streetInput, TextField houseNumberInput,
                           TextField zipCodeInput, Label infoLabel){
        this.stage = stage;
        this.nameInput = nameInput;
        this.streetInput = streetInput;
        this.houseNumberInput = houseNumberInput;
        this.zipCodeInput = zipCodeInput;
        this.infoLabel = infoLabel;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getTarget();
        if(btn.getText().equalsIgnoreCase("Toevoegen")){

            if(!this.nameInput.getText().isEmpty() && !this.streetInput.getText().isEmpty() && !this.houseNumberInput.getText().isEmpty() && !this.zipCodeInput.getText().isEmpty()){
                Account a = new Account(this.nameInput.getText(), this.streetInput.getText(), this.houseNumberInput.getText(), this.zipCodeInput.getText());
                if (!a.isHouseNumberValid(houseNumberInput.toString())){
                    this.infoLabel.setText("Ongeldig huisnummer"); // Controleert huisnummer op geldigheid.
                    return;
                }

                AccountDAO aDAO = AccountDAO.getInstance();
                aDAO.createAccount(a);
                this.stage.close();
            }
            else {
                this.infoLabel.setText("Niet alle velden zijn ingevuld.");
            }
        }

    }
}
