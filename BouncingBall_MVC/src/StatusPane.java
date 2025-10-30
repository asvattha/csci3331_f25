import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StatusPane extends HBox{
    
    Label label;

    public StatusPane() {
        label = new Label("Total Collisions: 0");
        getChildren().add(label);
    }

    public Label getLabel() {
        return label;
    }

    public void updateLabel(int collision) {
        label.setText("Total Collisions: " + collision);
    }
}
