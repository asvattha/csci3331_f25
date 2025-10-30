import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) {

        GameView rootView = new GameView();
        GameModel gameModel = new GameModel();
        GameController gameController = new GameController(rootView, gameModel);
        Scene scene = new Scene(rootView, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        rootView.requestFocus();
    }
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}
