/**
 * Name: Joseph Davis
 * Assignment: Programming Exercise 20.11
 * Date: 11/23/15
 * Description: Checks whether a Java source-code file has correct pairs of grouping symbols --
 * grouping symbols are defined as parentheses, braces, and brackets. The name of the source file
 * will be passed as a command-line argument.
 *
 * Note:
 *    test_valid.java, test_invalid_1.java, and test_invalid_2.java are test files for this driver
 *    program. Those marked "invalid" should fail validation and the inverse is true for the file
 *    marked as valid.
 */
import java.io.File;
import java.io.IOException;

/**
 * The type Main is the driver class for Programming Exercise 20.11.
 *
 * @author Joey Davis
 */
public class Main {

  /**
   * The entry point of application.
   *
   * @param args
   *     the input arguments
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify a filename in the command line arguments.");
    } else {
      String filename = args[0];
      try {
        if (GroupingSymbolValidator.validate(new File(filename))) {
          System.out.println("PASS: grouping symbols in " + filename + " are valid.");
        } else {
          System.out.println("FAIL: grouping symbols in " + filename + " are invalid.");
        }
      } catch (IOException exception) {
        System.out.println("Unable to read file.");
      }
    }
  }

}
