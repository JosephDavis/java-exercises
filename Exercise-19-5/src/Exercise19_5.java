/**
 * Student: Joseph Davis
 * Date: 11/16/15
 * Assignment: Exercise 19.5
 * Description: Implements a generic method to return the maximum element in an array
 */

import java.util.Arrays;

/**
 * Exercise 19.5 driver class.
 *
 * @author Joey Davis
 */
public class Exercise19_5 {

  /**
   * Finds the maximum element in the array.
   *
   * @param array the array to identify the maximum element in
   * @return the maximum value in the array, or null if the array has a length of 0
   */
  public static <T extends Comparable<T>> T max(T[] array) {
    T max = null;
    if (array.length == 0) return null;
    max = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i].compareTo(max) > 0) {
        max = array[i];
      }
    }
    return max;
  }

  /**
   * Test case.
   *
   * @param list     the list for this test case
   * @param expected the expected value for this test case
   */
  static <T extends Comparable<T>> void testCase(T[] list, T expected) {
    System.out.println("Test case for array: " + Arrays.asList(list));
    T actual = max(list);
    System.out.println("\texpected: " + expected + ", actual: " + actual);
    System.out.println("\t" + (actual != null && actual.equals(expected) ? "PASS" : "FAIL"));

  }

  /**
   * The entry point of the application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    // Test of an Integer array
    Integer[] integers = {10, 5, 3, 4, 5, 9, 21};
    testCase(integers, integers[6]);

    // Test of a Double array
    Double[] doubles = {20.0, 20.5, 21.0, 21.5, 22.0, 22.5, 23.0, 23.5, 24.0};
    testCase(doubles, doubles[8]);
  }
}
