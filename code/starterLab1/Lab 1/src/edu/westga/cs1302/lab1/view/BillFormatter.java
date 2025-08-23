package edu.westga.cs1302.lab1.view;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

/**
 * Formats bill information for display.
 *
 * @author Moe Holder
 * @version Fall 2025
 */
public class BillFormatter {

  /**
   * Create a new BillFormatter.
   *
   * @precondition none
   * @postcondition none
   */
  public BillFormatter() {

  }

  /**
   * Return a String containing the list of bill items and total for the bill.
   *
   * @precondition customerBill != null
   * @postcondition none
   * @param customerBill the bill to format
   * @return a String containing the list of bill items and total for the bill
   */

  public String getText(Bill customerBill) {
    if (customerBill == null) {
      throw new IllegalArgumentException("Invalid: customer bill cannot be null.");
    }

    String text = "ITEMS" + System.lineSeparator();
    double subTotal = 0.0;
    for (BillItem item : customerBill.getItems()) {
      text += item.getName() + " - " + item.getAmount() + System.lineSeparator();
      subTotal += item.getAmount();
    }

    text += System.lineSeparator();
    text += "SUBTOTAL - $" + subTotal + System.lineSeparator();
    double tax = subTotal * Bill.TAX;
    double tip = subTotal * Bill.TIP;
    text += "TAX - $" + tax + System.lineSeparator();
    text += "TIP - $" + tip + System.lineSeparator();
    text += "TOTAL - $" + (subTotal + tip + tax);

    return text;
  }

}
