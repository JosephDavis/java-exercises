/**
 * A CheckingAccount extends a basic Account to offer functionality unique to a checking account
 */
public class CheckingAccount extends Account {
  private double overdraftLimit;

  public CheckingAccount(int accountId, double initialBalance, double overdraftLimit) {
    super(accountId, initialBalance);
    setOverdraftLimit(overdraftLimit);
  }

  public double getOverdraftLimit() {
    return overdraftLimit;
  }

  public void setOverdraftLimit(double overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
  }

  @Override
  public void withdraw(double amount) throws AccountException {
    if ((getBalance() - amount) < -overdraftLimit) {
      throw new AccountOverdrawException(this, amount);
    }
    super.withdraw(amount);
  }

  @Override
  public String toString() {
    return  "Checking " + super.toString() + ", overdraftLimit = " + Account.currency.format(overdraftLimit);
  }
}
