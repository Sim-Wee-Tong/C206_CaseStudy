import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Student> studList = new ArrayList<Student>();
		
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

}
