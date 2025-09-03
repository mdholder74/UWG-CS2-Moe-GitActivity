package edu.westga.cs1302.lab2.tests.model.bill_item;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.BillItem;

class TestBillItemConstructor {

  @Test
  public void testConstructorWithValidNameAndAmount() {
    
    BillItem item = new BillItem("Gum", 1.99);
    
    assertNotNull("Constructor should create a non-null object.", item);
    assertEquals("Gum", item.getName(), "Name should match the provided value.");
    assertEquals(1.99, item.getAmount(), 0.001, "Amount should match the provided value.");
    
  }
  
  @Test
  public void testConstructorWithNullName() {
   IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
       new BillItem(null, 1.99);
      });
   
   assertEquals("name must not be null.", exception.getMessage(),
       "Exception message should match name must not be null.");
   }
  
  @Test
  public void testConstructorWithNullAmount() {
   IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
       new BillItem("Gum", -1.99);
      });
   
   assertEquals("amount must be positive, but was -1.99", exception.getMessage(),
       "Exception message should match amount must be positive.");
   }

}
