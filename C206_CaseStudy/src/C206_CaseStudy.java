import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		ArrayList<CCAcategory> categoryList = new ArrayList<CCAcategory>();

		studentList.add(new Student(20123, "Xiao Ming", "P4", "W64A", "Desmond Lee", "20123@myrp.edu.sg", 98765432));
		studentList.add(new Student(20234, "Xiao Hua", "P4", "W64A", "Desmond Lee", "20234@myrp.edu.sg", 87654321));
		
		parentList.add(new Parent(21123, "Da Ming", "P3", "W65A", "Candice", "Joe", "JoeMa@gmail.com", 97538642));
		parentList.add(new Parent(21234, "Da Hua", "P3", "W65A", "Candice", "Wendy", "WendyZ@gmail.com", 98647532));
		
		categoryList.add(new CCAcategory("Sports"));
		categoryList.add(new CCAcategory("Art"));
		categoryList.add(new CCAcategory("Music"));
		categoryList.add(new CCAcategory("Food"));
		
		int role = 0;
		
		while (role != 4) {
			C206_CaseStudy.roleMenu(); // Displays role for CCA Coordinator and Parent/Student
			role = Helper.readInt("Enter role > ");
			
			if (role == 1) {
				// CCA Coordinator role
				System.out.println("CCA Coordinator role");
				C206_CaseStudy.coordinatorMenu(); //Displays options for CCA Coordinator
				int option = 0;
				
				while (option != 6) {
					
					option = Helper.readInt("Enter option > ");
					
					if (option == 1) {
						// View all CCA + Category
//						System.out.println("View all CCA + Category");
						C206_CaseStudy.viewAllCategories(categoryList);
					}
					else if (option == 2 ) {
						// Add CCA
						System.out.println("Add CCA");
					}
					else if (option == 3) {
						// Delete CCA
						System.out.println("Delete CCA");
					}
					else if (option == 4) {
						// Add CCA Category
//						System.out.println("Add CCA Category");
						CCAcategory c = inputCategory();
						C206_CaseStudy.addCategory(categoryList, c);
					}
					else if (option == 5) {
						// Delete CCA Category
//						System.out.println("Delete CCA Category");
						C206_CaseStudy.deleteCategory(categoryList);
					}
					else if (option == 6) {
						// Add parent account
					}
					else if (option == 7) {
						// View registered parents
					}
					else if (option == 8) {
						// Delete parent
					}
					else if (option == 9){
						// Quit CCA
						System.out.println("Returning to Login page...");
					}
					else {
						System.out.println("Invalid Option");
					}
				}
			}
			
			else if (role == 2) {
				// Parent role
				System.out.println("Parent");
				C206_CaseStudy.parentMenu(); // Displays menu for parents 
				
				int option = 0;
				
				while (option != 4) {
					
					option = Helper.readInt("Enter option > ");
					
					if (option == 1) {
						// View all parent
						C206_CaseStudy.viewAllParent(parentList);
					}
					else if (option == 2) {
						// Add parent
						Parent p = inputParent();
						C206_CaseStudy.addParent(parentList, p);
					}
					else if (option == 3) {
						// Delete parent
						C206_CaseStudy.removeParent(parentList);
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
			else if (role == 3) {
				// Student role
				System.out.println("Student");
				C206_CaseStudy.studentMenu(); // Displays menu for students
				
				int option = 0;
				
				while (option != 4) {
					
					option = Helper.readInt("Enter option > ");
					
					if (option == 1) {
						// View all students
						C206_CaseStudy.viewAllStudent(studentList);
					}
					else if (option == 2) {
						// Add student
						Student s = inputStudent();
						C206_CaseStudy.addStudent(studentList, s);
					}
					else if (option == 3) {
						// Delete student
						C206_CaseStudy.viewAllStudent(studentList);
						int studentID = Helper.readInt("Enter Student ID > ");
						
						C206_CaseStudy.removeStudent(studentList, studentID);
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
			else if (role == 4) {
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
		C206_CaseStudy.setHeader("ROLES");
		System.out.println("1. CCA Coordinator");
		System.out.println("2. Parent (If sutdent grade is in P3 and under)");
		System.out.println("3. Student");
		System.out.println("4. Quit");
	}
	
	public static void coordinatorMenu() {
		C206_CaseStudy.setHeader("CCA COORDINATOR");
		System.out.println("1. View all CCA and Categories");
		System.out.println("2. Add CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. Add CCA Category");
		System.out.println("5. Delete CCA Category");
		System.out.println("6. Add parent account");
		System.out.println("7. View registered parents");
		System.out.println("8. Delete parent");
		System.out.println("9. Quit");
	}
	
	public static void parentMenu() {
		C206_CaseStudy.setHeader("PARENT");
		System.out.println("1. View all student details (For parents)");
		System.out.println("2. Add student details");
		System.out.println("3. Delete student details");
		System.out.println("4. Quit");
	}
	
	public static void studentMenu() {
		C206_CaseStudy.setHeader("STUDENT");
		System.out.println("1. View all student details");
		System.out.println("2. Add student details");
		System.out.println("3. Delete student details");
		System.out.println("4. Quit");

	}

	// ============================== PARENT ==============================
	
	// =============== VIEW ALL PARENT ===============
	public static String retrieveAllParent(ArrayList<Parent> parentList) {
		String output = "";
		
		for (int i = 0; i < parentList.size(); i++) {
			output += String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d \n", parentList.get(i).getStudentID(), 
					parentList.get(i).getStudentName(), parentList.get(i).getGrade(), parentList.get(i).getClassroom(),
					parentList.get(i).getTeacher(), parentList.get(i).getParentName(), parentList.get(i).getParentEmail(),
					parentList.get(i).getParentNum());
		}
		return output;
	}
	
	public static void viewAllParent(ArrayList<Parent> parentList) {
		C206_CaseStudy.setHeader("VIEW ALL PARENTS");
		String output = String.format("%-10s %-30s %-5s %-5s %-30s %-30s %-20s %-10s \n", "STUDENT ID", "STUDENT NAME",
				"GRADE", "CLASS", "TEACHER NAME", "PARENT NAME", "EMAIL", "CONTACT NO");
		output += retrieveAllParent(parentList);
		System.out.println(output);
	}
	
	// =============== ADD PARENT ===============
	public static Parent inputParent() {
		int studentID = Helper.readInt("Enter Student ID > ");
		String studentName = Helper.readString("Enter Student Name > ");
		String grade = Helper.readString("Enter Grade (P1/P2/P3) > ");
		String classroom = Helper.readString("Enter classroom > ");
		String teachName = Helper.readString("Enter Teacher's Name > ");
		String parentName = Helper.readString("Enter Parent'S Name > ");
		String email = Helper.readString("Enter Parent Email > ");
		int contactNum = Helper.readInt("Enter Contact Number > ");
		
		Parent p = new Parent(studentID, studentName, grade, classroom, teachName, parentName, email, contactNum);
		return p;
	}
	
	public static void addParent(ArrayList<Parent> parentList, Parent p) {
		parentList.add(p);
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getGrade().equals("P1")||
					parentList.get(i).getGrade().equals("P2")||
					parentList.get(i).getGrade().equals("P3")) {
				System.out.println("Student added!");
			}
			else {
				parentList.remove(i);
				System.out.println("Invalid grade!");
			}

		}
		
	}
	
	// =============== DELETE PARENT ===============
	public static void removeParent(ArrayList<Parent> parentList) {
		C206_CaseStudy.viewAllParent(parentList);
		
		int studentID = Helper.readInt("Enter Student ID > ");
		
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getStudentID() == studentID) {
				System.out.println("Student removed!");
				parentList.remove(i);
			}
			else {
				System.out.println("Invalid ID!");
			}
		}
		
	}

	
	// ============================== STUDENT ==============================
	
	// =============== VIEW ALL STUDENT ===============
	public static String retrieveAllStudent(ArrayList<Student> studentList) {
		String output = "";
		
		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-10d %-30s %-5s %-5s %-30s %-20s %-10d\n", studentList.get(i).getStudentID(),
					studentList.get(i).getName(), studentList.get(i).getGrade(), studentList.get(i).getClassroom(),
					studentList.get(i).getTeacher(), studentList.get(i).getStudentEmail(), studentList.get(i).getContactNum());
		}
		return output;
	}

	public static void viewAllStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.setHeader("VIEW ALL STUDENTS");
		String output = String.format("%-10s %-30s %-5s %-5s %-30s %-20s %-10s\n", "STUDENT ID", "STUDENT NAME",
				"GRADE", "CLASS", "TEACHER NAME", "EMAIL", "CONTACT NO");
		output += retrieveAllStudent(studentList);
		System.out.println(output);
	}	
	
	// =============== ADD STUDENT ===============
	public static Student inputStudent() {
		int studentID = Helper.readInt("Enter Student ID > ");
		String studentName = Helper.readString("Enter Student Name > ");
		String grade = Helper.readString("Enter Grade (P4/P5/P6) > ");
		String classroom = Helper.readString("Enter classroom > ");
		String teachName = Helper.readString("Enter Teacher's Name > ");
		String email = Helper.readString("Enter Student Email ({studentID}@myrp.edu.sg) > ");
		int contactNum = Helper.readInt("Enter Contact Number > ");
		
		Student s = new Student(studentID, studentName, grade, classroom, teachName, email, contactNum);
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
	// ============================== CCA  ==============================
	public static void viewAllCCA(ArrayList<CCA> ccaList) {
		C206_CaseStudy.setHeader("VIEW ALL CCA");
		String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s", "Title", "Description", "Size", "Day","Time", "Venue", "Name of instructor");
		for (CCA e : ccaList) {
			output += String.format("%-10s %-10s %-10d %-10s %-10s %-10s %-10s", e.getTitle(),e.getDescription(),e.getSize(),e.getDayOfW(),e.getTime(),e.getVenue(),e.getInstructorName());
		}
		System.out.println(output);
	}
	
	// =============== ADD CCA ===============
	public static void addCCA(ArrayList<CCA> ccaList) {
		String title = Helper.readString("Enter CCA name: ");
		String description = Helper.readString("Enter Description: ");
		int size = Helper.readInt("Enter size: ");
		String day = Helper.readString("Enter day of week: ");
		String time = Helper.readString("Enter time: ");
		String venue = Helper.readString("Enter venue: ");
		String nameOfInst = Helper.readString("Enter Name of Instructor: ");
		
		ccaList.add(new CCA(title,description,size,day,time,venue,nameOfInst));
		System.out.println("CCA aaded!");
	}
	
	// =============== DELETE CCA ===============
	public static void deleteCCA(ArrayList<CCA> ccaList) {
		String cca = Helper.readString("Enter CCA > ");
		for (CCA e : ccaList) {
			if (e.getTitle() == cca) {
				ccaList.remove(e);
				System.out.println("CCA deleted");
			} else {
				System.out.println("There is no such category");
			}
		}
	}
	// ============================== CCA CATEGORY ==============================

	// =============== VIEW ALL CATEGORIES ===============
	public static String retrieveAllCategories(ArrayList<CCAcategory> categoryList) {
		String output = "";
		for (int i = 0; i < categoryList.size(); i++) {
			output += String.format("%-8s", categoryList.get(i).getCategory());
		}
		return output;
	}
	public static void viewAllCategories(ArrayList<CCAcategory> categoryList) {
		C206_CaseStudy.setHeader("VIEW ALL CATEGORIES");
		String output = String.format("%-8s", "CATEGORIES: ");
		output += retrieveAllCategories(categoryList);
		System.out.println(output);
	}
	
	// =============== ADD CATEGORY ===============
	public static CCAcategory inputCategory() {
		String category = Helper.readString("Enter category to add > ");
		CCAcategory c = new CCAcategory(category);
		return c;
	}
	public static void addCategory(ArrayList<CCAcategory> categoryList, CCAcategory c) {
		categoryList.add(c);
		System.out.println("Category added");
	}
	
	// =============== DELETE CATEGORY ===============
	public static void deleteCategory(ArrayList<CCAcategory> categoryList) {
		C206_CaseStudy.viewAllCategories(categoryList);
		String category = Helper.readString("Enter category to delete > ");
		for (int i = 0; i < categoryList.size(); i++) {
			if (categoryList.get(i).getCategory().equals(category)) {
				categoryList.remove(i);
				System.out.println("Category '" + category + "' deleted");
			} else {
				System.out.println("There is no such category");
			}
		}
	}
}
