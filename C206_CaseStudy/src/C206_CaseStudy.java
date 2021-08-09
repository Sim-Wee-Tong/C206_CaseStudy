import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> studList = new ArrayList<Student>();
		
		int role = 0;
		
		while (role != 3) {
			C206_CaseStudy.roleMenu();
			role = Helper.readInt("Enter role > ");
			
			if (role == 1) {
				// CCA Coordinator role
				System.out.println("CCA Coordinator role");
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
					else {
						// Quit CCA
					}
				}
			}
			
			else if (role == 2) {
				// Parent-Student role
				System.out.println("Parent/Student role");
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

}
