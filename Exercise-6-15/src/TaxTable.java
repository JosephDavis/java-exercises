/**
 * Program name: Tax Table
 * Author: Joseph Davis
 * Date: 9/8/2015
 * Description: Write a method for computing tax, then use the method to print a tax table
 *              for taxable income from $50,000 to $60,000 with intervals of $50
 */
public class TaxTable {
  private static double computeTaxScheme(int[] taxScheme, double taxableIncome) {
    final double[] marginalTaxRate = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
    double tax = 0;
    // top tier
    if (taxableIncome > taxScheme[4]) {
      tax += ((taxableIncome - taxScheme[4]) * marginalTaxRate[5]);
    }
    // middle tiers
    for (int i = 4; i > 0; --i) {
      if (taxableIncome > taxScheme[i - 1]) {
        if (taxableIncome < taxScheme[i])
          tax += (taxableIncome - taxScheme[i - 1]) * marginalTaxRate[i];
        else
          tax += ((taxScheme[i] - taxScheme[i - 1]) * marginalTaxRate[i]);
      }
    }
    // lowest tier
    if (taxableIncome <= taxScheme[0]) {
      tax += (taxableIncome * marginalTaxRate[0]);
    } else {
      tax += taxScheme[0] * marginalTaxRate[0];
    }

    return tax;
  }

  public static double computeTax(int status, double taxableIncome) {
    // filling status schemes
    final int[] single = { 8350, 33950, 82250, 171550, 372950 };
    final int[] joint = { 16700, 67900, 137050, 208850, 372950 };
    final int[] seperate = { 8350, 33950, 68525, 104425, 186475 };
    final int[] headOfHousehold = { 11950, 45500, 117450, 190200, 372950 };
    double tax = 0;
    switch (status) {
      case 0:
        tax = computeTaxScheme(single, taxableIncome);
        break;
      case 1:
        tax = computeTaxScheme(joint, taxableIncome);
        break;
      case 2:
        tax = computeTaxScheme(seperate, taxableIncome);
        break;
      case 3:
        tax = computeTaxScheme(headOfHousehold, taxableIncome);
        break;
    }
    return tax;
  }

  public static void main(String[] args) {
    System.out.format("%-15s%-15s%-15s%-15s%-15s%n",
      "Taxable",  "Single",  "Married Joint", "Married", "Head of");
    System.out.format("%-15s%-15s%-15s%-15s%-15s%n",
      "Income",   "",        "or Window(er)", "Separate", "Household");
    System.out.format("%1$-15s%1$-15s%1$-15s%1$-15s%1$-15s%n",
      "---------------");

    for (int i = 50000; i < 60050; i += 50) {
      System.out.format("%-15d%-15d%-15d%-15d%-15d%n",
        i,
        Math.round(computeTax(0, i)),
        Math.round(computeTax(1, i)),
        Math.round(computeTax(2, i)),
        Math.round(computeTax(3, i)));
    }
  }

}
