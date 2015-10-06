/**
 * A SavingsAccount extends a basic Account to offer functionality unique to a savings account
 */
public class SavingsAccount extends Account {

  public SavingsAccount(int accountId, double initialBalance) {
    super(accountId, initialBalance);
  }

  @Override
  public void withdraw(double amount) throws AccountException {
    throw new AccountException(this, "Cannot withdraw from a savings account");
  }

  @Override
  public String toString() {
    return "Savings " + super.toString();
  }
}
