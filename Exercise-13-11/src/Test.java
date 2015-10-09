/**
 * Student: Joseph Davis
 * Date: 10/5/15
 * Description: Creates an Octagon object with a side value of 5 and displays its area and perimeter.
 * Then the program creates a new object using the clone method and compares the two objects using compareTo.
 */

import static java.lang.System.out;

public class Test {

  public static void testCompareTo(String msg, Octagon octagon1, Octagon octagon2) {
    out.println("\noctagon1: " + octagon1);
    out.println("octagon2: " + octagon2);
    out.println(msg + octagon1.compareTo(octagon2));
  }

  public static void main(String[] args) {
    Octagon octagon1 = new Octagon(5);
    Octagon octagon2 = (Octagon) octagon1.clone();

    out.println("octagon2 references to a different object than octagon1, expect yes: " + (octagon1 != octagon2 ? "yes" : "no"));

    testCompareTo("Equal to, expect 0: ", octagon1, octagon2);
    octagon2.setSide(4);
    testCompareTo("Greater than, expect 1: ", octagon1, octagon2);
    octagon2.setSide(6);
    testCompareTo("Less than, expect -1: ", octagon1, octagon2);
  }

}
