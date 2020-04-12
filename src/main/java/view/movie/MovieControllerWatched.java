package view.movie;

import datalayer.ProfileDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.Episode;
import models.Movie;
import models.Profile;
import view.Toast;

public class MovieControllerWatched implements EventHandler<ActionEvent> {
    private TableView tableView;
    private ChoiceBox<Profile> profile;
    private Spinner<Integer> integerSpinner;
    private Stage stage;

    public MovieControllerWatched(TableView tableView, ChoiceBox<Profile> profile, Spinner<Integer> integerSpinner, Stage stage) {
        this.tableView = tableView;
        this.profile = profile;
        this.integerSpinner = integerSpinner;
        this.stage = stage;
    }


    /**
     *
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {

        Button btn = (Button) actionEvent.getTarget();
        if(this.profile.getSelectionModel().getSelectedItem() == null || this.profile.getSelectionModel().getSelectedItem().getProfileId() == -1){
            Toast.createToast(this.stage, "Selecteer een geldig profiel");
            return;
        }
        Movie movie = (Movie)this.tableView.getSelectionModel().getSelectedItem();
        ProfileDAO profileDAO = ProfileDAO.getInstance();
        if(btn.getText().equalsIgnoreCase("watched")){
            //Het procent gekeken wordt hier uitgerekend waarna het naar via de DAO in de Tabel wordt geupdate.
            int procentGekeken = (int)Math.round(Integer.parseInt(movie.getDuration()) * (integerSpinner.getValue() / 100.0));
            profileDAO.markSeriesAsWatched(movie.getProgramId(), this.profile.getSelectionModel().getSelectedItem().getProfileId(), "" + procentGekeken);
        }
        else if(btn.getText().equalsIgnoreCase("un-watch")){
            profileDAO.markSeriesAsUnwatched(movie.getProgramId(), this.profile.getSelectionModel().getSelectedItem().getProfileId());
        }
    }
}
