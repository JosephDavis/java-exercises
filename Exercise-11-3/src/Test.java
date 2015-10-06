/**
 * Name: Joseph Davis
 * Date: 9/30/15
 * Description: Implements two if Account's child classes, CheckingAccount and SavingsAccount. The
 * driver program then creates an object of each type and prints them using .toString().
 */

import static java.lang.System.out;

public class Test {

  public static void main(String[] args) {
    // prepare generic account
    Account account = new Account(1, 700);
    account.setAnnualInterestRate(0.05);

    // prepare savings account
    SavingsAccount savings = new SavingsAccount(2, 10000);
    savings.setAnnualInterestRate(0.109);

    // prepare checking account
    CheckingAccount checking = new CheckingAccount(3, 5000, 100);
    try {
      checking.deposit(4000.00);
      checking.withdraw(300.00);
    } catch (AccountException ex) {
      out.println(ex.getMessage());
    }

    // print the accounts (calls .toString())
    out.println(account);
    out.println(savings);
    out.println(checking);
  }

}
