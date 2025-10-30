import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane{
    Circle ball;

    public BallPane() {
        ball = new Circle(100, 100, 20);
        ball.setFill(Color.PURPLE);
        getChildren().add(ball);
    }

    public Circle getBall() {
        return ball;
    }

    public void updateBall(double centerX, double centerY) {
        ball.setCenterX(centerX);
        ball.setCenterY(centerY);
    }
}
