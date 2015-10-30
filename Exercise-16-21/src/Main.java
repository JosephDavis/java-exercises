/**
 * Programming Exercise 16.21
 * Name: Joseph (Joey) Davis
 * Date: 10/28/15
 * Description: Allows a user to enter a time period, in seconds, and begins a countdown once they hit the Enter key.
 * When the counter has expired, the program plays music continuously.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Scene scene = new Scene(new CountdownPane());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Countdown");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
