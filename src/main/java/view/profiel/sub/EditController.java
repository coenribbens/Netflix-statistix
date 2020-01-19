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

public class EditController implements EventHandler<ActionEvent> {
    private Stage stage;
    private TextField nameInput;
    private DatePicker datePicker;
    private Label infoLabel;
    private Profile profile;

    public EditController(Stage stage, TextField nameInput, DatePicker datePicker, Label infoLabel, Profile profile){
        this.stage = stage;
        this.nameInput = nameInput;
        this.datePicker = datePicker;
        this.infoLabel = infoLabel;
        this.profile = profile;

        this.nameInput.setText(this.profile.getProfileName());
        this.datePicker.setValue(this.profile.getDateOfBirth().toLocalDate());
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getTarget();
        if(btn.getText().equalsIgnoreCase("Bewerken")){
            if(!this.nameInput.getText().isEmpty() && this.datePicker.getValue() != null){
                this.profile.setProfileName(this.nameInput.getText());
                this.profile.setDateOfBirth(Date.valueOf(this.datePicker.getValue()));
                ProfileDAO profileDAO = ProfileDAO.getInstance();
                profileDAO.updateProfile(this.profile);
                this.stage.close();

            }
            else {
                this.infoLabel.setText("Niet alle velden zijn ingevuld.");
            }
        }

    }
}
