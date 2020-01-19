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
    private TextArea Langstefilmonder16;
    private TextArea aantalbeken;

    public MovieController(TableView tableView, TextArea aantalbeken, TextArea Langstefilmmonder16){
        this.tableView = tableView; this.aantalbeken = aantalbeken; this.Langstefilmonder16 = Langstefilmmonder16;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ChoiceBox btn = (ChoiceBox) actionEvent.getTarget();
        Movie xx =  (Movie)btn.getSelectionModel().getSelectedItem();
        if (!tableView.getItems().contains(xx)) {
            tableView.getItems().add(xx);
        }
        // Het aantal keer dat een film volledig bekeken is
        Movie x = (Movie) tableView.getSelectionModel().getSelectedItem();
        MovieDAO movieDAO = new MovieDAO();
        int xs = movieDAO.getFullywatchedMovies(x);

        // Geeft de film die het langst is voor < 16
        String ax = movieDAO.getLongestMovieForAgeLowerThen16().getTitle();
        aantalbeken.setText("De langste film voor onder de 16 is: " + ax );








    }
}