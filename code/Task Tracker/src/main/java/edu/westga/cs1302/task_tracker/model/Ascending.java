package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

/** This class compares tasks
 * 
 * @author Moe Holder
 * @version Fall 2025
 */
public class Ascending implements Comparator<Task> {

  /**
   * Compares two tasks based on their priority in ascending order.
   *
   * @precondition none
   * @postcondition none
   *
   * @param task1 the first task to compare
   * @param task2 the second task to compare
   * @return a negative integer, zero, or a positive integer as the first task's priority
   */
  @Override
  public int compare(Task task1, Task task2) {

      int value1;
      switch (task1.getPriority()) {
          case LOW: 
            value1 = 1; 
            break;
          case MEDIUM: 
            value1 = 2; 
            break;
          case HIGH: 
            value1 = 3; 
            break;
          default: 
            value1 = 0; 
            break;
      }
      
      int value2;
      switch (task2.getPriority()) {
          case LOW: 
            value2 = 1; 
            break;
          case MEDIUM: 
            value2 = 2; 
            break;
          case HIGH: 
            value2 = 3; 
            break;
          default: 
            value2 = 0; 
            break;
      }
      
      return value1 - value2;
  }
  
  @Override
  public String toString() {
      return "Priority: Low to High";
  }
  
}
