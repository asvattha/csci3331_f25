import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {
    Circle ball;
    double centerX = 100, centerY = 100, radius = 25; 
    int dx = 1, dy = 1;
    Timeline animation;
    double speed = 1;

    public BallPane() {
        ball = new Circle(centerX, centerY, radius);
        ball.setFill(Color.GREEN);
        getChildren().add(ball);

        animation = new Timeline(new KeyFrame(Duration.millis(20), e->moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void increaseSpeed() {
        if(speed <= 5)
            speed += 1;
    }

    public void decreaseSpeed() {
        if(speed > 0) 
            speed -= 1;
    }

    private void moveBall() {
        if(centerY + radius >= getHeight() || centerY - radius <= 0) {
            dy *= -1;
        }
        if(centerX + radius >= getWidth() || centerX - radius <= 0) {
            dx *= -1;
        }
        centerX += dx * speed;
        centerY += dy * speed;
        ball.setCenterX(centerX);
        ball.setCenterY(centerY);
    }

    
}
