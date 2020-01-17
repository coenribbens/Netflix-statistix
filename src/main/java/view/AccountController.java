package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AccountController implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Button btn = (Button)actionEvent.getTarget();
        if(btn.getText().equalsIgnoreCase("toevoegen")){
            System.out.println("OK!");

        }
        else if(btn.getText().equalsIgnoreCase("bewerken")){
            System.out.println("OK!");

        }
        else if(btn.getText().equalsIgnoreCase("verwijderen")){
            System.out.println("OK!");

        }

    }
}
