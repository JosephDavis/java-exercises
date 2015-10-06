/**
 * A generic exception for an account.
 */
public class AccountException extends Exception {
  private Account account;
  private String message;

  public AccountException(Account account) {
    this.account = account;
  }

  public AccountException(Account account, String message) {
    this.account = account;
    this.message = message;
  }

  public Account getAccount() {
    return account;
  }

  @Override
  public String getMessage() {
    if (message.length() > 0) return message;
    else return "Error with Account of id " + account.getId();
  }
}
