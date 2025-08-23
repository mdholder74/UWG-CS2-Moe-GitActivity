package edu.westga.cs1302.lab1.view;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

/**
 * Test class to verify Bill and BillFormatter functionality.
 *
 * @author Moe Holder
 * @version Fall 2025
 */
public class BillTest {

  /**
   * Test class to verify Bill and BillFormatter functionality.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Create Bill
    Bill moeBill = new Bill();

    // Create item list for Bill
    BillItem candy = new BillItem("Gummy Bears", 3.99);

    // Add the item to the bill
    moeBill.addItem(candy);

    // Create formatter
    BillFormatter formatter = new BillFormatter();
    // Convert Bill info into formated text for display
    String formattedBill = formatter.getText(moeBill);

    // Display the Bill
    System.out.println(formattedBill);

  }

}
