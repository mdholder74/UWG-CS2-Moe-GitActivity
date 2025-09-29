package edu.westga.cs1302.lab5.persistence;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVWriter;

import edu.westga.cs1302.lab5.model.Student;

/** Supports saving and loading student data,
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class StudentDataPersistenceManager {
	
	public static final String FILE_LOCATION = "data.csv";
	
	/** Save the students!
	 * 
	 * @precondition students != null
	 * @postcondition none
	 * 
	 * @param students the set of students to save
	 * @throws IllegalArgumentException if precondition is violated
	 * @throws IOException Unable to write to FILE_LOCATION
	 */
	public static void saveStudentData(Student[] students) throws IOException, IllegalArgumentException {
		if (students == null) {
			throw new IllegalArgumentException("must provide an array of students");
		}
		try (FileWriter writer = new FileWriter(StudentDataPersistenceManager.FILE_LOCATION)) {
			for (Student currStudent : students) {
				writer.write(currStudent.getName() + System.lineSeparator());
				writer.write(currStudent.getGrade() + System.lineSeparator());
			}
		}
	}
	
/** Save the students to a specified file location
   * 
   * @precondition students != null && fileLocation != null && !fileLocation.isEmpty()
   * @postcondition none
   * 
   * @param students the set of students to save
   * @param fileLocation the location to save the student data
   * 
   * @throws IllegalArgumentException if precondition is violated
   * @throws IOException Unable to write to specified file location
   */
	 public static void saveStudentData(Student[] students, String fileLocation) throws IOException, IllegalArgumentException {
	    if (students == null) {
	      throw new IllegalArgumentException("Invalid: Must provide an array of students");
	    }
	    
	    if (fileLocation == null || fileLocation.isEmpty()) {
        throw new IllegalArgumentException("Invalid: Must provide a file location");
      }
	    
	    try (CSVWriter writer = new CSVWriter(new FileWriter(fileLocation))) {
	      writer.writeNext(new String[] {"Name", "Grade"});
	      
	      for (Student currStudent : students) {
	        if(currStudent != null) {
	        String[] studentInformation = {currStudent.getName(), String.valueOf(currStudent.getGrade())
	      };
          writer.writeNext(studentInformation);
                    }
	        }
	      }
	 }

	/** Load the students!
	 * 
	 * @precondition no
	 * @postcondition none
	 * 
	 * @return the set of students loaded
	 * @throws FileNotFoundException no file exists at FILE_LOCATION
	 * @throws IOException unable to read file due to formatting issue 
	 */
	public static Student[] loadStudentData() throws FileNotFoundException, IOException {
		ArrayList<Student> students = new ArrayList<Student>();
		File inputFile = new File(StudentDataPersistenceManager.FILE_LOCATION);
		
		try (Scanner reader = new Scanner(inputFile)) {
			while (reader.hasNextLine()) {
				String name = reader.nextLine();
				if (!reader.hasNextLine()) {
					throw new IOException("missing grade for " + name);
				}
				int grade = Integer.parseInt(reader.nextLine());
				students.add(new Student(name, grade));
			}
		} catch (NumberFormatException error) {
			throw new IOException("grade value was not formatted as an integer (" + error.getMessage() + ")");
		} catch (IllegalArgumentException error) {
			throw new IOException(error.getMessage());
		}
		
		return students.toArray(new Student[0]);
	}
	
}
