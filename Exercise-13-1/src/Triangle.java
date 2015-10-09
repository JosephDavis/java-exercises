/**
 *
 */
public class Triangle extends GeometricObject {
  private double side1, side2, side3;

  public Triangle() {
    side1 = side2 = side3 = 1;
  }

  public Triangle(double side1, double side2, double side3) {
    setSide1(side1);
    setSide2(side2);
    setSide3(side3);
  }

  public double getSide1() {
    return side1;
  }

  public void setSide1(double side1) {
    this.side1 = side1;
  }

  public double getSide2() {
    return side2;
  }

  public void setSide2(double side2) {
    this.side2 = side2;
  }

  public double getSide3() {
    return side3;
  }

  public void setSide3(double side3) {
    this.side3 = side3;
  }

  public double getArea() {
    return 0;
  }

  public double getPerimeter() {
    return side1 + side2 + side3;
  }

  @Override
  public String toString() {
    return "Triangle{" +
            "side1 = " + side1 +
            ", side2 = " + side2 +
            ", side3 = " + side3 +
            "\n\t" + super.toString() +
//            ", color='" + getColor() + '\'' +
//            ", filled=" + isFilled() +
//            ", dateCreated=" + getDateCreated() +
            '}';
  }
}
