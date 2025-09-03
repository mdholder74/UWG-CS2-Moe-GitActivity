package edu.westga.cs1302.lab2.tests.view.bill_view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.view.BillView;
import edu.westga.cs1302.lab2.model.BillItem;

class TestGetText {
  
  private BillView billView;

  @BeforeEach
  public void setUp() {
      this.billView = new BillView();
  }

  @Test
  public void testGetTextWithEmptyBill() {
      Bill emptyBill = new Bill();
      
      String result = this.billView.getText(emptyBill);
      
      String expected = "ITEMS" + System.lineSeparator() 
                       +
                       System.lineSeparator() 
                       +
                       "SUBTOTAL - $0.0" + System.lineSeparator() 
                       +
                       "TAX - $0.0" + System.lineSeparator() 
                       +
                       "TIP - $0.0" + System.lineSeparator() 
                       +
                       "TOTAL - $0.0";
      
      assertEquals(expected, result, "Empty bill should show Total - $0.0 with formatting.");
  }
  
  @Test
  public void testGetTextWithOneItem() {
      Bill candyBill = new Bill();
      
      BillItem item = new BillItem("now & later", 3.99);
      candyBill.addItem(item);
      
      String result = this.billView.getText(candyBill);
      
      String expected = "ITEMS" + System.lineSeparator() 
                       +
                       "now & later - 3.99" + System.lineSeparator() 
                       +  
                       System.lineSeparator() 
                       +
                       "SUBTOTAL - $3.99" + System.lineSeparator() 
                       +
                       "TAX - $0.399" + System.lineSeparator() 
                       +        
                       "TIP - $0.798" + System.lineSeparator() 
                       +        
                       "TOTAL - $5.187";                               
      
      assertEquals(expected, result, "Bill with one item should show correct subtotal, tax, tip, and total.");
  }
  
  @Test
  public void testGetTextWithMultipleItems() {
      Bill candyBill = new Bill();
      
      BillItem item1 = new BillItem("Snicker", 1.99);
      BillItem item2 = new BillItem("Butterfinger", 2.99);
      
      candyBill.addItem(item1);
      candyBill.addItem(item2);
      
      String result = this.billView.getText(candyBill);
      
      String expected = "ITEMS" + System.lineSeparator() 
                         +
                         "Snicker - 1.99" + System.lineSeparator() 
                         +
                         "Butterfinger - 2.99" + System.lineSeparator() 
                         +
                         System.lineSeparator() 
                         +
                         "SUBTOTAL - $4.98" + System.lineSeparator() 
                         +
                         "TAX - $0.49800000000000005" + System.lineSeparator() 
                         +
                         "TIP - $0.9960000000000001" + System.lineSeparator() 
                         +
                         "TOTAL - $6.474000000000001";
      
      assertEquals(expected, result, "Bill with multiple items should show correct subtotal, tax, tip, and total.");
  }

}
