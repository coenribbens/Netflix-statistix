package view.movie;

import datalayer.AccountDAO;
import datalayer.MovieDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.Account;
import models.Movie;
import view.account.sub.AccountInterfaces;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.List;

public class MovieController implements EventHandler<ActionEvent> {
    private TableView tableView;
    private TextArea Gemiddeldekijtijd;
    private TextArea aantalbeken;

    public MovieController(TableView tableView, TextArea aantalbeken){
        this.tableView = tableView; this.aantalbeken = aantalbeken;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ChoiceBox btn = (ChoiceBox) actionEvent.getTarget();
        Movie xx =  (Movie)btn.getSelectionModel().getSelectedItem();
        if (!tableView.getItems().contains(xx)) {
            tableView.getItems().add(xx);
        }
        // Het aantal volledige bekeken films
        Movie x = (Movie) tableView.getSelectionModel().getSelectedItem();
        MovieDAO movieDAO = new MovieDAO();
        int xs = movieDAO.getFullywatchedMovies(x);
        aantalbeken.setText("Deze film is" + xs + "maal volledig bekeken");

     ;






    }
}