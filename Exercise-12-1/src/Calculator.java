/**
 * Student: Joseph Davis
 * Assignment: Exercise 12.1
 * Date: September 15, 2015
 * Description: A simple command line calculator that terminates if any operand is non-numeric
 * and notifies the user. It additionally will terminate with an invalid operator.
 */
public class Calculator {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Usage: java Calculator operand1 operator operand2");
      System.exit(0);
    }

    try {
      int result = 0;

      switch (args[1].charAt(0)) {
        case '+':
          result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
          break;
        case '-':
          result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
          break;
        case '*':
          result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
          break;
        case '/':
          result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
          break;
        default:
          System.out.println("Invalid operator: " + args[1].charAt(0));
          System.exit(0);
          break;
      }
      System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);
    } catch (NumberFormatException exception) {
      System.out.println("Invalid operand: " + exception.getLocalizedMessage().substring(18));
    }
  }
}
