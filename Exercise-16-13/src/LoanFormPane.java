import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class LoanFormPane extends BorderPane {

  static final NumberFormat money = DecimalFormat.getCurrencyInstance();

  private TextField loanAmountField = new TextField();
  private TextField numberOfYearsField = new TextField();
  private TextArea result = new TextArea();

  private EventHandler<ActionEvent> showTableEvent = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
      double loanAmount;
      int numYears;
      try {
        loanAmount = getLoanAmount();
      } catch (NumberFormatException e) {
        result.setText("Invalid Loan Amount");
        return; // don't continue
      }
      try {
        numYears = getNumYears();
      } catch (NumberFormatException e) {
        result.setText("Invalid Number of Years");
        return; // don't continue
      }
      generateResult(loanAmount, numYears);
    }
  };

  private void generateResult(double loanAmount, int numYears) {
    String loansList = String.format("%-20s%-20s%-20s%n", "Interest Rate", "Monthly Payment", "Total Payment");
    for (double interestRate = 0.05; interestRate < 0.08125; interestRate += 0.00125) {
      Loan loan = new Loan(interestRate, loanAmount, numYears);
      loansList += String.format(
          "%-20.3f %-20s %-20s %n",
          loan.getInterestRate() * 100,
          money.format(loan.getMonthlyPayment()),
          money.format(loan.getTotalPayment()));
    }
    result.setText(loansList);
  }

  public LoanFormPane() {
    HBox form = new HBox();
    form.setSpacing(10.0);
    form.setAlignment(Pos.CENTER);
    Button showTableBtn = new Button("Show Table");
    showTableBtn.setOnAction(showTableEvent);

    form.getChildren().addAll(
        new Label("Loan Amount:"),
        loanAmountField,
        new Label("Number of Years:"),
        numberOfYearsField,
        showTableBtn);
    result.setEditable(false);
    setTop(form);
    setCenter(result);
  }

  public double getLoanAmount() throws NumberFormatException {
    return Double.parseDouble(loanAmountField.getText());
  }

  public int getNumYears() throws NumberFormatException {
    return Integer.parseInt(numberOfYearsField.getText());
  }

}
