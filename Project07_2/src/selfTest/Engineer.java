package selfTest;

public class Engineer extends Employee{
	private String workZone;
	private String project;
	
	public Engineer(String name, int employeeNum, String workZone, String project) {
		super(name, employeeNum);
		this.workZone = workZone;
		this.project = project;
	}
	
	public boolean equals(Object obj) {

		if(obj == null) {
			return false;
		}else if(getClass()!= obj.getClass()) {
			return false;
		}else {
			Engineer E = (Engineer) obj;
		return super.equals(E) && this.workZone.equals(E.workZone);
		}
	}
	
	public String toString() {
		return "Name : " + getName() + "\nEmp# : " + getEmployeeNum()+
				"\nlocation : " + getDepartment()+ ", " +workZone;
	}
}
