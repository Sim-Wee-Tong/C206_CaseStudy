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
	private ArrayList<Student> soccerPendingList;
	private ArrayList<Student> soccerList;
	
	private CCAcategory c1;
	private CCAcategory c2;
	private ArrayList<CCAcategory> categoryList;
	private CCA cca1;
	private CCA cca2;
	

	@Before
	public void setUp() throws Exception {
		s1 = new Student(20123, "Xiao Ming", "P4", "W64A", "Desmond Lee", "20123@myrp.edu.sg", 98765432, null,1);
		s2 = new Student(20234, "Xiao Hua", "P4", "W64A", "Desmond Lee", "20234@myrp.edu.sg", 87654321, null,2);
		cca1 = new CCA(1, "Soccer", "Kicking ball around", 0, "Wednesday", "3:00pm-4:00pm","School field","Mr Severus Tay");
		cca2 = new CCA(2, "Bakery", "baking", 0, "Tuesday", "3:00pm-4:00pm","BLK D 03-22","Ms Serious Tay");
		
		studentList = new ArrayList<Student>();
		
		c1 = new CCAcategory("Sports");
		c2 = new CCAcategory("Music");
		categoryList = new ArrayList<CCAcategory>();
		soccerPendingList = new ArrayList<Student>();
		soccerList = new ArrayList<Student>();

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
		assertEquals("Check that ViewAllCCCAlist", testOutput, allCCA);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addCCA(ccaList, cca1);
		C206_CaseStudy.addCCA(ccaList, cca2);
		assertEquals("Test that CCA arraylist size is 2", 2, ccaList.size());
		
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
		C206_CaseStudy.doDeleteCCA(ccaList, cca1.getCCAID());
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
		testOutput = String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d %-15s %-10d\n", 
				20123, "Xiao Ming", "P4", "W64A", "Desmond Lee", "20123@myrp.edu.sg", 98765432, null, 0);
		testOutput += String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d %-15s %-10d\n",
				20234, "Xiao Hua", "P4", "W64A", "Desmond Lee", "20234@myrp.edu.sg", 87654321, null, 0);
	
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
	
	@Test
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
	@Test
	public void addCategoryTest() {
		// test whether category list is not null 
		assertNotNull("test if there is a valid CCA category arraylist to add category to", categoryList);
		//Given an empty list, after adding 2 categories, the size of the list is 2.
		categoryList.add(c1);
		categoryList.add(c2);
		assertEquals("Check that categoryList size is 2", 2, categoryList.size());
	}
	@Test
	public void deleteCategoryTest() {
		// test whether category list is not null but empty
		assertNotNull("test if there is a valid CCA category arraylist to delete category from", categoryList);
		//Given an empty list, after adding 2 categories, the size of the list is 2.
		C206_CaseStudy.addCategory(categoryList, c1);
		C206_CaseStudy.addCategory(categoryList, c2);
		assertNotNull("test if there is a valid CCA category arraylist to delete category from", categoryList);
		// test that after deleting a category, size of category list is 1
		categoryList.remove(0);
		assertEquals("test that categoryList size is 1", 0, categoryList.size());
	}
	@Test
	public  void checkStudentIDTest() {
		boolean isStudent = false;
		int id =20123;
		int CCAID = 1;
		studentList.add(s1);
		studentList.add(s2);
		
	
		
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentID() == id && studentList.get(i).getCCAID()== CCAID) {
				isStudent = true;
				System.out.println("The student ID entered is correct");
			}
		}
		
		if (isStudent == false) {
			System.out.println("The student ID entered is not correct");
		}
		assertEquals("Check if both id and CCAID are both exist in the studentList",true,isStudent );
		
	}
	@Test
	  public void addStudentCCA( ) {
		   String output=String.format("%-10s\n", "Student ID");
		   boolean isAdded = false;
		   soccerPendingList.add(s1);
	   for(int i = 0; i<soccerPendingList.size();i++) {
		  output+= String.format("%-10s\n", soccerPendingList.get(i));
		   
	   }
	   System.out.println(output);
	   int input= Helper.readInt("Please select student's ID to add into your CCA");
	   for(int i = 0; i<soccerPendingList.size();i++) {
		   
			  output+= String.format("%-10s\n", soccerPendingList.get(i));
			  if(input==soccerPendingList.get(i).getStudentID()){
				  
				  ArrayList<Student> a=soccerPendingList;
				  soccerList.add(new Student(a.get(i).getStudentID(),a.get(i).getName(),a.get(i).getGrade(),a.get(i).getClassroom(),a.get(i).getTeacher(),a.get(i).getStudentEmail(),a.get(i).getContactNum(),a.get(i).getCCA(),a.get(i).getCCAID()));
				  soccerPendingList.remove(i);
				  isAdded = true;
				  System.out.println("Student Added!");
				  
			  }
		   }
	   if(isAdded == false) {
		   System.out.println("Student Not Added!");
		   assertEquals("Test that there is an existing student in the pendingList and is added to the soccerlist",true,isAdded );
	   }
	  }
	@Test
	   public void viewStudentSoccer() {
		soccerList.add(s1);
			String output = String.format("%-10s %-30s %-5s %-5s %-30s %-20s %-10s %-15s %-15s\n", "STUDENT ID", "STUDENT NAME",
					"GRADE", "CLASS", "TEACHER NAME", "EMAIL", "CONTACT NO", "CCA", "CCA REGISTRATION ID");
		   for(int i = 0; i<soccerList.size();i++) {
			    output += String.format("%-10d %-30s %-5s %-5s %-30s %-20s %-10d %-15s %-15d\n", soccerList.get(i).getStudentID(),
			    		soccerList.get(i).getName(), soccerList.get(i).getGrade(), soccerList.get(i).getClassroom(),
			    		soccerList.get(i).getTeacher(), soccerList.get(i).getStudentEmail(), soccerList.get(i).getContactNum(),
			    		soccerList.get(i).getCCA(),soccerList.get(i).getCCAID());				  
			    		System.out.println(output); 
					  
				  
			   }
		   assertEquals("Test that all soccerList size is 1",1,soccerList.size());
	   }

	@Test
	public void retrieveStudentDetailsTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve item", studentList);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addStudent(studentList, s1);
		C206_CaseStudy.addStudent(studentList, s2);
		assertEquals("Test that Student arraylist size is 2", 2, studentList.size());
		
		
		String testOutput = "";
		// Test if the expected output string same as the list of students retrieved from the CaseStudy	
		// Test if grade is P4 and above, student email will be displayed - Normal
		String allStudent = C206_CaseStudy.retrieveStudentDetails(studentList, s1.getStudentID());
		testOutput += String.format("%-10d %-30s %-5s %-5s %-30s %-20s %-10d %-15s %-10d\n", 
				s1.getStudentID(), s1.getName(), s1.getGrade(), s1.getClassroom(), s1.getTeacher(), s1.getStudentEmail(),
				s1.getContactNum(), s1.getCCA(), s1.getCCAID());
		assertEquals("Test that retrieveStudentDetails", testOutput, allStudent); 

		// Test if grade is P3 and above, parent name and email will be displayed - Normal
		String allStudent2 = C206_CaseStudy.retrieveStudentDetails(studentList, s2.getStudentID());
		testOutput += String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-30s %-20s %-10d %-15s %-10d\n", 
				s2.getStudentID(), s2.getName(), s2.getGrade(), s2.getClassroom(), s2.getTeacher(), s2.getParentName(),
				s2.getParentEmail(), s2.getContactNum(), s2.getCCA(), s2.getCCAID());
		assertEquals("Test that retrieveStudentDetails", testOutput, allStudent2); 
		
	}
	// type in 20123 for it to work
	@Test
	public  void joinCCAg() {
		 
	    soccerList.add(s1);
		int input = Helper.readInt("Please enter the student ID to remove");
		for (int i = 0; i < soccerList.size(); i++) {
			if (soccerList.get(i).getStudentID() == input) {
				
				
				if (soccerList.get(i).getStudentID() == input) {
					
					soccerList.remove(i);
				
				
				
					System.out.println("Deletion of student "+ input +" is successful!");
					

				}
				
			else {
				System.out.println("Student does not exist in the CCA!");
			}
		}
	}
	
		assertEquals("Test that student is removed", 0,soccerList.size()); 
	}
	
	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		c1 = null;
		c2 = null;
		
		studentList = null;
		categoryList = null;
	}


}
