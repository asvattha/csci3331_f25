import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class GameController {
    GameView gameView;
    GameModel gameModel;
    boolean isPaused = true;

    Timeline animation; 

    public GameController(GameView gameView, GameModel gameModel) {
        this.gameView = gameView;
        this.gameModel = gameModel;
        animation = new Timeline(new KeyFrame(Duration.millis(20), e-> setupAnimation()));
        animation.setCycleCount(Timeline.INDEFINITE);
        setupKeyControls();
        trackStatus();
    }

    public void setupAnimation() {
        gameModel.updatePosition(gameView.getWidth(), gameView.getHeight());
        gameView.updateView(gameModel.getCenterX(), gameModel.getCenterY());
    }

    public void setupKeyControls() {
        gameView.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.SPACE) {
                if(isPaused) {
                    animation.play();
                    isPaused = false;
                } else {
                    animation.pause();
                    isPaused = true;
                }
            }
        });
    }

    public void trackStatus() {
        IntegerProperty collisionProperty = gameModel.getCollisionProperty();
        collisionProperty.addListener(ov -> gameView.updateStatus(collisionProperty.getValue()));
    }
}
