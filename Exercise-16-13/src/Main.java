/**
 * Programming Exercise 16.13
 * Name: Joseph Davis
 * Date: 10/26/15
 * Description: Allows the user to enter a loan amount and loan period (in years)
 * from text fields and displays the monthly and total payment for each interest
 * rate beginning at 5% up until 8%, incremented by 1/8ths.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    Scene scene = new Scene(new LoanFormPane());
    primaryStage.setTitle("Loan Form");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
