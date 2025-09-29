package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import com.opencsv.exceptions.CsvValidationException;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestLoadStudentData {

	@Test
   void testValidFile() throws IOException, CsvValidationException {
	  //Arrange
    String testFile = "test-data.csv";
    Files.writeString(Path.of(testFile), "Moe,70\nJoe,80\nRoe,90\n");
    
    //Act
    Student[] loadedStudents = StudentDataPersistenceManager.loadStudentData(testFile);
    
    //Assert
    assertEquals(3, loadedStudents.length, "checking number of students loaded");
    assertEquals("Moe", loadedStudents[0].getName(), "checking first student name");
    assertEquals(70, loadedStudents[0].getGrade(), "checking first student grade");
    assertEquals("Joe", loadedStudents[1].getName(), "checking second student name");
    assertEquals(80, loadedStudents[1].getGrade(), "checking second student grade");
    assertEquals("Roe", loadedStudents[2].getName(), "checking third student name");
    assertEquals(90, loadedStudents[2].getGrade(), "checking third student grade");
    
    new File(testFile).delete();
   }


  @Test
  void testNonExistentFile() {
    assertThrows(FileNotFoundException.class, () -> {
      StudentDataPersistenceManager.loadStudentData("non-existent-file.txt");
    });
  }
  
  
  @Test
  void testLessThanTwoLines() throws IOException, CsvValidationException {
    String testFile = "less-than-two-lines.csv";
    Files.writeString(Path.of(testFile), "Moe\n");
    
    Student[] loadedStudents = StudentDataPersistenceManager.loadStudentData(testFile);
    assertEquals(0, loadedStudents.length, "checking number of students loaded");
    new File(testFile).delete();
  }
  
  
  }
