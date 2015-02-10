
public class Executive extends Manager {
	
	// there were no specs for what Executive should have
	// so execPosition was something I made up
	private String execPosition;
	
	public Executive(String name, String department, String execPosition, int salary) {
		super(name, department, salary);
		this.execPosition = execPosition;
	}
	
	public String toString() {
		return super.toString() + "\nExecutive Position: " + execPosition;
	}
}
