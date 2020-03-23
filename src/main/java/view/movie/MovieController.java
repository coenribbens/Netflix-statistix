package view.movie;

import datalayer.AccountDAO;
import datalayer.MovieDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Account;
import models.Movie;
import models.Profile;
import view.account.sub.AccountInterfaces;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.util.List;

public class MovieController implements EventHandler<ActionEvent> {
    private TableView tableView;
    private TextArea Langstefilmonder16;


    public MovieController(TableView tableView,  TextArea Langstefilmmonder16){
        this.tableView = tableView;  this.Langstefilmonder16 = Langstefilmmonder16;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ChoiceBox btn = (ChoiceBox) actionEvent.getTarget();
        Profile xx =  (Profile)btn.getSelectionModel().getSelectedItem();
        MovieDAO movieDAO = MovieDAO.getInstance();

        // Pak alle films bekeken door het geselecteerde profiel en zet deze in de tableview.
        this.tableView.getItems().clear();
        List<Movie> movies;
        if (xx.getProfileId() == -1){
            movies = movieDAO.getAllMovies();
        }
        else {
            movies = movieDAO.getMoviesWatchedByProfile(xx);
        }
        for(Movie item : movies){
            this.tableView.getItems().add(item);
        }


        // Geeft de film die het langst is voor < 16
//        String ax = movieDAO.getLongestMovieForAgeLowerThen16().getTitle();
//        Langstefilmonder16.setText("De langste film voor onder de 16 is: " + ax );








    }
}