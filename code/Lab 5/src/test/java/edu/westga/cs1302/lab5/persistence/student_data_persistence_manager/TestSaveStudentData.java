package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;



class TestSaveStudentData {

	@Test
	void testNoStudents() throws IllegalArgumentException, IOException {
	  StudentDataPersistenceManager.saveStudentData(new Student[0], "test-data.txt");
	  
	  File inputFile = new File("test-data.txt");//open the file
	  try (Scanner reader = new Scanner(inputFile)) {//read the file and close it automatically
      assertFalse(reader.hasNextLine(), "checking if file is empty (shold have no lines)");//check if file is empty
    }
	 
	}
	
	@Test
	void testValidStudents() throws IllegalArgumentException, IOException, CsvValidationException {
	  //Arrange
	  Student[] students = new Student[] {
	      new Student ("Moe", 70),
	      new Student ("Joe", 80),
	      new Student ("Roe", 90)
	  };
	  String testFile = "test-data.csv";
	  
	  //Act
	  StudentDataPersistenceManager.saveStudentData(students, testFile);
	  Student[] loadedStudents = StudentDataPersistenceManager.loadStudentData(testFile);
	  
	  //Assert
	  assertEquals(3, loadedStudents.length, "checking number of students loaded");
	  assertEquals("Moe", loadedStudents[0].getName(), "checking first student name");
	  assertEquals(70, loadedStudents[0].getGrade(), "checking first student grade");
	  assertEquals("Joe", loadedStudents[1].getName(), "checking second student name");
	  assertEquals(80, loadedStudents[1].getGrade(), "checking second student grade");
	  assertEquals("Roe", loadedStudents[2].getName(), "checking third student name");
	  assertEquals(90, loadedStudents[2].getGrade(), "checking third student grade");

    }
	
	@Test
	void testNullStudents() {
	  Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      StudentDataPersistenceManager.saveStudentData(null, "test-data.txt");
    });
    assertEquals("Invalid: Must provide an array of students", exception.getMessage());
	}
	
	@Test
  void testNullFileLocation() {
	      Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      StudentDataPersistenceManager.saveStudentData(new Student[0], null);
    });
    assertEquals("Invalid: Must provide a file location", exception.getMessage());
  }


}
