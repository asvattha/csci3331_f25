import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application{
    

    public void start(Stage primaryStage) {
        
        StackPane centerPane = new StackPane();

        class MyEnlargeHandler implements EventHandler<ActionEvent> {

            boolean flag;

            public MyEnlargeHandler() {
                flag = false;
            }

            @Override
            public void handle(ActionEvent e) {
                Image img = null;
                if(flag) {
                    img = new Image("images/einstein1.jfif");
                } else {
                    img = new Image("images/einstein2.jfif");
                }
                flag = !flag;
                ImageView imageView = new ImageView(img);
                imageView.setFitHeight(200);
                imageView.setFitWidth(200);
                centerPane.getChildren().clear();
                centerPane.getChildren().add(imageView);
                System.out.println("Hello");
            }
        }
        
        BorderPane bPane = new BorderPane();

        /*Center Pane */
        
        Image img = new Image("images/einstein1.jfif");
        ImageView imageView = new ImageView(img);
        centerPane.getChildren().add(imageView);

        bPane.setCenter(centerPane);

        /*Bottom Pane */
        HBox bottomPane = new HBox();
        Button helloBtn = new Button("Hello");
        bottomPane.getChildren().addAll(helloBtn);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setSpacing(20);

        bPane.setBottom(bottomPane);

        /* Handling event on buttons */
        MyEnlargeHandler myHandler = new MyEnlargeHandler();
        helloBtn.setOnAction(myHandler);

        /* setting up Scene */
        Scene scene = new Scene(bPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }
    public static void main(String[] args) throws Exception {
        Application.launch();
    }
}
