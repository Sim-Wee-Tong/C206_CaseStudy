
public class Parent {

	private int StudentID;
	private String Name;
	private String Grade;
	private String Classroom;
	private String Teacher;
	private String ParentEmail;
	private int ParentNum;
	
	public Parent(int studentID, String name, String grade, String classroom, String teacher, String parentEmail,
			int parentNum) {
		super();
		StudentID = studentID;
		Name = name;
		Grade = grade;
		Classroom = classroom;
		Teacher = teacher;
		ParentEmail = parentEmail;
		ParentNum = parentNum;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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
