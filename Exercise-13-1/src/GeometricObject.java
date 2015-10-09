/**
 * The base class for Exercise 13.1
 */
import java.util.Date;

public abstract class GeometricObject {
  private String color = "white";
  private boolean filled;
  private Date dateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() {
    dateCreated = new Date();
  }

  /** Construct a geometric object with color and filled value */
  protected GeometricObject(String color, boolean filled) {
    dateCreated = new Date();
    this.color = color;
    this.filled = filled;
  }

  /** Return color */
  public String getColor() {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. */
  public boolean isFilled() {
    return filled;
  }

  /** Set filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /** Get dateCreated */
  public Date getDateCreated() {
    return dateCreated;
  }

  @Override
  public String toString() {
    return "GeometricObject{" +
            "color = '" + color + '\'' +
            ", filled = " + filled +
            ", dateCreated = " + dateCreated +
            '}';
  }

  /** Abstract method getArea */
  public abstract double getArea();

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();
}
