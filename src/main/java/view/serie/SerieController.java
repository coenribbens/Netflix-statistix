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


            List<Serie> Series = SerieDAO.getInstance().getAllSeries();
            for (Serie serie : Series
            ) {
                btn.getItems().add(serie);

            }

            i++;
        }


        if (i == 2) {


//            tableView.getItems().clear();
//            SerieDAO serie = new SerieDAO();
//            Series = serie.getAllEpisodesBySerie(selectedserie);
//            tableView.getItems().add(Series);
//            GemiddeldekijktijdSerie.setText("De gemiddelde kijktijd is:" + serie.getAverageWatchTime(selectedserie));
//            i = 0;
//            i++;


        }

    }}