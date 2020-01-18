package view.profiel;

import datalayer.AccountDAO;
import datalayer.MovieDAO;
import datalayer.ProfileDAO;
import datalayer.SerieDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import models.Account;
import models.Movie;
import models.Profile;
import models.Serie;
import view.profiel.sub.ProfielInterfaces;

import java.util.List;

public class ProfielController implements EventHandler<ActionEvent> {
    private TableView tableView;
    private ChoiceBox<Account> choiceBoxAccounts;
    private TextArea detailFilmsBekeken;
    private TextArea detailSeriesBekeken;

    public ProfielController(TableView tableView, ChoiceBox choiceBoxAccounts, TextArea detailFilmsBekeken, TextArea detailSeriesBekeken){
        this.tableView = tableView;
        this.choiceBoxAccounts = choiceBoxAccounts;
        this.detailFilmsBekeken = detailFilmsBekeken;
        this.detailSeriesBekeken = detailSeriesBekeken;
        AccountDAO accountDAO = new AccountDAO();
        List<Account> accounts = accountDAO.getAllAccounts();
        for(Account item : accounts){
            this.choiceBoxAccounts.getItems().addAll(item);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getTarget();
        if(btn.getText().equalsIgnoreCase("toevoegen")){
            Stage addStage = new Stage();
            addStage.setScene(ProfielInterfaces.addInterface(addStage));
            addStage.show();
        }
        else if(btn.getText().equalsIgnoreCase("bewerken")){
            Stage editStage = new Stage();
//            editStage.setScene(ProfielInterfaces.editInterface(editStage, (Account)this.tableView.getSelectionModel().getSelectedItem()));
            editStage.show();

        }
        else if(btn.getText().equalsIgnoreCase("verwijderen")){
            Profile selectedItem = (Profile)this.tableView.getSelectionModel().getSelectedItem();
            ProfileDAO profileDAO = new ProfileDAO();
            profileDAO.deleteProfile(selectedItem);
            this.tableView.getItems().remove(selectedItem);
        }
        else if(btn.getText().equalsIgnoreCase("vernieuwen")){
            this.tableView.getItems().clear();
            this.choiceBoxAccounts.getItems().clear();
            AccountDAO accountDAO = new AccountDAO();
            List<Account> accounts = accountDAO.getAllAccounts();
            for(Account item : accounts){
                this.choiceBoxAccounts.getItems().addAll(item);
            }
        }
        else if(btn.getText().equalsIgnoreCase("zoek")){
            this.tableView.getItems().clear();
            ProfileDAO profileDAO = new ProfileDAO();
            List<Profile> profiles = profileDAO.getProfilesOfAccount(this.choiceBoxAccounts.getValue());
            for(Profile item : profiles){
                this.tableView.getItems().add(item);
            }

        }
        else if(btn.getText().equalsIgnoreCase("profiel info")){
            Profile selectedItem = (Profile)this.tableView.getSelectionModel().getSelectedItem();
            MovieDAO movieDAO = MovieDAO.getInstance();
            SerieDAO serieDAO = SerieDAO.getInstance();

            List<Movie> moviesWatched = movieDAO.getMoviesWatchedByProfile(selectedItem);
            String movieText = "Bekeken films van " + selectedItem.getProfileName() + ":\n";
            List<Serie> seriesWatched = serieDAO.getWatchedSeriesByProfile(selectedItem);
            String serieText = "Bekeken series van " + selectedItem.getProfileName() + ":\n";
            for(Movie item : moviesWatched){
                movieText += "\n" + item.getTitle();
            }
            for(Serie item : seriesWatched){
                serieText += "\n" + item.getName();
            }
            this.detailFilmsBekeken.setText(movieText);
            this.detailSeriesBekeken.setText(serieText);
        }

    }
}
