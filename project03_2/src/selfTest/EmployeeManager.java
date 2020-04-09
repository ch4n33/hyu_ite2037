package selfTest;

public class EmployeeManager {

	public static void main(String[] args) {
		Employee employee1 = 
				new Employee("Walter White", 42, "Manager", 20000);
		Employee employee2 = 
				new Employee("Jesse Pinkman", 32, "Assistant Manager",12000, 7);
		Employee employee3 = 
				new Employee("Jimmie McGill", 38);
		Employee employee4 =
				new Employee("Chuck McGill", 40);
		Employee employee5 =
				new Employee("Walter White", 42, "Manager", 20000);
		
		employee1.setSalary(21000);
		employee5.setSalary(21000);
		employee1.outInfo();
		employee2.outInfo();
		
		System.out.println(employee3.vacation(10) + "\n");
		System.out.println(employee2.vacation(10) + "\n");
		employee3.outInfo();
		
		System.out.println(employee1.equals(employee2));
		System.out.println(employee1.equals(employee5));
	}

}
