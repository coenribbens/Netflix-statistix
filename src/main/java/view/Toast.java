package view;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;

public final class Toast
{
    public static void createToast(Stage primaryStage, String toastMsg)
    {
        Stage toastStage=new Stage();

        toastStage.initOwner(primaryStage); // Definieer de hoofdstage.
        toastStage.setResizable(true);
        toastStage.initStyle(StageStyle.TRANSPARENT);


        // Berekent het middenpunt van de Primarystage.
        ChangeListener<Number> widthListener = (observable, oldValue, newValue) -> {
            double stageWidth = newValue.doubleValue();
            toastStage.setX(primaryStage.getX() + primaryStage.getWidth() / 2 - stageWidth / 2);
        };

        ChangeListener<Number> heightListener = (observable, oldValue, newValue) -> {
            double stageHeight = newValue.doubleValue();
            toastStage.setY(primaryStage.getY() + primaryStage.getHeight() / 2 - stageHeight / 2);
        };

        toastStage.widthProperty().addListener(widthListener);
        toastStage.widthProperty().addListener(heightListener);


        toastStage.setOnShown(event -> {
            toastStage.widthProperty().removeListener(widthListener);
            toastStage.heightProperty().removeListener(heightListener);
        });





        Text text = new Text(toastMsg);
        text.setFont(Font.font("Arial", 20));
        text.setFill(Color.WHITE);

        StackPane root = new StackPane(text);
        root.setStyle("-fx-background-radius: 10; -fx-background-color: rgba(0, 0, 0, 0.2); -fx-padding: 50px;");
        root.setOpacity(0);


        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);



        toastStage.setScene(scene);


      toastStage.show();


        Timeline fadeInTimeline = new Timeline();
        KeyFrame fadeInKey1 = new KeyFrame(Duration.millis(1000), new KeyValue (toastStage.getScene().getRoot().opacityProperty(), 1));
        fadeInTimeline.getKeyFrames().add(fadeInKey1);
        fadeInTimeline.setOnFinished((ae) ->
        {
            new Thread(() -> {
                try
                {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e)
                {

                    e.printStackTrace();
                }
                Timeline fadeOutTimeline = new Timeline();
                KeyFrame keyframe = new KeyFrame(Duration.millis(1000), new KeyValue (toastStage.getScene().getRoot().opacityProperty(), 0));
                fadeOutTimeline.getKeyFrames().add(keyframe);
                fadeOutTimeline.setOnFinished((aeb) -> toastStage.close());
                fadeOutTimeline.play();
            }).start();
        });
        fadeInTimeline.play();
    }


}