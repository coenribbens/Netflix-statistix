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
        this.tableView = tableView; this.GemiddeldekijktijdSerie = GemiddeldekijktijdSerie; ChoiceBox choiceBox; }



    @Override
    public void handle(ActionEvent actionEvent) {


//        Serie selectedserie = (Serie) .getSelectionModel().getSelectedItem();
//        List<Episode> episodes = SerieDAO.getInstance().getAllEpisodesBySerie(selectedserie);
//        int i = 0;
//
//        if (!tableView.getItems().contains(episodes)) {
//
//            for (Episode episode : episodes
//            ) {
//                tableView.getItems().add(episode);
//
//            }
//
//            i++;
//        }
//
//
//        if (i == 2) {
//            tableView.getItems().clear();
//
//
//
//            for (Episode episode : episodes
//            ) {
//                tableView.getItems().add(episode);
//
//
//
//        }
//            i = 0;
//            i++;
//
//    }
//    Serie serie = (Serie) tableView.getSelectionModel().getSelectedItem();
//        int x = SerieDAO.getInstance().getAverageWatchTime(serie);
//        GemiddeldekijktijdSerie.setText("Deze serie is gemiddeld " + x + " procent bekeken");
//
//
    }}