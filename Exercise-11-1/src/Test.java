/**
 * Name: Joseph Davis
 * Date: 9/28/15
 * Assignment: Exercise 11.1
 * Description:  Design a class named "Triangle" that extends "GeometricObject." The test/driver program prompts the
 * user for the triangle sides, color, and fill before printing out the details of the Triangle.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

public class Test {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double[] sides = new double[3];

    out.println("Creating a triangle...");

    for (int i = 1; i < 4; i++) {
      try {
        out.print("Enter the length of side #" + i + ": ");
        sides[i - 1] = input.nextDouble();
      } catch (InputMismatchException ex) {
       out.println("Invalid number, try again.");
        input.next(); // discard invalid input
        i -= 1; // reset the current iteration
      }
    }
    while(true) {
      try {
        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
        out.print("Enter the color of the triangle: ");
        triangle.setColor(input.next());
        out.print("Enter 'true' if the triangle is filled, otherwise 'false': ");
        triangle.setFilled(input.nextBoolean());
        out.println("\n" + triangle);
        out.printf("area: %.3f%n", triangle.getArea());
        break;
      } catch(GeometricLengthException ex) {
        out.println("A triangle side cannot have a length of " + ex.getLengthValue() + "!");
        break;
      } catch(InputMismatchException ex) {
        input.nextLine(); // discard invalid input
        out.println("Invalid input value, try again.");
      }
    }
  }
}
