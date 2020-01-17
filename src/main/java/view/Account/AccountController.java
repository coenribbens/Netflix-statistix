package view.Account;

import datalayer.AccountDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import models.Account;
import view.LogInApplication;

public class AccountController implements EventHandler<ActionEvent> {
    private TableView tableView;

    public AccountController(TableView tableView){
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
            System.out.println("OK!");

        }
        else if(btn.getText().equalsIgnoreCase("verwijderen")){
            Account selectedItem = (Account)this.tableView.getSelectionModel().getSelectedItem();
            AccountDAO accountDAO = new AccountDAO();
            accountDAO.deleteAccount(selectedItem);
            this.tableView.getItems().remove(selectedItem);

        }

    }
}
