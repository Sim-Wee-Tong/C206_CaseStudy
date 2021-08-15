import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
	
			ArrayList<Student> studentList = new ArrayList<Student>();
			ArrayList<Parent> parentList = new ArrayList<Parent>();
			ArrayList<CCA> ccaList = new ArrayList<CCA>();
			ArrayList<CCAcategory> categoryList = new ArrayList<CCAcategory>();
			
	        ArrayList<ArrayList> SportsList = new ArrayList<ArrayList>();
	        ArrayList<ArrayList> ArtList = new ArrayList<ArrayList>();
	        ArrayList<ArrayList> MusicList = new ArrayList<ArrayList>();
	        ArrayList<ArrayList> FoodList = new ArrayList<ArrayList>();
	        
	        ArrayList<Student> SoccerList = new ArrayList<Student>();
	        ArrayList<Student> SoccerPendingList = new ArrayList<Student>();
	
			studentList.add(new Student(20123, "Xiao Ming", "P4", "W64A", "Desmond Lee", "20123@myrp.edu.sg", 98765432, null, 0));
			studentList.add(new Student(20234, "Xiao Hua", "P4", "W64A", "Desmond Lee", "20234@myrp.edu.sg", 87654321, null, 0));
			studentList.add(new Student(21123, "Da Ming", "P3", "W65A", "Candice", "Joe", "JoeMa@gmail.com", 97538642, null, 0));
			studentList.add(new Student(21234, "Da Hua", "P3", "W65A", "Candice", "Wendy", "WendyZ@gmail.com", 98647532, null, 0));
			
			SoccerList.add(new Student(20123, "Xiao Ming", "P4", "W64A", "Desmond Lee", "20123@myrp.edu.sg", 98765432, "Soccer",1));
			SoccerList.add(new Student(20234, "Xiao Hua", "P4", "W64A", "Desmond Lee", "20234@myrp.edu.sg", 87654321, "Soccer",1));
			
			ccaList.add(new CCA(1, "Soccer", "Kicking ball around", 0, "Wednesday", "3:00pm-4:00pm","School field","Mr Severus Tay"));
			ccaList.add(new CCA(2, "Bakery", "baking", 0, "Tuesday", "3:00pm-4:00pm","BLK D 03-22","Ms Serious Tay"));
			
			categoryList.add(new CCAcategory("Sports", 1));
			categoryList.add(new CCAcategory("Art", 2));
			categoryList.add(new CCAcategory("Music", 3));
			categoryList.add(new CCAcategory("Food", 4));
			
			int role = 0;
			
			while (role != 3) {
				C206_CaseStudy.roleMenu(); // Displays role for CCA Coordinator and Parent/Student
				role = Helper.readInt("Enter role > ");
				
				if (role == 1) {
					// CCA Coordinator role
					System.out.println("CCA Coordinator role");
					C206_CaseStudy.coordinatorMenu(); //Displays options for CCA Coordinator
					int option = 0;
					
					while (option != 10) {
						
						option = Helper.readInt("Enter option > ");
						
						if (option == 1) {
							C206_CaseStudy.retrieveAllCCA(ccaList);
	//						System.out.println("View all CCA + Category");
							C206_CaseStudy.viewAllCategories(categoryList);
						}
						else if (option == 2 ) {
							// Add CCA
							CCA c = inputCCA();
							C206_CaseStudy.addCCA(ccaList, c);
							
						}
						else if (option == 3) {
							// Delete CCA
							C206_CaseStudy.deleteCCA(ccaList);
						}
						else if (option == 4) {
							// Add CCA Category
							CCAcategory c = inputCategory();
							C206_CaseStudy.addCategory(categoryList, c);
						}
						else if (option == 5) {
							// Delete CCA Category
							C206_CaseStudy.deleteCategory(categoryList);
						}
						else if (option == 6) {
							// Add student to CCA
							viewAllStudent(studentList);
							addStudentCCA(SoccerPendingList,SoccerList);
						}
						else if (option == 7) {
							// View registered students
							 viewStudentSoccer(SoccerList );
						}
						else if (option == 8) {
							// Delete student
						        removeStudentCCA(SoccerList);

						}
						else if (option == 9){
							// Edit Parent detail
							updateParentDetail(studentList);
							// Quit CCA
							System.out.println("Returning to Login page...");
						}
						else if (option == 10){
							// Quit CCA
							System.out.println("Returning to Login page...");
							
						}
						else {
							System.out.println("Invalid Option");
						}
					}
				}
				
				else if (role == 2) {
					// Student role
					
					C206_CaseStudy.setHeader("STUDENT LOGIN");
					int id = Helper.readInt("Please enter your student ID > ");
					
					Boolean isStudent = checkStudentID(id, studentList);
										
					if (isStudent == true) {
						
						studentMenu();						
						int option = 0;
						
						while (option != 4) {
							
							C206_CaseStudy.retrieveStudentDetails(studentList, id);
							C206_CaseStudy.setHeader("STUDENT DETAILS");

							option = Helper.readInt("Enter option > ");
							
							if (option == 1) {
								// Update student details

								C206_CaseStudy.updateMenu();								
								updateStudentDetails(studentList);								
							}
							else if (option == 2) {
								// Join CCA	
								retrieveAllCCA(ccaList);
								
								int ccaId = Helper.readInt("Enter CCA to join > ");
								C206_CaseStudy.joinCCA(studentList, ccaList, SoccerPendingList, ccaId);
							}
							else if (option == 3) {
								// Quit CCA
								String confirm = Helper.readString("Are you sure you wish to quit your CCA? (Y/N) > ");
								if (confirm.equals("Y")||confirm.equals("y")) {
									
								}
								
							}
							else if (option == 4) {
								// Quit
								System.out.println("Returning to selection page...");
							}
							else {
								System.out.println("Invalid Option!");
							}
						}
	
					}
					
				}
				else if (role == 3) {
					System.out.println("Thank you for using CCA Registration System!");
				}
				else {
					System.out.println("Invalid role!");
				}
	
			}
		}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void roleMenu() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("CCA REGISTRATION SYSTEM");
		System.out.println("1. CCA Coordinator");
		System.out.println("2. Students");
		System.out.println("3. Quit");
	}
	
	public static void coordinatorMenu() {
		C206_CaseStudy.setHeader("CCA COORDINATOR");
		System.out.println("1. View all CCA and Categories");
		System.out.println("2. Add CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. Add CCA Category");
		System.out.println("5. Delete CCA Category");
		System.out.println("6. Add Student in a CCA");
		System.out.println("7. View registered students");
		System.out.println("8. Delete parent");
		System.out.println("9. Quit");
	}
	
	public static void studentMenu() {
		C206_CaseStudy.setHeader("STUDENT");
		System.out.println("1. Update student details");
		System.out.println("2. Join a CCA");
		System.out.println("3. Leave a CCA");
		System.out.println("4. Quit");

	}
	
	public static void updateMenu() {
		C206_CaseStudy.setHeader("UPDATE STUDENT DETAILS");
		System.out.println("DETAILS THAT CANNOT BE CHANGED: Grade, Student ID, Student Email, Classroom, Teacher's Name, CCA, CCA ID");
		
		System.out.println("1. Student Name");
		System.out.println("2. Contact Number");
		System.out.println("--- If Grade P3 and younger ---");
		System.out.println("3. Parent Name");
		System.out.println("4. Parent Email");
		System.out.println("5. Quit");
	}
	

	// ============================== STUDENT/PARENT ==============================
	
	// =============== VIEW ALL STUDENT ===============
	public static String retrieveAllStudent(ArrayList<Student> studentList) {
		String output = "";
		
		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-10d %-30s %-5s %-5s %-30s %-20s %-10d %-15s %-5d\n", studentList.get(i).getStudentID(),
					studentList.get(i).getName(), studentList.get(i).getGrade(), studentList.get(i).getClassroom(),
					studentList.get(i).getTeacher(), studentList.get(i).getStudentEmail(), studentList.get(i).getContactNum(),
					studentList.get(i).getCCA(), studentList.get(i).getCCAID());
		}
		return output;
	}

	public static void viewAllStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.setHeader("VIEW ALL STUDENTS");
		String output = String.format("%-10s %-30s %-5s %-5s %-30s %-20s %-10s %-15s %-5s\n", "STUDENT ID", "STUDENT NAME",
				"GRADE", "CLASS", "TEACHER NAME", "EMAIL", "CONTACT NO", "CCA", "CCAID");
		output += retrieveAllStudent(studentList);
		System.out.println(output);
	}
	
	// =============== VIEW STUDENT DETAILS ================
	
	public static String retrieveStudentDetails(ArrayList<Student> studentList, int studentId) {
		String output = "";
		
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentID() == studentId && 
					(studentList.get(i).getGrade().equals("P4")||studentList.get(i).getGrade().equals("P5")||
							studentList.get(i).getGrade().equals("P6"))) {
				output += String.format("%-10s %-30s %-5s %-5s %-30s %-20s %-10s %-15s %-5s\n", "STUDENT ID", "STUDENT NAME",
						"GRADE", "CLASS", "TEACHER NAME", "EMAIL", "CONTACT NO", "CCA", "CCAID");
				output += String.format("%-10d %-30s %-5s %-5s %-30s %-20s %-10d %-15s %-5d\n", studentList.get(i).getStudentID(),
						studentList.get(i).getName(), studentList.get(i).getGrade(), studentList.get(i).getClassroom(),
						studentList.get(i).getTeacher(), studentList.get(i).getStudentEmail(), studentList.get(i).getContactNum(),
						studentList.get(i).getCCA(), studentList.get(i).getCCAID());
			}
			else if (studentList.get(i).getStudentID() == studentId && 
					(studentList.get(i).getGrade().equals("P1")||studentList.get(i).getGrade().equals("P2")||
							studentList.get(i).getGrade().equals("P3"))) {
				output += String.format("%-10s %-30s %-5s %-5s %-30s %-30s %-20s %-10s %-15s %-5s\n", "STUDENT ID", "STUDENT NAME",
						"GRADE", "CLASS", "TEACHER NAME", "PARENT NAME", "EMAIL", "CONTACT NO", "CCA", "CCAID");
				output += String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d %-15s %-5d\n", studentList.get(i).getStudentID(),
						studentList.get(i).getName(), studentList.get(i).getGrade(), studentList.get(i).getClassroom(),
						studentList.get(i).getTeacher(), studentList.get(i).getParentName(), studentList.get(i).getStudentEmail(), 
						studentList.get(i).getContactNum(),studentList.get(i).getCCA(), studentList.get(i).getCCAID());
			}
		}
		System.out.println(output);
		return output;
	}
	
	// =============== ADD STUDENT ===============
	public static Student inputStudent(ArrayList<Student> studentList) {
		int studentID = Helper.readInt("Enter Student ID > ");
		String studentName = Helper.readString("Enter Student Name > ");
		String grade = Helper.readString("Enter Grade (P4/P5/P6) > ");
		String classroom = Helper.readString("Enter classroom > ");
		String teachName = Helper.readString("Enter Teacher's Name > ");
		String email = Helper.readString("Enter Student Email ({studentID}@myrp.edu.sg) > ");
		int contactNum = Helper.readInt("Enter Contact Number > ");
		String cca = Helper.readString("Enter CCA (If not in a CCA, put 'null')> ");
		
		Student s = new Student(studentID, studentName, grade, classroom, teachName, email, contactNum, cca,studentList.size());
		return s;
	}
	
	public static void addStudent(ArrayList<Student> studentList, Student s) {
		studentList.add(s);
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getGrade().equals("P4")||
					studentList.get(i).getGrade().equals("P5")||
					studentList.get(i).getGrade().equals("P6")) {
				System.out.println("Student added!");
			}
			else {
				studentList.remove(i);
				System.out.println("Invalid grade!");
			}

		}
		
	}

	// =============== DELETE STUDENT ===============
	public static void removeStudent(ArrayList<Student> studentList, int studentID) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentID() == studentID) {
				System.out.println("Student removed!");
				studentList.remove(i);
			}
			else {
				System.out.println("Invalid ID!");
			}
		}
		
	}
	
	// =============== UPDATE STUDENT DETAILS ===============	
	public static void updateStudentDetails(ArrayList<Student> studentList) {
		int update = Helper.readInt("What detail would you like to edit? > ");
		
		if (update == 1) {
			// Change Student Name
			String newSName = Helper.readString("Enter new Student Name > ");
			int ID = Helper.readInt("Please verify Student ID > ");
			
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getStudentID() == ID) {
					studentList.get(i).setName(newSName);
					System.out.println("Name successfully updated!");				
				}
				else {
					System.out.println("Invalid student ID!");
				}
			}
			
		}
		else if (update == 2) {
			// Change Contact Number
			int newContact = Helper.readInt("Enter new Contact Number > ");
			int ID = Helper.readInt("Please verify Student ID > ");
			
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getStudentID() == ID) {
					studentList.get(i).setContactNum(newContact);
					System.out.println("Contact Number successfully updated!");				
				}
				else {
					System.out.println("Invalid student ID!");
				}
			}
		}
		else if (update == 3) {
			// Change Parent's Name
			String newPName = Helper.readString("Enter new Parent Name > ");
			int ID = Helper.readInt("Please verify Student ID > ");
			String grade = Helper.readString("Please verify student Grade (Must be P3 and below) > ");
			
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getStudentID() == ID && studentList.get(i).getGrade().equals(grade)) {
					studentList.get(i).setParentName(newPName);
					System.out.println("Name successfully updated!");				
				}
				else if (studentList.get(i).getStudentID() == ID && !studentList.get(i).getGrade().equals(grade)) {
					System.out.println("Invalid Grade!");
					System.out.println("There is no need to change Parent Name!");
				}
				else {
					System.out.println("Invalid ID!");
				}
			}
			
		}
		else if (update == 4) {
			// Change Parent's Email
			String newEmail = Helper.readString("Enter new Parent Email > ");
			int ID = Helper.readInt("Please verify Student ID > ");
			String grade = Helper.readString("Please verify student Grade (Must be P3 and below) > ");
			
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getStudentID() == ID && studentList.get(i).getGrade().equals(grade)) {
					studentList.get(i).setParentEmail(newEmail);;
					System.out.println("Email successfully updated!");				
				}
				else if (studentList.get(i).getStudentID() == ID && !studentList.get(i).getGrade().equals(grade)) {
					System.out.println("Invalid Grade!");
					System.out.println("There is no need to change Parent Email!");
				}
				else {
					System.out.println("Invalid ID!");
				}
			}
		}
		else if (update == 5) {
			System.out.println("Returning to Student Detail's page...");
		}
		else {
			System.out.println("Invalid detail!");
		}
	}
	
	
