import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

class RandomCardDisplay extends HBox {
  /**
   * Constructor
   */
  public RandomCardDisplay() {
    setPadding(new Insets(10, 10, 10, 10));
    setSpacing(10);
    populateCards();
  }

  /**
   * Get a random card filename
   */
  private static String getRandomCard() {
    int number = (int) (Math.random() * 53);
    if (number == 0) number = 1;
    if (number == 53) number = 52;
    return "card/" + number + ".png";
  }

  /**
   * populate the instance with 3 random cards
   */
  public void populateCards() {
    for (int i = 0; i < 3; i++) {
      ImageView img = new ImageView(new Image(getRandomCard()));
      img.setFitHeight(96);
      img.setFitWidth(72);
      getChildren().add(img);
    }
  }

}
