/**
 * Student: Joseph Davis
 * Assignment: Exercise 12.9
 * Date: September 15, 2015
 * Description: Implements bin2Dec, a function that converts a binary string to
 * decimal value. bin2Dec throws a custom exception named BinaryFormatException
 * when the method is called with an illegal binary string representation.
 */
import java.util.Scanner;

public class NumberFormat {
  public static void main(String[] args) {
    // get a string from the user
    System.out.print("Enter a binary number: ");
    Scanner input = new Scanner(System.in);
    String binaryString = input.next();
    try {
      System.out.println("The decimal value for the binary number " + binaryString + " is " + bin2Dec(binaryString));
    } catch (BinaryFormatException e) {
      System.out.println(e.getMessage());
    }
    input.close();
  }

  public static int bin2Dec(String binaryString) throws BinaryFormatException {
    int result = 0;
    String reversed = new StringBuilder(binaryString).reverse().toString();
    for (int i = 0; i < reversed.length(); i++) {
      if (reversed.charAt(i) == '1')
        result += Math.pow(2, i);
      else if (reversed.charAt(i) != '0')
        throw new BinaryFormatException(binaryString);
    }
    return result;
  }

}