// ============================== CCA  ==============================
	public static String retrieveAllCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.setHeader("VIEW ALL CCA");
		String output = String.format("%-5s %-10s %-20s %-5s %-15s %-17s %-13s %-10s", "CCAID", "Title", "Description", "Size", "Day","Time", "Venue", "Name of instructor\n");
		for (CCA e : ccaList) {
			output += String.format("%-5d %-10s %-20s %-5d %-15s %-17s %-15s %-10s \n", e.getCCAID(), e.getTitle(),e.getDescription(),e.getSize(),e.getDayOfW(),e.getTime(),e.getVenue(),e.getInstructorName());
		}
		System.out.println(output);
		return output;
	}
	
	// =============== STUDENT JOIN CCA ===============
	public static void joinCCA(ArrayList<Student> studentList, ArrayList<CCA> ccaList, ArrayList<Student> soccerPendingList, int ccaId) {
		for (int i = 0; i < ccaList.size(); i++) {
			if (ccaList.get(i).getCCAID() == ccaId) {
				
				ArrayList<Student> s = studentList;
				
				if (studentList.get(i).getGrade().equals("P4")||studentList.get(i).getGrade().equals("P5")
						||studentList.get(i).getGrade().equals("P6")) {
					
					soccerPendingList.add(new Student(s.get(i).getStudentID(), s.get(i).getName(), s.get(i).getGrade(),
							s.get(i).getClassroom(), s.get(i).getTeacher(), s.get(i).getStudentEmail(), s.get(i).getContactNum(),
							s.get(i).getCCA(), s.get(i).getCCAID()));
					
					s.get(i).setCCA("Soccer");
					s.get(i).setCCAID(1);
					
					System.out.println("Registration successful!");
					System.out.println("Please wait for the confirmation email in your Inbox!");
				}
				else if (studentList.get(i).getGrade().equals("P1")||studentList.get(i).getGrade().equals("P2")
						||studentList.get(i).getGrade().equals("P3")) {
					
					soccerPendingList.add(new Student(s.get(i).getStudentID(), s.get(i).getName(), s.get(i).getGrade(),
							s.get(i).getClassroom(), s.get(i).getTeacher(), s.get(i).getParentName(), s.get(i).getParentEmail(), s.get(i).getContactNum(),
							s.get(i).getCCA(), s.get(i).getCCAID()));
					
					s.get(i).setCCA("Soccer");
					s.get(i).setCCAID(1);
					
					System.out.println("Registration successful!");
					System.out.println("Please wait for the confirmation email in your Inbox!");
				}
			}
			else {
				System.out.println("CCA does not exist!");
			}
		}
	}
		public static void updateParentDetail(ArrayList<Student> studentList) {
		int id = Helper.readInt("Please enter student ID");

	    //loop for reg list
	    if(studentList.size()>0) {
	      for (int i = 0; i < studentList.size(); i++) {
	        if(studentList.get(i).getStudentID() == id) {
	          String newstudentname = Helper.readString("Enter New Student Name to update > ");
	          String newgrade = Helper.readString("Enter New Grade to update > ");
	          String newteacher = Helper.readString("Enter New Teacher to update > ");
	          String newparentname = Helper.readString("Enter New Parent Name to update > ");
	          String newparentemail = Helper.readString("Enter New Parent Email to update > ");

	          studentList.get(i).setName(newstudentname);
	          studentList.get(i).setGrade(newgrade);
	          studentList.get(i).setTeacher(newteacher);
	          studentList.get(i).setParentName(newparentname);
	          studentList.get(i).setParentEmail(newparentemail);
	          System.out.println("Parent Updated");

	          break;

	        }
	        else {
	          System.out.println("INVALID ID PROVIDED");
	          break;
	        }
	      }

	    }
	    else {
	      System.out.println("No student registered\n");

	    }
	}
	
	// =============== ADD CCA ===============
	public static CCA inputCCA() {
		int id = Helper.readInt("Enter CCA ID: ");
		String title = Helper.readString("Enter CCA name: ");
		String description = Helper.readString("Enter Description: ");
		int size = Helper.readInt("Enter size: ");
		String day = Helper.readString("Enter day of week: ");
		String time = Helper.readString("Enter time: ");
		String venue = Helper.readString("Enter venue: ");
		String nameOfInst = Helper.readString("Enter Name of Instructor: ");
		
		CCA c = new CCA(id, title, description, size, day, time,venue,nameOfInst);
		return c;
	}
	public static void addCCA(ArrayList<CCA> ccaList, CCA c) {
		
		ccaList.add(c);
		System.out.println("CCA added");
	}
	
	
	// =============== DELETE CCA ===============
	public static boolean doDeleteCCA(ArrayList<CCA> ccaList, int ccaID) {
		Boolean isDeleted = false;
		for (int i = 0; i < ccaList.size(); i++) {
			int ccaid = ccaList.get(i).getCCAID();
			if (ccaid == ccaID) {
				ccaList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}
	public static void deleteCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.retrieveAllCCA(ccaList);
		int ccaID = Helper.readInt("Enter CCA ID to delete > ");
		Boolean isDeleted = doDeleteCCA(ccaList, ccaID);
		if (isDeleted == false) {
			System.out.println("There is no such CCA");
		} else {
			System.out.println("CCA deleted" );
		}
	}	// =============== DELETE Student from CCA ===============
	public static void removeStudentCCA( ArrayList<Student> soccerList) {
		int input = Helper.readInt("Please enter the student ID");
		for (int i = 0; i < soccerList.size(); i++) {
			
				
				
				if (soccerList.get(i).getStudentID() == input) {
					
					soccerList.remove(i);
				
				
					System.out.println("Deletion of student "+ input +" is successful!");

				}
				
			else {
				System.out.println("Student does not exist in the CCA!");
			
		}
	}
	}
	// ============================== CCA CATEGORY ==============================

	// =============== VIEW ALL CATEGORIES ===============
	public static String retrieveAllCategories(ArrayList<CCAcategory> categoryList) {
		String output = "";
		for (int i = 0; i < categoryList.size(); i++) {
			output += String.format("%d %s\n", categoryList.get(i).getCategoryID(), categoryList.get(i).getCategoryName());
		}
		return output;
	}
	public static void viewAllCategories(ArrayList<CCAcategory> categoryList) {
		C206_CaseStudy.setHeader("VIEW ALL CATEGORIES");
		String output = String.format("%s", "");
		output += retrieveAllCategories(categoryList);
		System.out.println(output);
	}
	
	// =============== ADD CATEGORY ===============
	public static CCAcategory inputCategory() {
		int categoryId = Helper.readInt("Enter category id to add > ");
		String categoryName = Helper.readString("Enter category name to add > ");
		CCAcategory c = new CCAcategory(categoryName, categoryId);
		return c;
	}
	public static void addCategory(ArrayList<CCAcategory> categoryList, CCAcategory c) {
		categoryList.add(c);
		System.out.println("Category added");
	}
	
	// =============== DELETE CATEGORY ===============
	public static boolean doDeleteCategory(ArrayList<CCAcategory> categoryList, int categoryID) {
		Boolean isDeleted = false;
		for (int i = 0; i < categoryList.size(); i++) {
			int ccaCategoryId = categoryList.get(i).getCategoryID();
			if (categoryID == ccaCategoryId) {
				categoryList.remove(i);
				isDeleted = true;
			}
		}
		return isDeleted;
	}
	
	public static void deleteCategory(ArrayList<CCAcategory> categoryList) {
		C206_CaseStudy.viewAllCategories(categoryList);
		int categoryID = Helper.readInt("Enter category id to delete > ");
		Boolean isDeleted = doDeleteCategory(categoryList, categoryID);

		if (isDeleted == false) {
			System.out.println("There is no such category");
		} else {
			System.out.println("Category deleted");
		}
	}
	
	// ================ CHECK STUDENT ID ==============
	
	public static Boolean checkStudentID(int id, ArrayList<Student> studentList) {
		boolean isStudent = false;
		
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentID() == id) {
				isStudent = true;
			}
		}
		
		if (isStudent == false) {
			System.out.println("The student ID entered is not correct");
		}
		
		return isStudent;
		
	}
	
 //================ ADD STUDENT TO CCA ==============// this is for student to apply to a cca
    public static void setStudentCCA(ArrayList<Student> studentList, int studentID,ArrayList<Student> SoccerList,ArrayList<Student> SoccerPendingList) {
    	for (int i = 0; i < studentList.size(); i++) {
    		if (studentList.get(i).getStudentID() == studentID ) {
    			String input =Helper.readString("Which CCA do you want to join?");
    			if(input.equalsIgnoreCase("soccer") && SoccerList.size()<20 ) {
    				ArrayList<Student> a=SoccerList;
    				SoccerPendingList.add(new Student(a.get(i).getStudentID(),a.get(i).getName(),a.get(i).getGrade(),a.get(i).getClassroom(),a.get(i).getTeacher(),a.get(i).getStudentEmail(),a.get(i).getContactNum(),a.get(i).getCCA(),a.get(i).getCCAID()));
    			
    			}
    			
    		}
    	}
    }
    // this is to selected student from pending list and slot it into actual cca list
   public static void addStudentCCA(ArrayList<Student> soccerPendingList,ArrayList<Student> soccerList ) {
	   String output=String.format("%-10s\n", "Student ID");
	   boolean isAdded = false;
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
   }  
}
   
   public static void viewStudentSoccer(ArrayList<Student> soccerList ) {
    		String output = String.format("%-10s %-30s %-5s %-5s %-30s %-20s %-10s %-15s %-15s\n", "STUDENT ID", "STUDENT NAME",
    				"GRADE", "CLASS", "TEACHER NAME", "EMAIL", "CONTACT NO", "CCA", "CCA REGISTRATION ID");
    	   for(int i = 0; i<soccerList.size();i++) {
    		    output += String.format("%-10d %-30s %-5s %-5s %-30s %-20s %-10d %-15s %-15d\n", soccerList.get(i).getStudentID(),
    		    		soccerList.get(i).getName(), soccerList.get(i).getGrade(), soccerList.get(i).getClassroom(),
    		    		soccerList.get(i).getTeacher(), soccerList.get(i).getStudentEmail(), soccerList.get(i).getContactNum(),
    		    		soccerList.get(i).getCCA(),soccerList.get(i).getCCAID());				  
    		    		System.out.println(output);


    		   }
       }
	
}
