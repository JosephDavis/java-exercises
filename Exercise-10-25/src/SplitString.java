/**
 * Name: Joseph Davis
 * Date: September 20, 2015
 * Description: Implements a split method that splits a string into an array of strings,
 * including the delimiters
 */
import java.util.Arrays;

public class SplitString {
  /**
   * split a string on the given regex/delimiter without discarding the delimiter
   */
  public static String[] split(String s, String regex) {
    // use look ahead/behind to split on either side of the matched regex
    return s.split("(?<=" + regex + ")|(?=" + regex + ")");
  }

  public static void main(String[] args) {
    System.out.println("Split string: " + Arrays.toString(split("ab#12#453", "#")));
    System.out.println("Split string: " + Arrays.toString(split("a?b?gf#e", "[?#]")));
  }
}
