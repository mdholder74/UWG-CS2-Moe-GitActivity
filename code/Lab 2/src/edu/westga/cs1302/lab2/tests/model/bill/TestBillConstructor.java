package edu.westga.cs1302.lab2.tests.model.bill;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;

class TestBillConstructor {

  @Test
  public void testConstructorCreatesEmptyBill() {
    Bill moeBill = new Bill();
    assertTrue("The list of items should be empty", moeBill.getItems().isEmpty());
  }
  
  @Test
  public void testConstructorCreatesBillNotNull() {
    Bill moeBill = new Bill();
    assertNotNull(moeBill.getItems(), "The list of items should not be null");
  }

}
