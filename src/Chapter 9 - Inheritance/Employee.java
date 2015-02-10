
public class Employee {
	private String name;
	private int salary;
	
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return "Name: " + name + "\nSalary: " + salary;
	}
}
