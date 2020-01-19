package view.movie;

import datalayer.AccountDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.Account;
import view.account.sub.AccountInterfaces;

import java.util.List;

public class MovieController implements EventHandler<ActionEvent> {
    private TableView tableView;

    public MovieController(TableView tableView){
        this.tableView = tableView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getTarget();
        if(btn.getText().equalsIgnoreCase("toevoegen")){
            Stage addStage = new Stage();
            addStage.setScene(AccountInterfaces.addInterface(addStage));
            addStage.show();


        }
        else if(btn.getText().equalsIgnoreCase("bewerken")){
            Stage editStage = new Stage();
            editStage.setScene(AccountInterfaces.editInterface(editStage, (Account)this.tableView.getSelectionModel().getSelectedItem()));
            editStage.show();

        }
        else if(btn.getText().equalsIgnoreCase("verwijderen")){
            Account selectedItem = (Account)this.tableView.getSelectionModel().getSelectedItem();
            AccountDAO accountDAO = AccountDAO.getInstance();
            accountDAO.deleteAccount(selectedItem);
            this.tableView.getItems().remove(selectedItem);
        }
        else if(btn.getText().equalsIgnoreCase("vernieuwen")){
            this.tableView.getItems().clear();
            AccountDAO accountDAO = AccountDAO.getInstance();
            List<Account> accounts = accountDAO.getAllAccounts();
            for(Account item : accounts){
                this.tableView.getItems().add(item);
            }
        }

    }
}