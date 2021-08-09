
public class Parent {

	private int StudentID;
	private String StudentName;
	private String Grade;
	private String Classroom;
	private String Teacher;
	private String ParentName;
	private String ParentEmail;
	private int ParentNum;
	
	public Parent(int studentID, String studentName, String grade, String classroom, String teacher, String parentName,
			String parentEmail, int parentNum) {
		super();
		StudentID = studentID;
		StudentName = studentName;
		Grade = grade;
		Classroom = classroom;
		Teacher = teacher;
		ParentName = parentName;
		ParentEmail = parentEmail;
		ParentNum = parentNum;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	public String getClassroom() {
		return Classroom;
	}

	public void setClassroom(String classroom) {
		Classroom = classroom;
	}

	public String getTeacher() {
		return Teacher;
	}

	public void setTeacher(String teacher) {
		Teacher = teacher;
	}

	public String getParentName() {
		return ParentName;
	}

	public void setParentName(String parentName) {
		ParentName = parentName;
	}

	public String getParentEmail() {
		return ParentEmail;
	}

	public void setParentEmail(String parentEmail) {
		ParentEmail = parentEmail;
	}

	public int getParentNum() {
		return ParentNum;
	}

	public void setParentNum(int parentNum) {
		ParentNum = parentNum;
	}
	
}
