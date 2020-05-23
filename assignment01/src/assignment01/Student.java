package assignment01;

import java.util.Calendar;
import java.util.Scanner;

public class Student {
	private String studentName;
	private int studentCode;
	Lecture timeTable[][] = new Lecture[10][5];

	public enum DAYS {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
	}

	public Student() {
		for (int i=0; i<10; i++){
			for (int j=0; j<5; j++){
				this.timeTable[i][j] =  new Lecture();
			}
		}
	}

	public Student(String studentName, int studentCode) {
		this.studentName = studentName;
		this.studentCode = studentCode;

		for (int i=0; i<10; i++){
			for (int j=0; j<5; j++){
				this.timeTable[i][j] =  new Lecture();
			}
		}
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentCode() {
		return this.studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	public void setScheduleInformation(Lecture lecture) {
		int time = lecture.getTime()-1;
		int day = DAYS.valueOf(lecture.getDay()).ordinal();
		if (lecture.getMaxEnrolled() == lecture.getEnrolled()){
			System.out.println("강의를 추가할 수 없습니다. - 최대 수강 인원 초과.");
			return;
		}
		if (!this.timeTable[time][day].checkLecture()) {
			System.out.println("강의를 추가할 수 없습니다. - 시간표 겹침.");
			return;
		}
		this.timeTable[time][day] = lecture;
		lecture.incEnrolled();
		System.out.println("정상으로 시간이 추가되었습니다.");
	}
	public String showTimetable() {

		String s = "  ";
		for (DAYS days : DAYS.values()){
			s += String.format("%16s",days);
		}
		s += "\n";
		for (int i=0; i<10; i++){
			s += String.format("%2d", i+1);
			for (int j=0; j<5; j++) {
				s += String.format("%16s", this.timeTable[i][j].getLectureName());
			}
			s += "\n";
		}
		return s;
	}

	public boolean equals(Student stu) {
		boolean a = true;
		for (int j=0; j<5; j++){
			for (int i=0; i <10; i++){
				a &= this.timeTable[i][j].equals(stu.timeTable[i][j]);
			}
		}
		return a;
	}
	
	public void deleteSchedule(String day, int period)
	{
		period--;
		int date = DAYS.valueOf(day).ordinal();
		if (this.timeTable[period][date].checkLecture()) {
			System.out.println("지울 스케줄이 없습니다.");
			return;
		}
		this.timeTable[period][date].decEnrolled();
		this.timeTable[period][date] = new Lecture();
	}
	
	public Calendar setInputDate()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("날짜를 입력하세요(yyyyMMdd)");
		int i = keyboard.nextInt(); keyboard.nextLine();
		Calendar C = Calendar.getInstance();
		C.set(i/10000, ((i/100)%100) -1, i%100);
		return C;
	}
	
	public String oneDaySchedule(String day) {
		int date = DAYS.valueOf(day).ordinal();
		String S ="";
		S += new String(day) + "\n";

		for (int i=0; i < 10; i++){
			S += (this.timeTable[i][date].getLectureName() + "\n");
		}
		return S;
	}
}
