import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class BeginnersInterface  extends Application implements EventHandler<ActionEvent> {

    private Button inloggen;
    private Button Registreren;
    private Label Intro;
    private TextField inlognaam;
    private TextField wachtwoord;
    private BorderPane borderPane;
    private TextField username;
    private HBox Inloggenregistreren;
    private HBox VerzendenTeruggaan;
    private Button Teruggaan;
    private Button Send;
    private Scene scene1;
    private Stage window;
    private String selectedUsername;

    public BeginnersInterface(){

    }
    public Stage getstage(){
        return this.window;
    }


    @Override
    public void start(Stage stage)  {


        window = stage;
        borderPane = new BorderPane();
        inloggen = new Button("Inloggen");
        Registreren = new Button("registeren");
        inloggen.setOnAction(this);
        Registreren.setOnAction(this);
        inloggen.setStyle("-fx-font-size:40");
        Registreren.setStyle("-fx-font-size:40");
        inlognaam = new TextField();
        Inloggenregistreren = new HBox();
        Inloggenregistreren.getChildren().addAll(inloggen,Registreren);
        Inloggenregistreren.setSpacing(20);
        Teruggaan = new Button("Ga terug ");
        Teruggaan.setOnAction(this);
        Send = new Button ("Versturen");
        Send.setStyle("-fx-font-size:40");
        Send.setOnAction(this);
        Teruggaan.setStyle("-fx-font-size:40");
        VerzendenTeruggaan = new HBox();
        VerzendenTeruggaan.getChildren().addAll(Send,Teruggaan);
        VerzendenTeruggaan.setSpacing(20);


        borderPane.setCenter(Inloggenregistreren);
        Image Netflixlogo = new Image ("./main/java/NetflixFoto.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(Netflixlogo);
        imageView.preserveRatioProperty();
        Intro = new Label("Welkom bij NetflixStatics \n Hier kan je zien wat je allemaal bekeken hebt en wat wij je aanraden! \n \n \n " +
                "Gemaakt door Thomas Meeusen, Marcello Haddeman en Coen Ribbens uit 23INVT1A  "  );
        Intro.setMinSize(100,100);
        Intro.setStyle("-fx-background-color:POWDERBLUE"); // NOI18N
        borderPane.setBottom(Intro);
        borderPane.setTop(imageView);
        scene1 = new Scene(borderPane);


        window.setScene(scene1);
        window.setTitle("Welkom bij NetflixStatistics!");
        window.setResizable(false);
        window.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource()==inloggen){

            borderPane.getChildren().remove(Intro);
            borderPane.getChildren().remove(Inloggenregistreren);
            VBox inlogstructuur = new VBox();
            Label usernameinvullen = new Label("Vul uw username in");
            username = new TextField();
            Label Wachtwoord = new Label("Vul uw wachtwoord in");
            wachtwoord = new TextField();
            inlogstructuur.getChildren().addAll(usernameinvullen,username,Wachtwoord,wachtwoord);
            inlogstructuur.setSpacing(10);

            borderPane.setCenter(inlogstructuur);
            borderPane.setBottom(VerzendenTeruggaan);

        }
        else if (event.getSource()==Teruggaan){
            start(window);

        }

        else if (event.getSource()==Send) {

            if (username.getText().equals("") && wachtwoord.getText().equals("")) {
                username.setText("Vult u alstublieft een gebruikersnaam in");
                wachtwoord.setText("Vult u alstublieft een wachtwoord in");
            }
            else if(username.getText().equals("")) {
                username.setText("Vult u alstublieft een gebruikersnaam in");
            }
            else if (wachtwoord.getText().equals("")){
                wachtwoord.setText("Vult u alstublieft een wachtwoord in");
            }
            else {
                DatabaseConnection xrx = new DatabaseConnection("jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=NetflixStatistics;integratedSecurity=true;");
                Boolean Accountgevonden = xrx.inloggen(username.getText(),wachtwoord.getText());
                if (Accountgevonden == true){
                    this.selectedUsername = username.getText();
                    window.close();}
                else {
                    username.setText("Sorry, het wachtwoord is onjuist!");
                }
            }
        }


    }

    public void run (){

    }







    public static void main(String[] args) {
        launch(BeginnersInterface.class);
    }
}
