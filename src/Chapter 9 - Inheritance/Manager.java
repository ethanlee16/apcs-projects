
public class Manager extends Employee {
	
	private String department;
	
	public Manager(String name, String department, int salary) {
		super(name, salary);
		this.department = department;
	}
	
	public String toString() {
		return super.toString() + "\nDepartment: " + department;
	}
}
