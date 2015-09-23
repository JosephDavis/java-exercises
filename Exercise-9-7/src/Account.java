import java.util.Date;

public class Account {
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
  public void withdraw(double amount) {
    setBalance(balance - amount);
  }

  /**
   * Deposit the specified amount into the account
   */
  public void deposit(double amount) {
    setBalance(balance + amount);
  }
}
