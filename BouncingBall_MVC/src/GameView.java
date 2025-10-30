import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

public class GameView extends BorderPane{
    BallPane ballPane;
    StatusPane statusPane;

    public GameView() {
        this.ballPane = new BallPane();
        this.statusPane = new StatusPane();
        setCenter(ballPane);
        setBottom(statusPane);
    }

    // Interface to communicate with the Model
    public void updateView(double centerX, double centerY) {
        ballPane.updateBall(centerX, centerY);
    }

    public void updateStatus(int collision) {
        statusPane.updateLabel(collision);
    }

}
