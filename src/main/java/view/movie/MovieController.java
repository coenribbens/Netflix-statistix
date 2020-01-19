package view.movie;

import datalayer.AccountDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.Account;
import models.Movie;
import view.account.sub.AccountInterfaces;

import java.awt.*;
import java.util.List;

public class MovieController implements EventHandler<ActionEvent> {
    private TableView tableView;

    public MovieController(TableView tableView){
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ChoiceBox btn = (ChoiceBox) actionEvent.getTarget();
        Movie xx =  (Movie)btn.getSelectionModel().getSelectedItem();
        tableView.getItems().add(xx);




    }
}