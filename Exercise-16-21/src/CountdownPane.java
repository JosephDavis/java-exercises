import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Displays a text field, allowing a user to enter a time (in seconds) to be used for a countdown. When the user
 * presses the enter key, a countdown animation will commence and music will be played once the animation is complete.
 *
 * @author Joey Davis
 */
public class CountdownPane extends Pane {
  private int countDown;
  private TextField counterField = new TextField();

  private Timeline countDownAnimation = new Timeline(new KeyFrame(Duration.seconds(1.0), new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
      counterField.setText("" + --countDown);
    }
  }));

  public CountdownPane() {
    counterField.setText("Enter Countdown");
    counterField.setFont(Font.font("sans-serif", 30.0));
    getChildren().add(counterField);
    registerEvent();
  }

  private void playMusic() {
    try {
      Media media = new Media(getClass().getResource("Maid with the Flaxen Hair.mp3").toURI().toString());
      System.out.println(media.getSource());
      MediaPlayer mediaPlayer = new MediaPlayer(media);
      mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
      mediaPlayer.play();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  private void registerEvent() {
    counterField.setOnKeyPressed(event -> {
      if (event.getCode().equals(KeyCode.ENTER)) {
        try {
          countDown = Integer.parseInt(counterField.getText());
          countDownAnimation.setCycleCount(countDown);
          countDownAnimation.play();
        } catch (NumberFormatException e) {
          counterField.setText("Invalid Input");
        }
      }
    });
    countDownAnimation.setOnFinished(event -> playMusic());
  }

}
