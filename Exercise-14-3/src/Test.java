/**
 * Name: Joseph Davis
 * Date: 10/14/15
 * Description: Displays 3 cards selected randomly from a deck of 52.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setScene(new Scene(new RandomCardDisplay()));
    primaryStage.setTitle("Display 3 Random Cards");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
