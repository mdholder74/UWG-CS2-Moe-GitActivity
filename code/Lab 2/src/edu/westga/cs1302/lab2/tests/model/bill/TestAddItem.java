package edu.westga.cs1302.lab2.tests.model.bill;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;

class TestAddItem {
  
  private Bill moeBill;
  
  @BeforeEach
  public void setUp() {
    this.moeBill = new Bill();
  }

  @Test
  public void testAddItemWithValidItem() {
    BillItem item = new BillItem("Peach Rings", 1.99);
    
    this.moeBill.addItem(item);
    
    assertEquals(1, this.moeBill.getItems().size(), "Bill should have 1 item after adding an item.");
    assertEquals(item, this.moeBill.getItems().get(0), "First item should be the added item peach rings.");
  }
  
  @Test
  public void testAddItemWithMulipleValidItems() {
    BillItem item1 = new BillItem("Peach Rings", 1.99);
    BillItem item2 = new BillItem("Gummy Bears", 2.99);
    BillItem item3 = new BillItem("Life Savers", 3.99);
    
    this.moeBill.addItem(item1);
    this.moeBill.addItem(item2);
    this.moeBill.addItem(item3);
    
    assertEquals(3, this.moeBill.getItems().size(), "Bill should have 3 items after adding three items.");
    assertEquals(item1, this.moeBill.getItems().get(0), "First item should be the added item peach rings.");
    assertEquals(item2, this.moeBill.getItems().get(1), "Second item should be the added item gummy bears.");
    assertEquals(item3, this.moeBill.getItems().get(2), "Third item should be the added item life savers.");
  }
  
  @Test
  public void testAddItemWithSameItem() {
    BillItem item = new BillItem("Peach Rings", 1.99);
    
    this.moeBill.addItem(item);
    this.moeBill.addItem(item);
    
    assertEquals(2, this.moeBill.getItems().size(), "Bill should have 2 items after adding the same item twice.");
    assertEquals(item, this.moeBill.getItems().get(0), "First item should be the added item peach rings.");
    assertEquals(item, this.moeBill.getItems().get(1), "Second item should be the added item peach rings.");
    }

  @Test
  public void testAddItemWithNullItem() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      this.moeBill.addItem(null);
    });
    
    assertEquals("item must not be null.", exception.getMessage(), "Exception message should match.");
    assertEquals(0, this.moeBill.getItems().size(), "Bill should have 0 items after attempting to add null.");
    
  }
}
