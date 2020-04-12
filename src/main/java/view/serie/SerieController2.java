package view.serie;

import datalayer.ProfileDAO;
import datalayer.SerieDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import models.Episode;
import models.Profile;
import models.Serie;


import java.awt.*;
import java.util.List;

public class SerieController2 implements  EventHandler<ActionEvent>{

    private TableView tableView;
    private TextArea gemiddeldeKijkTijdSerie;
    private ChoiceBox<Profile> profile;
    private Spinner<Integer> integerSpinner;

    public SerieController2(TableView tableView, ChoiceBox profile, Spinner<Integer> integerSpinner) {
        this.tableView = tableView;
        this.profile = profile;
        this.integerSpinner = integerSpinner;
    }



    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getTarget();
        Episode episode = (Episode)this.tableView.getSelectionModel().getSelectedItem();
        ProfileDAO profileDAO = ProfileDAO.getInstance();
        if(btn.getText().equalsIgnoreCase("watched")){
            //Het procent gekeken wordt hier uitgerekend waarna het naar via de DAO in de Tabel wordt geupdate.
            int procentGekeken = (int)Math.round(Integer.parseInt(episode.getDuration()) * (integerSpinner.getValue() / 100.0));
            profileDAO.markSeriesAsWatched(episode.getProgramId(), this.profile.getSelectionModel().getSelectedItem().getProfileId(), "" + procentGekeken);
        }
        else if(btn.getText().equalsIgnoreCase("un-watch")){
            profileDAO.markSeriesAsUnwatched(episode.getProgramId(), this.profile.getSelectionModel().getSelectedItem().getProfileId());
        }

    }

}