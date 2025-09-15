package edu.westga.cs1302.bill.model;

/** Handles calculations for bill totals, tax, and tip.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillCalculator {
  
  /** Calculate the subtotal for an array of BillItem objects
   * 
   * @precondition billItems != null && no element in billItems is null
   * @postcondition none
   * 
   * @param billItems the array of BillItem objects to calculate subtotal for
   * @return the subtotal of all billItems
   */
  public static double calculateSubtotalItems(BillItem[] billItems) {
    if (billItems == null) {
      throw new IllegalArgumentException("Invalid: billItems in the array cannot be null");
    }
    
    double subtotal = 0.0;
    for (BillItem item : billItems) {
      if (item == null) {
        throw new IllegalArgumentException("Invalid: billItems array cannot be null elements");
      }
      subtotal += item.getAmount();
    }
    return subtotal;
  }
  
  /** Calculate the tax for an array of BillItem objects
   * 
   * @precondition billItems != null && no element in billItems is null
   * @postcondition none
   * 
   * @param billItems the array of BillItem objects to calculate tax for
   * @return the tax amount based on the subtotal
   */
  public static double calculateTaxItems(BillItem[] billItems) {
    double subtotal = calculateSubtotalItems(billItems);
    return subtotal * Bill.TAX_RATE;
  }
  
  /** Calculate the tip for an array of BillItem objects
   * 
   * @precondition billItems != null && no element in billItems is null
   * @postcondition none
   * 
   * @param billItems the array of BillItem objects to calculate tip for
   * @return the tip amount based on the subtotal
   */
  public static double calculateTipItems(BillItem[] billItems) {
    double subtotal = calculateSubtotalItems(billItems);
    return subtotal * Bill.TIP_RATE;
  }
  
  /** Calculate the total for an array of BillItem objects
   * 
   * @precondition billItems != null && no element in billItems is null
   * @postcondition none
   * 
   * @param billItems the array of BillItem objects to calculate total for
   * @return the total amount including subtotal, tax, and tip
   */
  public static double calculateTotalIems(BillItem[] billItems) {
    double subtotal = calculateSubtotalItems(billItems);
    double tax = calculateTaxItems(billItems);
    double tip = calculateTipItems(billItems);
    return subtotal + tax + tip;
  }

}
