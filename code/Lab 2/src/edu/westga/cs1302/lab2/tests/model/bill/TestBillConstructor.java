package edu.westga.cs1302.lab2.tests.model.bill;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;

class TestBillConstructor {

  @Test
  public void testConstructorCreatesEmptyBill() {
    Bill moeBill = new Bill();
    assertTrue(moeBill.getItems().isEmpty(), "The list of items should be empty");
  }
  
  @Test
  public void testConstructorCreatesBillNotNull() {
    Bill moeBill = new Bill();
    assertNotNull(moeBill.getItems(), "The list of items should not be null");
  }

}
