import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class GameModel {
    
    double centerX = 100, centerY = 100, radius = 25;
    int dx = 1, dy = 1;
    Timeline animation;

    IntegerProperty collisionProperty = new SimpleIntegerProperty(0);

    public void updatePosition(double viewWidth, double viewHeight) {
        moveBall(viewWidth, viewHeight);
    }

    public void moveBall(double viewWidth, double viewHeight) {
    
        if(centerX + radius >= viewWidth || centerX - radius <= 0) {
            dx *= -1;
            collisionProperty.setValue(collisionProperty.getValue() + 1);
        }
        if (centerY + radius >= viewHeight || centerY - radius <= 0) {
            dy *= -1;
            collisionProperty.setValue(collisionProperty.getValue() + 1);
        }

        centerX = centerX + dx;
        centerY = centerY + dy;

    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public IntegerProperty getCollisionProperty() {
        return collisionProperty;
    }
}
