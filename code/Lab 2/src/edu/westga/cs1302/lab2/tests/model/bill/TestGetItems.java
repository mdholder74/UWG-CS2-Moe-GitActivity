package edu.westga.cs1302.lab2.tests.model.bill;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;

class TestGetItems {
  
  private Bill moeBill;
  
  @BeforeEach
  public void setUp() {
    this.moeBill = new Bill();
  }

  @Test
  public void testGetItemsNotNull() {
    assertNotNull(this.moeBill.getItems());
    
  }
  
  @Test
  public void testGetItemsInitiallyEmpty() {
    assertTrue(this.moeBill.getItems().isEmpty());
  }
  
  @Test
  public void testGetItemsAddingOneItem() {
    BillItem item = new BillItem("Peach Rings", 2.99);
    this.moeBill.addItem(item);
    assertEquals(1, this.moeBill.getItems().size());
  }
  
  @Test
  public void testGetItemsAddingMultipleItems() {
    BillItem item1 = new BillItem("Peach Rings", 2.99);
    BillItem item2 = new BillItem("Gummy Bears", 3.49);
    
    this.moeBill.addItem(item1);
    this.moeBill.addItem(item2);
    
    assertEquals(2, this.moeBill.getItems().size());
    assertEquals(item1, this.moeBill.getItems().get(0));
    assertEquals(item2, this.moeBill.getItems().get(1));
  }

}
