package view.profiel.sub;

import datalayer.AccountDAO;
import datalayer.ProfileDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Account;
import models.Profile;

import java.sql.Date;

public class AddController implements EventHandler<ActionEvent> {
    private Stage stage;
    private Account account;
    private TextField nameInput;
    private DatePicker datePicker;
    private Label infoLabel;

    public AddController(Stage stage, Account account, TextField nameInput, DatePicker datePicker, Label infoLabel){
        this.stage = stage;
        this.account = account;
        this.nameInput = nameInput;
        this.datePicker = datePicker;
        this.infoLabel = infoLabel;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getTarget();
        if(btn.getText().equalsIgnoreCase("Toevoegen")){
            if(!this.nameInput.getText().isEmpty() && this.datePicker.getValue() != null){
                Date birthDate = Date.valueOf(this.datePicker.getValue());
                Profile p = new Profile(this.nameInput.getText(), birthDate);
                p.setAccountId(this.account.getAccountId());
                ProfileDAO profileDAO = ProfileDAO.getInstance();
                profileDAO.createNewProfile(p);
                this.stage.close();
            }
            else {
                this.infoLabel.setText("Niet alle velden zijn ingevuld.");
            }
        }

    }
}
