package app;

import java.util.*;

public class CashRegister {

    double total; // The total amount of money in the cash register.
    double purchaseAmount; // The total amount of the current purchases.
    double paymentAmount; // The total amount paid.

    public CashRegister() {
        total = 0.0;
        purchaseAmount = 0.0;
        paymentAmount = 0.0;
    }

    /**
     * Records the sale of an item for some amount.
     * The purchase amount should include the cost of this item.
     *
     * In the case of a refund, amount will be negative.
     * @return Returns the total amount of current customer's purchases.
     */
    public double recordPurchase(double amount) {
        // Add this purchase amount to the total purchase amount.
        purchaseAmount += amount;
        return purchaseAmount;
    }

    /**
     * Enters the payment received from the customer.
     * @return Returns the total amount paid by the customer.
     */
    public double enterPayment(double payment) {
        // Update the payment amount.
        paymentAmount += payment;
        // Update the register total.
        total += payment;
        return paymentAmount;
    }

    /**
     * Adds the amount of money to the cash register.
     * @return Returns the total amount of money in the register.
     */
    public double addMoney(double money) {
        // Update the register total.
        total += money;
        return total;
    }

    /**
     * Returns the amount owed if any is owed.
     */
    public double giveChange() {
        // Compute the amount of change.
        double amountOwed = paymentAmount - purchaseAmount;

        // If the payment is not sufficient return no change.
        if (amountOwed < 0) {
            return 0.0;
        }

        // Update the register total with the amount given in change.
        total -= amountOwed;
        purchaseAmount = 0.0;
        paymentAmount = 0.0;
        return amountOwed;
    }

    /**
     * Returns the total amount of money in the cash register.
     */
    public double getTotal() {
        return total;
    }
}
