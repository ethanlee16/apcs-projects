
public class Instructor extends Person {
	private int salary;
	
	public Instructor(String name, int salary, int birthYear) {
		super(name, birthYear);
		this.salary = salary;
	}
	
	public String toString() {
		String personInfo  = super.toString();
		return "Type: " + this.getClass().getName() 
				+ personInfo.substring(personInfo.indexOf("\n"), personInfo.length())
				+ "\nSalary: " + salary;
	}
}
