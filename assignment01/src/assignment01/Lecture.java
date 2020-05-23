package assignment01;

public class Lecture {
	private String day;
	private int time;
	private String lectureName;
	private String professor;
	private String roomNumber;
	private int Enrolled;
	private int maxEnrolled;
	
	
	public Lecture()
	{
		this.lectureName	= "----";
		this.professor   	= "None";
		this.roomNumber  	= "None";

	}
	
	public Lecture(String day, int time, String lectureName, String professor, String roomNumber, int maxEnrolled)
	{
		this.day         	= day;
		this.time        	= time;
		this.lectureName	= lectureName;
		this.professor   	= professor;
		this.roomNumber		= roomNumber;
		this.maxEnrolled	= maxEnrolled;
		this.Enrolled		= 0;
	}
	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getLectureName() {
		return this.lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getProfessor() {
		return this.professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public int getMaxEnrolled() {
		return this.maxEnrolled;
	}
	
	public void setMaxEnrolled(int maxEnrolled) {
		this.maxEnrolled = maxEnrolled;
	}
	public int getEnrolled() {
		return Enrolled;
	}
	public void incEnrolled() {
		this.Enrolled++;
	}
	public void decEnrolled() {
		this.Enrolled--;
	}
	
	public boolean equals(Lecture s) {
		return this.lectureName.equals(s.lectureName)
				&&this.professor.equals(s.professor)
				&&this.roomNumber.equals(s.roomNumber);
	}

	public boolean checkLecture() {
		return this.lectureName.equals("----");
	}
}