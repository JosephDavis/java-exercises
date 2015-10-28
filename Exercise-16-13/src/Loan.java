public class Loan {

  private double interestRate;
  private double loanAmount;
  private int numberOfYears;

  public Loan(double interestRate, double loanAmount, int numberOfYears) {
    this.interestRate = interestRate;
    this.loanAmount = loanAmount;
    this.numberOfYears = numberOfYears;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  public double getLoanAmount() {
    return loanAmount;
  }

  public void setNumberOfYears(int numberOfYears) {
    this.numberOfYears = numberOfYears;
  }

  public int getNumberOfYears() {
    return numberOfYears;
  }

  public double getTotalPayment() {
    return getMonthlyPayment() * 12 * numberOfYears;
  }

  public double getMonthlyPayment() {
    double monthlyInterestRate = interestRate / 12;
    return loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
  }

}
