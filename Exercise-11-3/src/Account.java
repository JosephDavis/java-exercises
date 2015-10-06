/**
 * Account class brought in from Programming Exercise 9.7, as instructed
 */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

public class Account {
  protected final static NumberFormat currency = DecimalFormat.getCurrencyInstance();

  private int id;
  private double balance;
  private double annualInterestRate;
  private Date dateCreated = new Date();

  /**
   * Account default constructor
   */
  public Account() {
    id = 0;
    balance = 0.0;
    annualInterestRate = 0.0;
  }

  /**
   * Account constructor for an id and a balance
   */
  public Account(int accountId, double initialBalance) {
    id = accountId;
    balance = initialBalance;
    annualInterestRate = 0.0;
  }

  /**
   * Get the account id
   */
  public int getId() {
    return id;
  }

  /**
   * Set the account id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get the account balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Set the account balance
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }

  /**
   * Get the account annual interest rate
   */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /**
   * Set the account annual interest rate
   */
  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  /**
   * Get the account creation date
   */
  public Date getDateCreated() {
    return dateCreated;
  }

  /**
   * Get the account monthly interest rate
   */
  public double getMonthlyInterestRate() {
    return annualInterestRate / 12;
  }

  /**
   * Get the account monthly interest
   */
  public double getMonthlyInterest() {
    return balance * getMonthlyInterestRate();
  }

  /**
   * Withdraw the specified amount from the account
   */
  public void withdraw(double amount) throws AccountException {
    if (amount < 0) throw new TransactionValueException(this, amount);
    if ((balance - amount) < 0) {
      throw new AccountOverdrawException(this, amount);
    }
    setBalance(balance - amount);
  }

  /**
   * Deposit the specified amount into the account
   */
  public void deposit(double amount) throws AccountException {
    if (amount < 0) throw new TransactionValueException(this, amount);
    setBalance(balance + amount);
  }

  @Override
  public String toString() {
    return "Account: " + "id = " + id + ", balance = " + currency.format(balance) +
            ", annualInterestRate = " + (annualInterestRate * 100) + "%";
  }
}
