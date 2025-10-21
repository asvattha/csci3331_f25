import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.beans.InvalidationListener;

public class App extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane(); 

        Circle circle = new Circle(100, 100, 50);
        pane.getChildren().add(circle);

        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Show Circle Centered using Bind Property");
        primaryStage.show();

    }
    public static void main(String[] args) throws Exception {
        // Binding Property in JavaFx
        /* For more details, please read the section 14.5 from the Introduction to Java Programming by Y D Liang 
         * You can bind a target object (of Property type) to a source object. A change in the source object will be automatically
         * reflected in the target object.
        */
/* 
        DoubleProperty x = new SimpleDoubleProperty(5.5);
        DoubleProperty y = new SimpleDoubleProperty(7.5);
        System.out.println("x : " + x.getValue() + "y : " + y.getValue());
        x.bind(y);
        System.out.println("x : " + x.getValue() + "y : " + y.getValue());
*/

        // Listeners for Observable Objects
        /*
         * For more details, please read the section 15.10 from the Introduction to Java programming by Y D Liang
         * You can add a listener to process a value change in an observable object. 
         * An instance of Observable is known as an observable object, which contains the addListener(InvalidationListener listener) method for adding a listener. The listener class must implement the functional interface InvalidationListener to overrride the invalidated(Observable ov) method for handling the value change. Once the value is changed in the Observable object, the listener is notified by invoking its invalidated(Observable ov) method. Evenr binding property is an instance of Observable such as DoubleProperty, IntegerProperty, BooleanProperty etc. 
         */

         DoubleProperty balance = new SimpleDoubleProperty();
         balance.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable ov) {
                System.out.println("The new value is " + balance.getValue());
                System.out.println("Take more actions once the balance has changed");
            }
         });

         balance.setValue(4.5);
         
        Application.launch(args);
    }
}
