/**
 * A class derived from GeometricObject that represents a triangle
 */
public class Triangle extends GeometricObject {
  private double side1;
  private double side2;
  private double side3;

  public Triangle() {
    side1 = side2 = side3 = 1;
  }

  public Triangle(double side1, double side2, double side3) throws GeometricLengthException {
    setSide1(side1);
    setSide2(side2);
    setSide3(side3);
  }

  public double getSide1() {
    return side1;
  }

  public void setSide1(double side1) throws GeometricLengthException {
    if (side1 <= 0) throw new GeometricLengthException(side1);
    this.side1 = side1;
  }

  public double getSide2() {
    return side2;
  }

  public void setSide2(double side2) throws GeometricLengthException {
    if (side2 <= 0) throw new GeometricLengthException(side2);
    this.side2 = side2;
  }

  public double getSide3() {
    return side3;
  }

  public void setSide3(double side3) throws GeometricLengthException {
    if (side3 <= 0) throw new GeometricLengthException(side3);
    this.side3 = side3;
  }

  public double getArea() {
    double s = getPerimeter() / 2;
    return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
  }

  public double getPerimeter() {
    return side1 + side2 + side3;
  }

  @Override
  public String toString() {
    return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3 + "\n" + super.toString();
  }
}
