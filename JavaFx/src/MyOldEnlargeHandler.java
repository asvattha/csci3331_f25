import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MyOldEnlargeHandler implements EventHandler<ActionEvent> {

    StackPane centerPane;
    boolean flag;

    public MyOldEnlargeHandler(StackPane centerPane) {
        this.centerPane = centerPane;
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
