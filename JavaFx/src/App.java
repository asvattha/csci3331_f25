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
    
    boolean flag = false;

    public void start(Stage primaryStage) {
        
        BorderPane bPane = new BorderPane();

        /*Center Pane */
        StackPane centerPane = new StackPane();
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
        //MyEnlargeHandler myHandler = new MyEnlargeHandler();
        helloBtn.setOnAction((ActionEvent e) -> {
            Image image = null;
            if(flag) {
                image = new Image("images/einstein1.jfif");
            } else {
                image = new Image("images/einstein2.jfif");
            }
            flag = !flag;
            ImageView imageView2 = new ImageView(image);
            imageView2.setFitHeight(200);
            imageView2.setFitWidth(200);
            centerPane.getChildren().clear();
            centerPane.getChildren().add(imageView2);
            System.out.println("Hello");
        });

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
