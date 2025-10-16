import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class App extends Application {

    boolean isPaused = true;
    BallPane ballPane = new BallPane();

    public void start(Stage primaryStage) {
        
        ballPane.setOnKeyPressed(e -> {
            switch(e.getCode()) {
                case SPACE -> moveBall(e);
                case UP -> ballPane.increaseSpeed();
                case DOWN -> ballPane.decreaseSpeed();
            }
        });
        

        /* 
        EventHandler<KeyEvent> key_controls = e -> {
            if(e.getCode() == KeyCode.SPACE) {
                if(isPaused) {
                    ballPane.play();
                    isPaused = false;
                } else{
                    ballPane.pause();
                    isPaused = true;
                }
            }
            if(e.getCode() == KeyCode.UP) {
                ballPane.increaseSpeed();
            }
        };
        ballPane.setOnKeyPressed(key_controls);
        */

        Scene scene = new Scene(ballPane, 700, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        ballPane.requestFocus();

    }

    public void moveBall(KeyEvent e) {
        if(e.getCode() == KeyCode.SPACE) {
            if(isPaused) {
                ballPane.play();
            } else{
                ballPane.pause();
            }
            isPaused = !isPaused;
        }
    }
    public static void main(String[] args) throws Exception {
        Application.launch();
    }
}
