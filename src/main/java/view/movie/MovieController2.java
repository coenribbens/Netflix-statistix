package view.movie;

import datalayer.MovieDAO;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import models.Movie;

public class MovieController2 implements EventHandler<MouseEvent> {

private TableView tableView;
private TextArea Aantalkeergekeken;

public MovieController2(TableView tableview, TextArea Aantalkeergekeken){
    this.tableView =tableview;
    this.Aantalkeergekeken = Aantalkeergekeken;
}
    @Override
    public void handle(MouseEvent mouseEvent) {
        Movie h = (Movie) tableView.getSelectionModel().getSelectedItem();
        MovieDAO movieDAO = new MovieDAO();
        int xs =  movieDAO.getFullywatchedMovies(h);
        Aantalkeergekeken.setText("Aantal keer bekeken: " + xs );

    }
}
