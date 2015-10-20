import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 * @author Joey Davis
 */
public class CircleColorPane extends BorderPane {

  /**
   * Creates a MouseEvent handler that changes the color of the circle in a CircleColorPane
   * with the provided color.
   * @author Joey Davis
   */
  class ColorPressed implements EventHandler<MouseEvent> {
    CircleColorPane pane;
    Color color;

    public ColorPressed(CircleColorPane pane, Color color) {
      this.pane = pane;
      this.color = color;
    }

    @Override
    public void handle(MouseEvent event) {
      pane.setCircleColor(color);
    }
  }

  private Circle circle = new Circle();
  private Button colorBtn = new Button("Hold to Change Color");

  /**
   * CircleColorChangePage no-arg constructor
   */
  public CircleColorPane() {
    setBottom(colorBtn);
    setCenter(circle);

    BorderPane.setAlignment(colorBtn, Pos.BASELINE_CENTER);

    circle.setRadius(75.0);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    colorBtn.setOnMousePressed(new ColorPressed(this, Color.BLACK));
    colorBtn.setOnMouseReleased(new ColorPressed(this, Color.WHITE));
  }

  /**
   * Set the fill of the pane's circle element
   * @param color The new color to set
   */
  public void setCircleColor(Color color) {
    this.circle.setFill(color);
  }

}
