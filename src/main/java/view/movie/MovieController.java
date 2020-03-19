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
        Movie xx =  (Movie)btn.getSelectionModel().getSelectedItem();

        if (!tableView.getItems().contains(xx)) {
            tableView.getItems().add(xx);
            // Het aantal keer dat een film volledig bekeken is

        }
        MovieDAO movieDAO = MovieDAO.getInstance();

        // Geeft de film die het langst is voor < 16
        String ax = movieDAO.getLongestMovieForAgeLowerThen16().getTitle();
        Langstefilmonder16.setText("De langste film voor onder de 16 is: " + ax );








    }
}