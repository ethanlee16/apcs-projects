/**
 * EscapeVelocity.java -
 * Calculates if your jump causes you to leave planetary gravity.
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class EscapeVelocity {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** Gravitational constant (go physics!) **/
	static final double GRAVITATIONAL_CONSTANT = 6.67E-11;
	
	/** Mass of Halley's comet. **/
	static final double HALLEYS_COMET_MASS = 1.3E+22;
	
	/** Radius of Halley's comet. **/
	static final double HALLEYS_COMET_RAD = 1.153E+6;
	
	/** Conversion constant from m/s to mph **/
	static final double METERS_SECONDS_TO_MILES_HOURS = 2.23694;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Enter the velocity (in mph) "
				+ "of your jump from Halley's Comet.");
		prompt = new Scanner(System.in);
		
		double velocity;
		while(!prompt.hasNextDouble()) {
			System.out.println("Invalid input. "
					+ "Requires floating point number. Try again.");
			prompt.next();
		}
		velocity = prompt.nextDouble();
		System.out.println(velocity);
		double escVelocity = Math.sqrt((2 * GRAVITATIONAL_CONSTANT
				* HALLEYS_COMET_MASS) / HALLEYS_COMET_RAD);
		System.out.println(escVelocity);
		
		if(velocity > escVelocity * METERS_SECONDS_TO_MILES_HOURS) {
			System.out.println("Zounds! You've jumped straight "
					+ "off of Halley's comet!");
		} else {
			System.out.println("Phew, you're still on the comet. "
					+ "Hang on!");
		}
	}
}
