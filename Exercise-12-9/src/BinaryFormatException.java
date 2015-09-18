// ignore serial compiler warning, java will generate on when one is not provided
@SuppressWarnings("serial")
public class BinaryFormatException extends NumberFormatException {
  private String binaryString;

  public BinaryFormatException(String binaryString) {
    super("Invalid binary string: \"" + binaryString + "\"");
    this.binaryString = binaryString;
  }

  public String getBinaryString() {
    return binaryString;
  }
}