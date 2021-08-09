import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> studList = new ArrayList<Student>();
		ArrayList<CCAcategory> categoryList = new ArrayList<CCAcategory>();

		categoryList.add(new CCAcategory("Little League Soccer"));
		categoryList.add(new CCAcategory("LEGO expert"));
		categoryList.add(new CCAcategory("Dig the ground"));
		categoryList.add(new CCAcategory("Bakery"));
		categoryList.add(new CCAcategory("Jewellry making"));
		
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
<<<<<<< HEAD
	public static void viewAllCCAcategories() {
=======

	public static void roleMenu() {
		// TODO Auto-generated method stub
>>>>>>> branch 'master' of https://github.com/Sim-Wee-Tong/C206_CaseStudy.git
		
	}
<<<<<<< HEAD
	public static void addCCA(ArrayList<CCAcategory> categoryList, CCAcategory category) {
		categoryList.add(category);
		System.out.println("Category added");
	}
=======

>>>>>>> branch 'master' of https://github.com/Sim-Wee-Tong/C206_CaseStudy.git
}
