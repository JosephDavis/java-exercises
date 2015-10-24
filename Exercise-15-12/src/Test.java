/**
 * Name: Joseph Davis
 * Date: 10/23/2015
 * Assignment: Refactoring Replacement - Programming Exercise 15.12
 * Description: Draws a fixed circle centered at (100, 60) with a radius of 50. Whenever the mouse is moved, a message
 * indicating whether the mouse point is inside the circle or outside of it.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The driver program to test HoverCirclePane
 * @author Joey Davis
 */
public class Test extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Scene scene = new Scene(new HoverCirclePane(), 400, 200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Hover the Circle");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
