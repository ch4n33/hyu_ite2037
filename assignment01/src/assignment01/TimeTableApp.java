package assignment01;

import java.util.Calendar;
import java.util.Scanner;

public class TimeTableApp {

	private static Student[] students;
	private static Lecture[] l;

	private static Student findStudent(int num){
		int i=0;
		while (students[i].getStudentCode() != num){
			i++;
			if (i == students.length){
				return null;
			}
		}
		return students[i];
	}
	public static void main(String[] args) {
		Lecture lecture[] = new Lecture[10];
		lecture[0] = new Lecture("MONDAY", 1, "OOP", "mr.park", "ITBT808", 20);
		lecture[1] = new Lecture("TUESDAY", 2, "security", "mr.park", "ITBT816", 20);
		lecture[2] = new Lecture("WEDNESDAY", 1, "Datastructure", "mr.park", "ITBT808", 25);
		lecture[3] = new Lecture("THURSDAY", 6, "Network", "mr.yang", "ITBT503", 20);
		lecture[4] = new Lecture("FRIDAY", 9, "computer architecture", "mr.han", "ITBT507", 20);
		lecture[5] = new Lecture("TUESDAY", 5, "Digital logic", "mr.kim", "ITBT401", 15);
		lecture[6] = new Lecture("WEDNESDAY", 2, "OS", "mr.yoon", "ITBT606", 15);
		lecture[7] = new Lecture("THURSDAY", 3, "C-language", "mr.choi", "ITBT503", 20);
		lecture[8] = new Lecture("FRIDAY", 6, "Python", "mr.han", "ITBT504", 15);
		lecture[9] = new Lecture("TUESDAY", 9, "Ski-Board", "mr.kang", "ITBT404", 5);
		
		Scanner keyboard = new Scanner(System.in);
		String[] weeks = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
		Calendar cal = Calendar.getInstance();
		l = lecture;
		System.out.println("학생 수를 입력하세요.");//학생 수를 설정하는 부분
		int argc = keyboard.nextInt(); keyboard.nextLine();
		students = new Student[argc];
		int code;
		String name;
		for (int a=0; a < argc; a++){
			System.out.println((a+1) + "번 학생의 이름을 입력하세요");
			name = keyboard.nextLine();
			System.out.println((a+1) + "번 학생의 학번을 입력하세요");
			code = keyboard.nextInt(); keyboard.nextLine();
			students[a] = new Student(name,code);
		}
		int enter, weeknum=1;
		boolean endCoin= true;
		Student s, s1;
		String strInput;
		
		do {//반복문
			menu();
			enter = keyboard.nextInt(); keyboard.nextLine();
			switch (enter) {
			case 1:
				System.out.println("시간표를 입력할 학생의 학번을 입력하세요.");
				enter = keyboard.nextInt(); keyboard.nextLine();
				if (null == (s = findStudent(enter))){
					System.out.println("학번이 "+enter+"인 학생이 없습니다.");
					break;
				}
				System.out.println("다음 중 추가할 시간표의 번호를 입력하세요.");
				showClass();
				enter = keyboard.nextInt(); keyboard.nextLine();
				s.setScheduleInformation(lecture[enter - 1]);

				break;
				
			case 2:
				System.out.println("과목의 이름을 입력하세요");
				strInput = keyboard.nextLine();
				int i=0;
				while (!lecture[i].getLectureName().equals(strInput) ){
					i++;
					if (i == 10){
						System.out.println("없는 강의입니다.");
						break;
					}
				}
				if (i == 10) {
					break;
				}
				System.out.println(lecture[i].getLectureName() +"을 수강하는 학생 수는 " +
						lecture[i].getEnrolled());
				break;
				
			case 3:
				System.out.println("시간표를 비교할 첫 번째 학생의 학번을 입력하세요");
				enter = keyboard.nextInt(); keyboard.nextLine();
				if (null == (s = findStudent(enter))){
					System.out.println("학번이 "+enter+"인 학생이 없습니다.");
					break;
				}
				System.out.println("두 번째 학생의 학번을 입력하세요");
				enter = keyboard.nextInt(); keyboard.nextLine();
				if (null == (s1 = findStudent(enter))){
					System.out.println("학번이 "+enter+"인 학생이 없습니다.");
					break;
				}
				if (s.equals(s1)){
					System.out.println("두 학생의 시간표는 같습니다.");
				}else{
					System.out.println("두 학생의 시간표는 다릅니다.");
				}
				break;
				
			case 4:
				System.out.println("시간을 지울 학생의 학번을 입력하세요");
				enter = keyboard.nextInt(); keyboard.nextLine();
				if (null == (s = findStudent(enter))){
					System.out.println("학번이 "+enter+"인 학생이 없습니다.");
					break;
				}
				System.out.println("지울 시간표의 요일을 입력하세요");
				strInput = keyboard.nextLine();
				strInput = strInput.toUpperCase();
				s = findStudent(enter);
				System.out.println("지울 시간표의 시간을 입력하세요");
				enter = keyboard.nextInt();keyboard.nextLine();
				for (int i1=1; i1 < 6; i1++) {
					if(strInput.equals(weeks[i1])) {
						s.deleteSchedule(strInput, enter);
					}
				}
				break;

			case 5:
				System.out.println("시간표를 출력할 학생의 학번을 입력하세요");
				enter = keyboard.nextInt(); keyboard.nextLine();
				if (null == (s = findStudent(enter))){
					System.out.println("학번이 "+enter+"인 학생이 없습니다.");
					break;
				}
				System.out.println(s.showTimetable());
				break;
				
			case 6://TODO 고치기
				System.out.println("시간표를 출력할 학생의 학번을 입력하세요");
				enter = keyboard.nextInt(); keyboard.nextLine();
				if (null == (s = findStudent(enter))){
					System.out.println("학번이 "+enter+"인 학생이 없습니다.");
					break;
				}
				Calendar C = s.setInputDate();
				if (1 == C.get(C.DAY_OF_WEEK) || 7 == C.get(C.DAY_OF_WEEK) ){
					System.out.println("주말인 날짜입니다.");
					break;
				}
				System.out.println(s.oneDaySchedule(weeks[C.get(C.DAY_OF_WEEK)-1]));
				break;
			case 7:
				endCoin = false;
				System.out.println("종료합니다.");
				break;

			default:
				System.out.println("Try again.");
				break;
			}

		} while (endCoin);
	}

	private static void showClass() {
		for (int i=0; i < 10; i++){
			System.out.println("(" + (i+1) + ") " + l[i].getLectureName()
			+ " - " + l[i].getDay() + " - " + l[i].getTime());
		}
	}
	private static void menu(){
		System.out.println("메인 메뉴");
		System.out.println("1.학생 시간표 입력");
		System.out.println("2.수강생 수 출력");
		System.out.println("3.학생들의 시간표 비교");
		System.out.println("4.학생 시간표 삭제");
		System.out.println("5.시간표 출력");
		System.out.println("6.학생의 특정 요일 시간표 출력");
		System.out.println("7.종료");
	}
}
