/**
 * Name: Joseph Davis
 * Date: 10/5/15
 * Description: Implements a triangle class that extends the abstract GeometricObject class. The test program then
 * prompts the user to enter the side measurements, color, and filled and then displays information about the triangle
 * to the user.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

public class Test {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    out.print("Enter the side lengths of the triangle: ");
    try {
      GeometricObject triangle = new Triangle(input.nextDouble(), input.nextDouble(), input.nextDouble());
      out.print("Is the triangle filled? (true/false): ");
      triangle.setFilled(input.nextBoolean());
      if (triangle.isFilled()) {
        out.print("Enter the triangle's fill color: ");
        triangle.setColor(input.next());
      }
      out.println(triangle);
    } catch (InputMismatchException ex) {
      out.println("Invalid input, try again.");
      main(args);
    }
    input.close();
  }

}
