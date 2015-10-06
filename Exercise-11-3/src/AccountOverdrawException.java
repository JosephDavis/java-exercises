public class AccountOverdrawException extends AccountException {
  private double transactionAmount;

  public AccountOverdrawException(Account account, double transactionAmount) {
    super(account, "overdraw");
    this.transactionAmount = transactionAmount;
  }

  public double getTransactionAmount() {
    return transactionAmount;
  }

  public double overdrawAmount() {
    return getAccount().getBalance() - transactionAmount;
  }

  @Override
  public String getMessage() {
    return super.toString() + ", a transaction was attempted that would overdraw the account.";
  }
}
