/**
 * Programming Exercise 17.11
 * Name: Joseph Davis
 * Date: 11/4/15
 * Description: Provides a GUI that allows the user to enter a file and split it into the selected number of pieces,
 * appending each new file created with the piece number (i.e., "file.1" "file.2" "file.n").
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The driver/test class to demonstrate FileSplitterPane's functionality.
 *
 * @author Joey Davis
 */
public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("File Splitter");
    Scene scene = new Scene(new FileSplitterPane());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
