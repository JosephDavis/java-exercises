/**
 * Student: Joseph Davis
 * Assignment: Exercise 19.9
 * Date: 11/16/15
 * Description: Creates a generic method that sorts an ArrayList
 */

import java.util.ArrayList;

/**
 * Exercise 19.9 driver class.
 *
 * @author Joey Davis
 */
public class Exercise19_9 {

  /**
   * Sorts the elements in the provided ArrayList in ascending order
   *
   * @param list the array list to sort
   */
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(j).compareTo(list.get(i)) < 0) {
          E tmp = list.get(i);
          list.set(i, list.get(j));
          list.set(j, tmp);
        }
      }
    }
  }

  /**
   * Test case.
   *
   * @param list the array list to conduct a test for
   */
  public static <E extends Comparable<E>> void testCase(ArrayList<E> list) {
    System.out.println("Test for ArrayList: " + list);
    sort(list);
    System.out.println("\tresult: " + list);
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    ArrayList<Integer> integers = new ArrayList<>();
    integers.add(20);
    integers.add(10);
    integers.add(30);
    integers.add(40);
    integers.add(0);
    testCase(integers);

    ArrayList<Double> doubles = new ArrayList<>();
    doubles.add(43.43);
    doubles.add(22.22);
    doubles.add(98.34);
    doubles.add(19.23);
    doubles.add(98.55);
    doubles.add(21.45);
    testCase(doubles);
  }

}
