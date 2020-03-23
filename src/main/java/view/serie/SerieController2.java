package view.serie;

import datalayer.ProfileDAO;
import datalayer.SerieDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
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

    public SerieController2(TableView tableView, ChoiceBox profile) {
        this.tableView = tableView;
        this.profile = profile;
    }



    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getTarget();
        Episode episode = (Episode)this.tableView.getSelectionModel().getSelectedItem();
        ProfileDAO profileDAO = ProfileDAO.getInstance();
        profileDAO.markSeriesAsWatched(episode.getProgramId(), this.profile.getSelectionModel().getSelectedItem().getProfileId(), episode.getDuration());

    }

}