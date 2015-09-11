/**
 * Program name: Highest Scores
 * Author: Joseph Davis
 * Date: 9/8/2015
 * Description: Prompt the user for the number of students, then prompt for the
 *              name and score of each student. Finally, print the names of the
 *              top two student scores.
 */
import java.util.Scanner;

public class HighestScores {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String nameFirst = "unknown";
    double scoreFirst = 0.0;
    String nameSecond = "unknown";
    double scoreSecond = 0.0;

    System.out.print("Enter the number of students: ");
    int count = input.nextInt();

    for (int current = 1; current <= count; current++) {
      System.out.print("Enter student " + "#" + current + "'s name: ");
      String name = input.next();
      System.out.print("Enter student " + "#" + current + "'s score: ");
      double score = input.nextDouble();
      if (score > scoreFirst) {
        if (scoreFirst > scoreSecond) {
          nameSecond = nameFirst;
          scoreSecond = scoreFirst;
        }
        nameFirst = name;
        scoreFirst = score;
      } else if (score > scoreSecond) {
        nameSecond = name;
        scoreSecond = score;
      }
    }

    System.out.println("The student with the highest score is " + nameFirst + ".");
    System.out.println("The student with the second highest score is " + nameSecond + ".");

    input.close();
  }

}
