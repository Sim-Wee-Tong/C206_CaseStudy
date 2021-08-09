import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> studList = new ArrayList<Student>();
		
		int role = 0;
		
		while (role != 3) {
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
				// Parent-Student role
				System.out.println("Parent/Student role");
				C206_CaseStudy.gradeMenu(); // Displays grade for parents (<= p3) and students (>= p4)
				int choice = 0;
				
				while (choice != 3) {
					
					choice = Helper.readInt("Enter choice (Parent/Student)? >");
					
					if (choice == 1) {
						// Parent
						System.out.println("Parent");
						
						int option = 0;
						
						while (option != 4) {
							
							if (option == 1) {
								// View all parent
							}
							else if (option == 2) {
								// Add parent
							}
							else if (option == 3) {
								// Delete parent
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
					else if (choice == 2) {
						//Student
						System.out.println("Student");
						
						int option = 0;
						
						while (option != 4) {
							
							if (option == 1) {
								// View all students
							}
							else if (option == 2) {
								// Add student
							}
							else if (option == 3) {
								// Delete student
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
					else if (choice == 3) {
						// Quit
						System.out.println("Returning to Login page...");
					}
					else {
						System.out.println("Invalid Choice");
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

	public static void roleMenu() {
		// TODO Auto-generated method stub
		
	}
	
	public static void coordinatorMenu() {
		
	}
	
	public static void gradeMenu() {
		
	}

}
