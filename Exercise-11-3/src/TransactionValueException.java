public class TransactionValueException extends AccountException {
  private double value;

  public TransactionValueException(Account account, double value) {
    super(account);
    this.value = value;
  }

  public double getValue() {
    return value;
  }

  @Override
  public String getMessage() {
    return super.toString() + ": The value " + getValue() + " is not a valid monetary value.";
  }
}
