package view.movie;

import datalayer.MovieDAO;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import models.Movie;

public class MovieControllerTextArea implements EventHandler<MouseEvent> {

private TableView tableView;
private TextArea Aantalkeergekeken;

public MovieControllerTextArea(TableView tableview, TextArea Aantalkeergekeken){
    this.tableView =tableview;
    this.Aantalkeergekeken = Aantalkeergekeken;
}

    /**
     * Deze controller haalt op hoeveel gebruikers de aangeklikte film hebben bekeken.
     * @param mouseEvent
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        Movie h = (Movie) tableView.getSelectionModel().getSelectedItem();
        MovieDAO movieDAO = MovieDAO.getInstance();
        int xs =  movieDAO.getFullywatchedMovies(h);
        Aantalkeergekeken.setText("Aantal gebruikers die " + h.getTitle() + " volledig hebben bekeken: " + xs );

    }
}
