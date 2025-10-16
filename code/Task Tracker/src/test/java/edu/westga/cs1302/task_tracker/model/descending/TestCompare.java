package edu.westga.cs1302.task_tracker.model.descending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Descending;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {

	@Test
	void testTheHighestPriorityComesFirst() {
	  Descending comparator = new Descending();
    Task lowPriorityTask = new Task("Low Priority Task", "descripton", TaskPriority.LOW);
    Task highPriorityTask = new Task("High Priority Task", "descripton", TaskPriority.HIGH);
    assertTrue(comparator.compare(lowPriorityTask, highPriorityTask) > 0);
  }
	
	@Test
	void testTheHighestPriorityComesbeforeMedium() {
    Descending comparator = new Descending();
    Task lowPriorityTask = new Task("Low Priority Task", "descripton", TaskPriority.LOW);
    Task mediumPriorityTask = new Task("Medium Priority Task", "descripton", TaskPriority.MEDIUM);
    assertTrue(comparator.compare(lowPriorityTask, mediumPriorityTask) > 0);
  }
	
	@Test
	void testTheMediumPriorityComesBeforeLow() {
    Descending comparator = new Descending();
    Task mediumPriorityTask = new Task("Medium Priority Task", "descripton", TaskPriority.MEDIUM);
    Task highPriorityTask = new Task("High Priority Task", "descripton", TaskPriority.HIGH);
    assertTrue(comparator.compare(mediumPriorityTask, highPriorityTask) > 0);
  }
	
	@Test
	void testSamePriorityLowIsEqual() {
    Descending comparator = new Descending();
    Task lowPriorityTask1 = new Task("Low Priority Task 1", "descripton", TaskPriority.LOW);
    Task lowPriorityTask2 = new Task("Low Priority Task 2", "descripton", TaskPriority.LOW);
    assertEquals(0, comparator.compare(lowPriorityTask1, lowPriorityTask2));
  }
	
	@Test
	  void testSamePriorityMediumIsEqual() {
 	  Descending comparator = new Descending();
    Task mediumPriorityTask1 = new Task("Medium Priority Task 1", "descripton", TaskPriority.MEDIUM);
    Task mediumPriorityTask2 = new Task("Medium Priority Task 2", "descripton", TaskPriority.MEDIUM);
    assertEquals(0, comparator.compare(mediumPriorityTask1, mediumPriorityTask2));
  }
	
	@Test
	void testSamePriorityHighIsEqual() {
    Descending comparator = new Descending();
    Task highPriorityTask1 = new Task("High Priority Task 1", "descripton", TaskPriority.HIGH);
    Task highPriorityTask2 = new Task("High Priority Task 2", "descripton", TaskPriority.HIGH);
    assertEquals(0, comparator.compare(highPriorityTask1, highPriorityTask2));
  }

}
