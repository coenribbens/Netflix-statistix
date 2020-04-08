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
        this.textArea.setText("Deze episode is gemiddeld " + (episodeDAO.getAverageWatchTimeForEpisode(episode) / Integer.parseInt(episode.getDuration()) * 100)+ "% bekeken.");
    }
}
