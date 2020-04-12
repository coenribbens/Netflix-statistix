package view.serie;

import datalayer.EpisodeDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import models.Episode;
import models.Serie;


public class SerieControllerTextArea implements EventHandler<MouseEvent> {

    private TableView tableView;
    private TextArea textArea;
    private ChoiceBox<Serie> serieChoiceBox;
    public SerieControllerTextArea(TableView tableView, TextArea textArea, ChoiceBox<Serie> serieChoiceBox){
        this.tableView = tableView;
        this.textArea = textArea;
        this.serieChoiceBox = serieChoiceBox;
    }

    /**
     * Deze controller haalt op hoeveel % de episode is bekeken.
     * @param actionEvent
     */
    @Override
    public void handle(MouseEvent actionEvent) {
        Episode episode = (Episode)this.tableView.getSelectionModel().getSelectedItem();
        EpisodeDAO episodeDAO = EpisodeDAO.getInstance();
        String stringTextArea = "Deze serie lijkt heel erg op de serie: " + this.serieChoiceBox.getSelectionModel().getSelectedItem().getSuggestions();


        // Onderstaande formule vereist doubles voor comma getallen, integers werken niet. 0.9 is voor een int nog altijd een 0.
       double avgwatchtime = (double)episodeDAO.getAverageWatchTimeForEpisode(episode) / Double.parseDouble(episode.getDuration()) * 100;

       int y = (int) avgwatchtime; // casten de double terug naar een int, omdat we niet 10 decimalen in de output willen.
        stringTextArea += "\nDeze episode is gemiddeld " + y + "% bekeken.";
        this.textArea.setText(stringTextArea);

    }
}
