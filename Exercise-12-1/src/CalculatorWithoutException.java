
public class CalculatorWithoutException {

  public static void main(String[] args) {
    for (String x:args) {
      System.out.println(x);
    }
    if (args.length != 3) {
      System.out.println("Usage: java Calculator operand1 operator operand2");
      System.exit(0);
    }

    if (!isNumber(args[0])) {
      System.out.println("Invalid operand: " + args[0]);
    } else if (!isNumber(args[2])) {
      System.out.println("Invalid operand: " + args[2]);
    } else {
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
    }
  }

  public static boolean isNumber(String str) {
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch < '0' || ch > '9')
        return false;
    }
    return true;
  }

}
