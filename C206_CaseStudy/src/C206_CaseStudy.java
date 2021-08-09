import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Parent> parentList = new ArrayList<Parent>();
		ArrayList<CCAcategory> categoryList = new ArrayList<CCAcategory>();

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
						System.out.println("View all CCA + Category");
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
						System.out.println("Add CCA Category");
					}
					else if (option == 5) {
						// Delete CCA Category
						System.out.println("Delete CCA Category");
					}
					else if (option == 6){
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
						System.out.println("Add parent");
					}
					else if (option == 3) {
						// Delete parent
						System.out.println("Delete parent");
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
						C206_CaseStudy.removeStudent(studentList);
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
		System.out.println("2. Parent (If sutdent grade is in P3 and under");
		System.out.println("3. Student");
		System.out.println("4. Quit");
	}
	
	public static void coordinatorMenu() {
		C206_CaseStudy.setHeader("CCA COORDINATOR");
		System.out.println("1. View all CCA and Category");
		System.out.println("2. Add CCA");
		System.out.println("3. Delete CCA");
		System.out.println("4. Add CCA Category");
		System.out.println("5. Delete CCA Category");
		System.out.println("6. Quit");
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
	private static String retrieveAllParent(ArrayList<Parent> parentList) {
		String output = "";
		
		for (int i = 0; i < parentList.size(); i++) {
			output += String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d\n", parentList.get(i).getStudentID(), 
					parentList.get(i).getStudentName(), parentList.get(i).getGrade(), parentList.get(i).getClassroom(),
					parentList.get(i).getTeacher(), parentList.get(i).getParentName(), parentList.get(i).getParentEmail(),
					parentList.get(i).getParentNum());
		}
		return output;
	}
	
	private static void viewAllParent(ArrayList<Parent> parentList) {
		C206_CaseStudy.setHeader("VIEW ALL PARENTS");
		String output = String.format("%-10d %-30s %-5s %-5s %-30s %-30s %-20s %-10d\\n", "STUDENT ID", "STUDENT NAME",
				"GRADE", "CLASS", "TEACHER NAME", "PARENT NAME", "EMAIL", "CONTACT NO");
		output += retrieveAllParent(parentList);
		System.out.println(output);
	}
	
	// ============================== STUDENT ==============================
	
	// =============== VIEW ALL STUDENT ===============
	private static String retrieveAllStudent(ArrayList<Student> studentList) {
		String output = "";
		
		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-10d %-30s %-5s %-5s %-30s %-20s %-10d\n", studentList.get(i).getStudentID(),
					studentList.get(i).getName(), studentList.get(i).getGrade(), studentList.get(i).getClassroom(),
					studentList.get(i).getTeacher(), studentList.get(i).getStudentEmail(), studentList.get(i).getContactNum());
		}
		return output;
	}

	private static void viewAllStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.setHeader("VIEW ALL STUDENTS");
		String output = String.format("%-10s %-30s %-5s %-5s %-30s %-20s %-10s\n", "STUDENT ID", "STUDENT NAME",
				"GRADE", "CLASS", "TEACHER NAME", "EMAIL", "CONTACT NO");
		output += retrieveAllStudent(studentList);
		System.out.println(output);
	}	
	
	// =============== ADD STUDENT ===============
	private static Student inputStudent() {
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
	
	private static void addStudent(ArrayList<Student> studentList, Student s) {
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
	private static void removeStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.viewAllStudent(studentList);
		
		int studentID = Helper.readInt("Enter Student ID > ");
		
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
	
}
