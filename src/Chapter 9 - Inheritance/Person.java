
public class Person {
	private String name;
	private int birthYear;
	
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	
	public String toString() {
		return "Type: " + this.getClass().getName() 
				+ "\nName: " + name + "\nYear of Birth: " + birthYear; 
	}
}
