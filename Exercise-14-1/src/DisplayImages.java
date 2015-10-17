/**
 * Name: Joseph Davis
 * Assignment: 14.1
 * Date: 10/12/15
 * Description: Displays four images (flags) in a grid pane as shown in Figure 14.43a in the text, page 578.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class DisplayImages extends Application {

  public void start(Stage primaryStage) throws Exception {
    ImageView ukImg = new ImageView("uk.gif");
    ImageView chinaImg = new ImageView("china.gif");
    ImageView caImg = new ImageView("ca.gif");
    ImageView usImg = new ImageView("us.gif");

    GridPane pane = new GridPane();
    pane.setPadding(new Insets(5, 5, 5, 5));
    pane.setHgap(5);
    pane.setVgap(5);
    pane.add(ukImg, 0, 0);
    pane.add(chinaImg, 0, 1);
    pane.add(caImg, 1, 0);
    pane.add(usImg, 1, 1);

    primaryStage.setScene(new Scene(pane));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
