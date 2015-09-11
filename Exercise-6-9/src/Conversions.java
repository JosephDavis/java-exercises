/**
 * Program name: Conversions
 * Author: Joseph Davis
 * Date: 9/8/2015
 * Description: Print a table showing the conversions between meters and feet.
 */
import java.text.DecimalFormat;

public class Conversions {
  final static double feetInMeter = 3.279;
  final static double meterInFoot = 0.305;
  final static DecimalFormat thousandths = new DecimalFormat("0.000");

  public static double footToMeter(double foot) {
    return foot * meterInFoot;
  }

  public static double meterToFoot(double meter) {
    return meter * feetInMeter;
  }

  public static void main(String[] args) {
    System.out.format("%1$-9s%2$-9s  |  %2$-9s%1$-9s%n", "Feet", "Meters");
    System.out.println("---------------------------------------------");

    for (int feet = 1; feet < 11; feet++) {
      int meters = 20 + ((feet - 1) * 5);
      System.out.format("%-9d%-9s  |  %-9d%-9s%n",
          (int)feet,
          thousandths.format(footToMeter(feet)),
          meters,
          thousandths.format(meterToFoot(meters)));
    }
  }

}
