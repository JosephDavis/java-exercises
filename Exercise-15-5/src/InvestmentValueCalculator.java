import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.text.NumberFormat;

/**
 * An investment value calculator view, providing on-demand calculation of a future investment value when the user
 * enters values and clicks the "Calculate" button.
 *
 * @author Joey Davis
 */
public class InvestmentValueCalculator extends GridPane {

  private NumberFormat money = NumberFormat.getCurrencyInstance();

  /**
   * Compute the future value of the provided arguments
   *
   * @param investmentAmount The initial investment amount
   * @param annualInterestRate The annual interest rate per period (per year)
   * @param years The number of years (or periods)
   * @return Future value as computed using the future value formula
   */
  static double computeFutureValue(double investmentAmount, double annualInterestRate, int years) {
    return investmentAmount * Math.pow(1 + (annualInterestRate / 12.0), (years * 12));
  }

  /**
   * Handler for when the "Calculate" button in the InvestmentValueCalculator view is clicked.
   *
   * @author Joey Davis
   */
  private class CalculateHandler implements EventHandler<MouseEvent> {

    private InvestmentValueCalculator calculator;

    /**
     * CalculateHandler Constructor
     * @param calculator The InvestmentValueCalculator instance this handler belongs to.
     */
    public CalculateHandler(InvestmentValueCalculator calculator) {
      this.calculator = calculator;
    }

    /**
     * Handles a trigger event for the InvestmentValueCalculator instance
     * @param event The mouse event
     */
    @Override
    public void handle(MouseEvent event) {
      try {
        double futureValue = InvestmentValueCalculator.computeFutureValue(
            calculator.getInvestmentAmount(),
            calculator.getInterestRate(),
            calculator.getYears()
        );
        calculator.setFutureValueFieldValue(futureValue);
      } catch (NumberFormatException ex) {
        calculator.setFutureValueFieldValue("Bad Input");
      }
    }

  }
  private TextField investmentAmountField = new TextField();
  private TextField yearsField = new TextField();
  private TextField interestRateField = new TextField();
  private TextField futureValueField = new TextField();
  private Button calculateButton = new Button();

  /**
   * InvestmentValueCalculator no-arg constructor
   */
  public InvestmentValueCalculator() {
    calculateButton.setText("Calculate");
    calculateButton.setOnMouseReleased(new CalculateHandler(this));
    configureColumns();
    configureAlignment();
    configureSpacing();
  }

  /**
   * Configure the spacing for the investment value calculator
   */
  private void configureSpacing() {
    setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
    setHgap(10.0);
    setVgap(10.0);
  }

  /**
   * Configure the alignment of elements within the calculator
   */
  private void configureAlignment() {
    investmentAmountField.setAlignment(Pos.BASELINE_RIGHT);
    yearsField.setAlignment(Pos.BASELINE_RIGHT);
    interestRateField.setAlignment(Pos.BASELINE_RIGHT);
    futureValueField.setAlignment(Pos.BASELINE_RIGHT);

    GridPane.setHalignment(calculateButton, HPos.RIGHT);
  }

  /**
   * Mount scene elements on the investment calculator
   */
  private void configureColumns() {
    addColumn(0,
        new Label("Investment Amount:"),
        new Label("Number of Years:"),
        new Label("Annual Interest Rate:"),
        new Label("Future value:")
    );
    addColumn(1,
        investmentAmountField,
        yearsField,
        interestRateField,
        futureValueField,
        calculateButton
    );
  }

  /**
   * Getter for the investment amount field value
   * @return The value of the investmentAmountField parsed as a double
   */
  public double getInvestmentAmount() {
    return Double.parseDouble(investmentAmountField.getText());
  }

  /**
   * Getter for the interest rate field value
   * @return The value of the interestRateField parsed as a double
   */
  public double getInterestRate() {
    return Double.parseDouble(interestRateField.getText()) / 100.0;
  }

  /**
   * Getter for the years field value
   * @return The value of the yearsField parsed as an integer
   */
  public int getYears() {
    return Integer.parseInt(yearsField.getText());
  }

  /**
   * Setter for the futureValueField value
   * @param futureValue The future value to display
   */
  public void setFutureValueFieldValue(double futureValue) {
    futureValueField.setText(money.format(futureValue));
  }

  /**
   * Overload for setting the futureValueField value to a string
   * @param msg The message to display in the future value box (an error message)
   */
  public void setFutureValueFieldValue(String msg) {
    futureValueField.setText(msg);
  }

}
