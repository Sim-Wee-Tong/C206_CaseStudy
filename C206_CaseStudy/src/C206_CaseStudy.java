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
			role = Helper.readInt("Enter role > ");
			
			if (role == 1) {
				// CCA Coordinator role
				System.out.println("CCA Coordinator role");
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
	public static void viewAllCCAcategories() {
		
	}
	public static void addCCA(ArrayList<CCAcategory> categoryList, CCAcategory category) {
		categoryList.add(category);
		System.out.println("Category added");
	}
}
