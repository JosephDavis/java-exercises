import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;


/**
 * The type GroupingSymbolValidator. This class offers static methods to validate a Java source code
 * file as specified by Exercise 20.11. Several static constants are implemented to allow more
 * efficient comparisons.
 *
 * @author Joey Davis
 */
public class GroupingSymbolValidator {
  final private static Character OPEN_PAREN = '(';
  final private static Character CLOSE_PAREN = ')';
  final private static Character OPEN_BRACE = '{';
  final private static Character CLOSE_BRACE = '}';
  final private static Character OPEN_BRACKET = '[';
  final private static Character CLOSE_BRACKET = ']';

  /**
   * Private default constructor. This class is intended to only be used statically.
   */
  private GroupingSymbolValidator() {
  }

  /**
   * Validate grouping symbols from a Java source file. Grouping symbols are valid only if they
   * form a pair and are not overlapped with another matching pair of symbols.
   * i.e. {(}) is invalid, ({}) is valid
   *
   * @param file
   *     the file to validate
   * @return the boolean denoting whether or not the grouping symbols are valid
   * @throws IOException
   *     the io exception thrown when the file specified by filename cannot be read
   */
  public static boolean validate(File file) throws IOException {
    Stack<Character> unmatched = new Stack<>();
    FileInputStream fileInputStream = new FileInputStream(file);
    int read;
    // read a byte until the end of the file is reached
    while ((read = fileInputStream.read()) != -1) {
      Character ch = (char) read;
      if (isBeginSymbol(ch)) {
        // a (beginning) grouping symbol is unmatched until its ending symbol is found
        unmatched.add(ch);
      } else if (isEndSymbol(ch)) {
        // an end symbol without a matching begin symbol is an invalid symbol
        if (unmatched.size() == 0) return false;
        // symbols must not overlap one another here -- if they do, the file is invalid
        if (isMatchedGroup(unmatched.peek(), ch)) {
          unmatched.pop();
        } else {
          return false;
        }
      }
    }
    fileInputStream.close();
    // true only if there are no unmatched characters remaining
    return unmatched.size() == 0;
  }

  /**
   * Tests whether two Characters form a valid pair.
   * A valid pair is one of:
   *    '(' and ')', '{' and '}', or '[' and ']'.
   *
   * @param left
   *     the left character
   * @param right
   *     the right character
   * @return the boolean specifying whether the two characters form a valid pair
   */
  private static boolean isMatchedGroup(Character left, Character right) {
    if (left.equals(OPEN_PAREN)) {
      return right.equals(CLOSE_PAREN);
    } else if (left.equals(OPEN_BRACE)) {
      return right.equals(CLOSE_BRACE);
    } else if (left.equals(OPEN_BRACKET)) {
      return right.equals(CLOSE_BRACKET);
    }
    return false;
  }

  /**
   * Checks if the provided character is a beginning symbol for a grouping symbol pair.
   *
   * @param c
   *     the character to test
   * @return the boolean denoting if the character is an opening grouping symbol
   */
  private static boolean isBeginSymbol(Character c) {
    return c.equals(OPEN_PAREN) || c.equals(OPEN_BRACE) || c.equals(OPEN_BRACKET);
  }

  /**
   * Checks if the provided character is an ending symbol for a grouping symbol pair.
   *
   * @param c
   *     the character to test
   * @return the boolean denoting if the character is an opening grouping symbol
   */
  private static boolean isEndSymbol(Character c) {
    return c.equals(CLOSE_PAREN) || c.equals(CLOSE_BRACE) || c.equals(CLOSE_BRACKET);
  }

}
