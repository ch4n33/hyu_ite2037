package selfTest;

public class Employee {
	private String name;
	private int age;
	private String position = "Engineer";
	private int salary = 15000;
	private int vacationDays = 20;
	
	public Employee() {}
	
	public Employee(String n, int a) {
		this.name = n;
		this.age = a;
	}
	
	public Employee(String n, int a, String p, int s) {
		this.name = n;
		this.age = a;
		this.position = p;
		this.salary = s;
	}
	
	public Employee(String n, int a, String p, int s, int v) {
		this.name = n;
		this.age = a;
		this.position = p;
		this.salary = s;
		this.vacationDays = v;
	}
	
	public void setSalary(int s) {
		this.salary = s;
	}
	
	public void outInfo() {
		System.out.println("Name : " + name + "\nAge : " + age
				+ "\nPosition : " + position + "\nSalary : " + salary
				+ "\nVacation days : " + vacationDays + "\n");
	}
	
	public String vacation(int v) {
		if(v > this.vacationDays)
			return "Impossible";
		else {
			this.vacationDays -= v;
			return "Possible";
		}
	}
	
	public boolean equals(Employee E) {
		if(this.name.equals(E.name) && this.age == E.age 
				&& this.position.equals(E.position)) {
			return true;
		}
		else
			return false;
	}
	
}
