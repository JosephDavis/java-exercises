/**
 * Name: Joseph Davis
 * Assignment: Programming Exercise 20.3
 * Date: 11/23/15
 * Description: Repeatedly prompts the user to enter a capital for a state. Upon receiving the
 * input, the program reports whether or not the answer is correct. The user's answer is not case
 * sensitive, so "indianapolis," "Indianapolis," and "iNdIaNaPoLiS" are all correct as Indiana's
 * capital. The order of states should be random.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * The type Main. Main implements the driver program for Exercise 20.3.
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
    Scanner input = new Scanner(System.in);
    ArrayList<State> states = State.stateArrayList();
    // randomize the order of the states
    Collections.shuffle(states);

    int correctCount = 0;

    for (State state : states) {
      System.out.print("What is the capital of " + state.getName() + "? ");
      // we want the nextLine, rather than simply next, otherwise a capital with multiple words
      // would not be correctly obtained from the input
      String answer = input.nextLine();
      if (state.getCapital().equalsIgnoreCase(answer.toLowerCase())) {
        System.out.println("Your answer is correct");
        correctCount++;
      } else {
        System.out.println("The correct answer should be " + state.getCapital());
      }
    }

    System.out.println("The correct count is " + correctCount);
    input.close();
  }

}
