/**
 * Pupil.java - called so because we've already made classes
 * called Student and there are conflicts that I don't want
 * to resolve now.
 * 
 * @author ethan
 *
 */
public class Pupil extends Person {
	private String major;
	
	public Pupil(String name, String major, int birthYear) {
		super(name, birthYear);
		this.major = major;
	}
	
	public String toString() {
		String personInfo  = super.toString();
		return "Type: " + this.getClass().getName() 
				+ personInfo.substring(personInfo.indexOf("\n"), personInfo.length())
				+ "\nMajor: " + major;
	}
}
