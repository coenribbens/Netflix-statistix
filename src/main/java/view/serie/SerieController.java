package view.serie;

import datalayer.MovieDAO;
import datalayer.SerieDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import models.Episode;
import models.Movie;
import models.Serie;

import java.util.ArrayList;
import java.util.List;

public class SerieController implements  EventHandler<ActionEvent>{

    private TableView tableView;
    private TextArea GemiddeldekijktijdSerie;

    public SerieController(TableView tableView, TextArea GemiddeldekijktijdSerie ){
        this.tableView = tableView; this.GemiddeldekijktijdSerie = GemiddeldekijktijdSerie; }



    @Override
    public void handle(ActionEvent actionEvent) {


        ChoiceBox btn = (ChoiceBox) actionEvent.getTarget();
        Serie selectedserie = (Serie) btn.getSelectionModel().getSelectedItem();
        int i = 0;
        if (!tableView.getItems().contains(selectedserie)) {
            SerieDAO serie = new SerieDAO();
            List<Episode> Series = serie.getAllEpisodesBySerie(selectedserie);
            tableView.getItems().add(Series);
            GemiddeldekijktijdSerie.setText("De gemiddelde kijtijd is:" + serie.getAverageWatchTime(selectedserie));
            i++;
        }
        // Verwijderd de data, zodat er enkel de episodes van het geselecteerde seizoen worden weergegeven
        if (i == 2) {
            tableView.getItems().clear();
            i = 0;
            SerieDAO serie = new SerieDAO();
            List<Episode> Series = serie.getAllEpisodesBySerie(selectedserie);
            tableView.getItems().add(Series);
            GemiddeldekijktijdSerie.setText("De gemiddelde kijtijd is:" + serie.getAverageWatchTime(selectedserie));
            i++;


        }

    }}