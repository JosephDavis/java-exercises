/**
 * The GeometricLengthException is intended to be thrown when a value will be used to represent a geometric length,
 * but is not a valid length for a geometric measurement. I.e., -1 and 0 cannot represent valid geometric lengths.
 */
public class GeometricLengthException extends NumberFormatException {
  private double lengthValue;

  public GeometricLengthException(double value) {
    super("Invalid geometric length of \"" + value + "\"");
    lengthValue = value;
  }

  public double getLengthValue() {
    return lengthValue;
  }

}
