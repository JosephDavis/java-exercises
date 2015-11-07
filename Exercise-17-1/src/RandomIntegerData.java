/**
 * Programming Exercise 17.1
 * Name: Joseph Davis
 * Date: 11/2/2015
 * Description: Writes 100 integers generated randomly into a file using text I/O.
 * Integers should be separated by a space.
 */
import java.io.*;
import java.util.Random;

/**
 * Creates an output stream to a file named "Exercise17_02.txt" and writes 100 random integers,
 * appending to the file if it already exists.
 *
 * @author Joey Davis
 */
public class RandomIntegerData {

  public static void main(String[] args) throws IOException {
    // java.util.Random will provide random integers of that are both positive and negative
    Random random = new Random();
    // append to file (if it exists)
    FileOutputStream output = new FileOutputStream("Exercise17_02.txt", true);
    PrintWriter printer = new PrintWriter(output);
    // write 100 random integers
    for (int i = 0; i < 100; i++) {
      printer.print(random.nextInt());
      printer.print(' ');
    }
    // ensure no integers are left in the output stream buffer
    printer.flush();
  }

}
