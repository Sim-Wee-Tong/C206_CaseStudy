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
	}

	@After
	public void tearDown() throws Exception {
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
		assertEquals("Check that Camcorder arraylist size is 1", 1, studentList.size());
		assertSame("Check that Camcorder is added", s1, studentList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addStudent(studentList, s2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, studentList.size());
		assertSame("Check that Camcorder is added", s2, studentList.get(1));
	}


}
