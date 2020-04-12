package view.serie;

import datalayer.ProfileDAO;
import datalayer.SerieDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.Episode;
import models.Profile;
import models.Serie;
import view.Toast;


import java.awt.*;
import java.util.List;

public class SerieControllerWatched implements  EventHandler<ActionEvent>{

    private TableView tableView;
    private TextArea gemiddeldeKijkTijdSerie;
    private ChoiceBox<Profile> profile;
    private Spinner<Integer> integerSpinner;
    private Stage stage;

    public SerieControllerWatched(TableView tableView, ChoiceBox profile, Spinner<Integer> integerSpinner, Stage stage) {
        this.tableView = tableView;
        this.profile = profile;
        this.integerSpinner = integerSpinner;
        this.stage = stage;
    }



    /**
     * Deze controller noteert films als bekeken of onbekeken voor een geselecteerde gebruiker die uit de choicebox wordt gehaald.
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getTarget();
        Episode episode = (Episode)this.tableView.getSelectionModel().getSelectedItem();
        ProfileDAO profileDAO = ProfileDAO.getInstance();
        if(btn.getText().equalsIgnoreCase("watched")){
            if (tableView.getSelectionModel().isEmpty()){
                Toast.createToast(stage,"Selecteer eerst een serie en episode");
            }
            else {


            //Het procent gekeken wordt hier uitgerekend waarna het naar via de DAO in de Tabel wordt geupdate.
            int procentGekeken = (int)Math.round(Integer.parseInt(episode.getDuration()) * (integerSpinner.getValue() / 100.0));
            profileDAO.markSeriesAsWatched(episode.getProgramId(), this.profile.getSelectionModel().getSelectedItem().getProfileId(), "" + procentGekeken);
            Toast.createToast(stage, "Data toegevoegd/geupdated");
        }}


        else if(btn.getText().equalsIgnoreCase("un-watch")){
            if (this.tableView.getSelectionModel().isEmpty()){
                Toast.createToast(stage,"Selecteer eerst een serie en episode");
            }
            else{
            profileDAO.markSeriesAsUnwatched(episode.getProgramId(), this.profile.getSelectionModel().getSelectedItem().getProfileId());
            Toast.createToast(stage,"Data verwijderd");
        }}

    }

}