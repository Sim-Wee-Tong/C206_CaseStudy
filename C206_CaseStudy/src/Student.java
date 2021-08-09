
public class Student {

	private String StudentID;
	private String Name;
	private String Grade;
	private String Classroom;
	private String Teacher;
	private String StudentEmail;
	private int ContactNum;
	
	public Student(String studentID, String name, String grade, String classroom, String teacher, String studentEmail, int contactNum) {
		super();
		StudentID = studentID;
		Name = name;
		Grade = grade;
		Classroom = classroom;
		Teacher = teacher;
		StudentEmail = studentEmail;
		ContactNum = contactNum;
	}

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
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

	public String getStudentEmail() {
		return StudentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		StudentEmail = studentEmail;
	}

	public int getContactNum() {
		return ContactNum;
	}

	public void setContactNum(int contactNum) {
		this.ContactNum = contactNum;
	}
	
}
