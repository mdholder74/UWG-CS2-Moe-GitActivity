package edu.westga.cs1302.lab2.tests.model.bill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;

class TestBillConstructor {

  @Test
  public void testConstructor_CreatesEmptyBill() {
    Bill moeBill = new Bill();
    assertTrue(moeBill.getItems().isEmpty(), "The list of items should be empty");
  }
  
  @Test
  public void testConstructor_CreatesBill_NotNull() {
    Bill moeBill = new Bill();
    assertNotNull(moeBill.getItems(), "The list of items should not be null");
  }

}
