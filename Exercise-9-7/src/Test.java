/**
 * Program Name: Account
 * Author: Joseph Davis
 * Date: September 20, 2015
 * Description: Defines a class named "Account" that meets the specified requirements. The main program creates
 * an account with an id of 1122, an initial balance of 20,000 and an annual interest rate of 4.5%. After withdrawing
 * $2,500 and then depositing $3,000, the program prints the account balance, monthly interest, and the creation date.
 */

import java.text.NumberFormat;
import static java.lang.System.out;

public class Test {
  public static void main(String[] args) {
    final NumberFormat money = NumberFormat.getCurrencyInstance();
    // create the account
    Account account = new Account(1122, 20000);
    account.setAnnualInterestRate(0.045);

    // do transactions
    account.withdraw(2500);
    account.deposit(3000);

    // print account information
    out.println("Account balance: " + money.format(account.getBalance()));
    out.println("Account monthly interest: " + money.format(account.getMonthlyInterest()));
    out.println("Account created: " + account.getDateCreated());
  }
}
