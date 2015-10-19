/**
 * Exercise 15.5
 * Name: Joseph Davis
 * Date: 10/18/15
 * Description: Calculates the future value of an investment at a given interest rate for a specified number of years.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Scene scene = new Scene(new InvestmentValueCalculator());
    primaryStage.setTitle("Exercise 15.5");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
