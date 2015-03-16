
public class ManTester {
	public static void main(String[] args) {
		
		Man a = new Man("Albert Lee", 1.3);
		Man b = new Man("Case Sadri", 1.85);
		Man c = new Man("John Smith", 2.25);
		
		Measurable[] men = {a, b, c};
		System.out.println("Average height is: " + Data.average(men) + "m.");
		System.out.println("Tallest man is: " + ((Man) Data.max(men)).getName() 
				+ " at " + Data.max(men).getMeasure() + "m.");
	}
}
