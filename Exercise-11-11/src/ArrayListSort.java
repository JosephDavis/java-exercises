/**
 * Name: Joseph Davis
 * Date: 10/2/15
 * Description: Prompts the user for 5 numbers before sorting them and displaying them in ascending order to the user.
 */
import java.util.InputMismatchException;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class ArrayListSort {

  public static void sort(ArrayList<Integer> list) {
    list.sort(Comparator.<Integer>naturalOrder());
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> inputList = new ArrayList<>();
    out.println("You must enter 5 numbers to sort.");
    for (int i = 1; i < 6; i++) {
      out.print("Enter #" + i + ": ");
      try {
        inputList.add(input.nextInt());
      } catch (InputMismatchException ex) {
        out.println("Invalid input, try again.");
        input.nextLine(); // skip invalid input
        i--;
      }
    }
    sort(inputList);
    for(Integer i : inputList) {
      out.print(i + " ");
    }
  }

}
