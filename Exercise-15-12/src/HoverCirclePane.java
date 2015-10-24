import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


/**
 * Provides a pane with a fixed-size circle to demonstrate mouse events.
 * @author Joey Davis
 */
public class HoverCirclePane extends Pane {

  final private Circle circle = new Circle(100, 60, 50);
  private Text message = new Text();

  private EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
      // move the message to the cursor position
      message.setX(event.getX());
      message.setY(event.getY());

      // change message according to mouse position relative to the circle
      if (circle.contains(event.getX(), event.getY())) {
        message.setText("Mouse point is inside the circle");
      } else {
        message.setText("Mouse point is outside the circle");
      }
    }
  };

  /**
   * No-arg HoverCirclePane constructor
   */
  public HoverCirclePane() {
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);

    // bootstrap elements and events
    getChildren().addAll(circle, message);
    setOnMouseMoved(mouseHandler);
  }

}
