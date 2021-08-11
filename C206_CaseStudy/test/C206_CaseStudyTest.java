import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Student s1;
	private Student s2;
	
	private ArrayList<Student> studentList;
	private ArrayList<CCA>ccaList;
	
	private CCAcategory c1;
	private CCAcategory c2;
	private ArrayList<CCAcategory> categoryList;

	@Before
	public void setUp() throws Exception {
		s1 = new Student(20123, "Xiao Ming", "P4", "W64A", "Desmond Lee", "20123@myrp.edu.sg", 98765432, null);
		s2 = new Student(20234, "Xiao Hua", "P4", "W64A", "Desmond Lee", "20234@myrp.edu.sg", 87654321, null);
		
		studentList = new ArrayList<Student>();
		
		c1 = new CCAcategory("Sports");
		c2 = new CCAcategory("Music");
		categoryList = new ArrayList<CCAcategory>();

	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	public void addCCATest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Camcorder arraylist to add to", ccaList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addCCA(ccaList, cca1);
		assertEquals("Check that Camcorder arraylist size is 1", 1, ccaList.size());
		assertSame("Check that Camcorder is added", cca1, ccaList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, ccaList.size());
		assertSame("Check that Camcorder is added", cca2, ccaList.get(1));
	}
	@Test
	public void retrieveAllCCA() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid CCA arraylist to retrieve item", ccaList);
		
		//test if the list of cca retrieved from the casestudy is empty - boundary
		String allCCA= C206_CaseStudy.retrieveAllCCA(ccaList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCCA);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, ccaList.size());
		
		//test if the expected output string same as the list of cca retrieved from the casestudy	
		allCCA = C206_CaseStudy.retrieveAllCCA(ccaList);
		testOutput = String.format("%-10s %-30s %-10d %-10s %-20s %-10s %-10s\n","Soccer", "Kicking ball around", 0, "Wednesday", "3:00pm-4:00pm","School field","Mr Severus Tay");
		testOutput += String.format("%-10s %-30s %-10d %-10s %-20s %-10s %-10s\n","Bakery", "baking", 0, "Tuesday", "3:00pm-4:00pm","BLK D 03-22","Ms Serious Tay");
	
		assertEquals("Test that ViewAllCCAlist", testOutput, allCCA);
	}
	@Test
	public void removeCCATest() {
		// Test if item list is not null but empty - boundary
		assertNotNull("Test if there is valid CCA arraylist to retrieve item", ccaList);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Test that Student arraylist size is 2", 2, ccaList.size());
		
		// Test that after removing an item, the size of the list is 1 - normal
		C206_CaseStudy.deleteCCA(ccaList, cca1.getTitle());
		assertEquals("Test that CCA arrayList size is 1", 1, ccaList.size());
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
		assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);
		
		//test if the list of students retrieved from the CaseStudy is empty - boundary
		String allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addStudent(studentList, s1);
		C206_CaseStudy.addStudent(studentList, s2);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());
		
		//test if the expected output string same as the list of students retrieved from the CaseStudy	
		allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
		testOutput = String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d %-15s\n", 
				20123, "Xiao Ming", "P4", "W64A", "Desmond Lee", "20123@myrp.edu.sg", 98765432, null);
		testOutput += String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d %-15s\n",
				20234, "Xiao Hua", "P4", "W64A", "Desmond Lee", "20234@myrp.edu.sg", 87654321, null);
	
		assertEquals("Test that ViewAllStudentlist", testOutput, allStudent); 
	}
	
	@Test
	public void removeStudentTest() {
		// Test if item list is not null but empty - boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addStudent(studentList, s1);
		C206_CaseStudy.addStudent(studentList, s2);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());
		
		// Test that after removing an item, the size of the list is 1 - normal
		C206_CaseStudy.removeStudent(studentList, s1.getStudentID());
		assertEquals("Test that Student arrayList size is 1", 1, studentList.size());
	}

	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		
		studentList = null;
	}
	
	public void retrieveAllCategoriesTest() {
		// test whether category list is not null but empty
		assertNotNull("test if there is a valid CCA category arraylist to retrieve categories from", categoryList);
		//test if the list of categories retrieved from the CaseStudy is empty 
		String categories = C206_CaseStudy.retrieveAllCategories(categoryList);
		String output = "";
		assertEquals("Check that viewAllCategories", output, categories);
		//Given an empty list, after adding 2 categories, test that the size of the list is 2
		categoryList.add(c1);
		categoryList.add(c2);
		assertEquals("test that categoryList size is 2", 2, categoryList.size());
		//test if the expected output is same as the list of categories retrieved from the CaseStudy
		categories = C206_CaseStudy.retrieveAllCategories(categoryList);
		output = String.format("%s", "Sports");
		output += String.format("%s", "Music");
		assertEquals("test that viewAllCategories", output, categories);
	}
	public void addCategoryTest() {
		// test whether category list is not null 
		assertNotNull("test if there is a valid CCA category arraylist to add category to", categoryList);
		//Given an empty list, after adding 2 categories, the size of the list is 2.
		categoryList.add(c1);
		categoryList.add(c2);
		assertEquals("Check that categoryList size is 2", 2, categoryList.size());
	}
	public void deleteCategoryTest() {
		// test whether category list is not null but empty
		assertNotNull("test if there is a valid CCA category arraylist to delete category from", categoryList);
		//Given an empty list, after adding 2 categories, the size of the list is 2.
		C206_CaseStudy.addCategory(categoryList, c1);
		C206_CaseStudy.addCategory(categoryList, c2);
		// test that after deleting a category, size of category list is 1
		categoryList.remove(0);
	//	C206_CaseStudy.deleteCategory(categoryList);
		assertEquals("test that categoryList size is 1", 0, categoryList.size());
	}

}
