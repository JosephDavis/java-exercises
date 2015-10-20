/**
 * Exercise 15.7
 * Name: Joseph Davis
 * Date: 10/19/15
 * Description: Displays a circle as black while a button is pressed and returns the circle to white when the button is
 * released.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Joey Davis
 */
public class Test extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Scene scene = new Scene(new CircleColorPane());
    primaryStage.setHeight(300.0);
    primaryStage.setWidth(300.0);
    primaryStage.setTitle("Change Circle Color");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
