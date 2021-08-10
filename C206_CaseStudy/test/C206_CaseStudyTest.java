import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Student s1;
	private Student s2;
	
	private ArrayList<Student> studentList;

	@Before
	public void setUp() throws Exception {
		s1 = new Student(20123456, "Xiao Ming", "P4", "W64A", "Desmond Lee", "20123456@myrp.edu.sg", 98765432);
		s2 = new Student(20234567, "Xiao Hua", "P4", "W64A", "Desmond Lee", "202345676@myrp.edu.sg", 87654321);
		
		studentList = new ArrayList<Student>();
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void addStudentTest() { 
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Student arraylist to add to", studentList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addStudent(studentList, s1);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());
		assertSame("Check that Student is added", s1, studentList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addStudent(studentList, s2);
		assertEquals("Check that Student arraylist size is 2", 2, studentList.size());
		assertSame("Check that Student is added", s2, studentList.get(1));
	}

	@Test
	public void retrieveAllStudentTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", studentList);
		
		//test if the list of students retrieved from the CaseStudy is empty - boundary
		String allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allStudent);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addStudent(studentList, s1);
		C206_CaseStudy.addStudent(studentList, s2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, studentList.size());
		
		//test if the expected output string same as the list of students retrieved from the CaseStudy	
		allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		testOutput = String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d\n", 
				20123456, "Xiao Ming", "P4", "W64A", "Desmond Lee", "20123456@myrp.edu.sg", 98765432);
		testOutput += String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d\n",
				20234567, "Xiao Hua", "P4", "W64A", "Desmond Lee", "202345676@myrp.edu.sg", 87654321);
	
		assertEquals("Test that ViewAllStudentlist", testOutput, allStudent); 
	}

	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		
		studentList = null;
	}
}
