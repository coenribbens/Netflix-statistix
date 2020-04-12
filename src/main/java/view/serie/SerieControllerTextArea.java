package view.serie;

import datalayer.EpisodeDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import models.Episode;


public class SerieControllerTextArea implements EventHandler<MouseEvent> {

    private TableView tableView;
    private TextArea textArea;
    public SerieControllerTextArea(TableView tableView, TextArea textArea){
        this.tableView = tableView;
        this.textArea = textArea;
    }

    @Override
    public void handle(MouseEvent actionEvent) {
        Episode episode = (Episode)this.tableView.getSelectionModel().getSelectedItem();
        EpisodeDAO episodeDAO = EpisodeDAO.getInstance();


        // Onderstaande formule vereist doubles voor comma getallen, integers werken niet. 0.9 is voor een int nog altijd een 0.
       double avgwatchtime = (double)episodeDAO.getAverageWatchTimeForEpisode(episode) / Double.parseDouble(episode.getDuration()) * 100;

       int y = (int) avgwatchtime; // casten de double terug naar een int, omdat we niet 10 decimalen in de output willen.
        this.textArea.setText("Deze episode is gemiddeld " + y + "% bekeken.");

    }
}
