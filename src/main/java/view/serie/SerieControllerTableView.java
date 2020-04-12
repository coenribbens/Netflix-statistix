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

public class SerieControllerTableView implements  EventHandler<ActionEvent>{

    private TableView tableView;
    private TextArea gemiddeldeKijkTijdSerie;
  
    public SerieControllerTableView(TableView tableView, TextArea gemiddeldekijktijdSerie ){
        this.tableView = tableView;
        this.gemiddeldeKijkTijdSerie = gemiddeldekijktijdSerie; }


    /**
     * Deze controller pakt alle episodes van een serie geselecteerd in de choicebox.
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        ChoiceBox btn = (ChoiceBox) actionEvent.getTarget();
        Serie selectedSerie = (Serie) btn.getSelectionModel().getSelectedItem();
        SerieDAO serieDAO = SerieDAO.getInstance();

        this.tableView.getItems().clear();
        List<Episode> episodes = serieDAO.getAllEpisodesBySerie(selectedSerie);
        for(Episode item : episodes){
            this.tableView.getItems().add(item);
        }
        this.tableView.getSelectionModel().selectFirst();

    }

}
