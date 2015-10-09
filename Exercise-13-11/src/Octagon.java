/**
 * Octagon - Assumes all sides of the octagon are equal.
 */
public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
  private double side;

  Octagon() {
    side = 1.0;
  }

  Octagon(double side) {
    setSide(side);
  }

  public double getSide() {
    return side;
  }

  public void setSide(double side) {
    this.side = side;
  }

  @Override
  public Object clone() {
    try {
      return super.clone();
    } catch(CloneNotSupportedException ex) {
      return null;
    }
  }

  public double getArea() {
    return (2 + (4 / Math.sqrt(2.0))) * side * side;
  }

  public double getPerimeter() {
    return side * 8;
  }

  @Override
  public int compareTo(Octagon octagon) {
    if(getArea() > octagon.getArea())
      return 1;
    else if (getArea() < octagon.getArea())
      return -1;
    return 0;
  }

  @Override
  public String toString() {
    return "Octagon{ " +
            "area = " + super.decimalFormat.format(getArea()) +
            ", perimeter = " + super.decimalFormat.format(getPerimeter()) +
            ", side = " + side +
            ", " + super.toString().substring(17);
  }
}
