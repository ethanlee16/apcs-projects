/**
 * ProjectileFlight.java
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class ProjectileFlight {
	
	// CONFIGURABLE TO ANY INCREMENT OF A SECOND
	public static final double DELTA_T = 0.01;
	
	public static final double GRAVITY = 9.81;
	
	private static Scanner prompt;
	
	public static void main(String[] args) {
		System.out.println("Please enter an initial velocity.");
		prompt = new Scanner(System.in);
		
		double initialVelocity = prompt.nextDouble(); // In m/s
		double s = 0; // current position for simulation
		double v = initialVelocity; // current velocity for simulation
		int end = (int)((2 * initialVelocity) / GRAVITY); // approximation for when s is 0 again
		
		// Simulation scenario does not account for initial
		System.out.println("Time: 0\nSimulation: 0.0");
		
		for(int t = 0; t < end; t++) {
			
			System.out.println("Formula: "
					+ ((-1 / 2.0) * GRAVITY * t * t + initialVelocity * t)
					+ "\n------------------");
			
			// i represents the increment of delta-t'th of a second
			// that we are updating the position on
			for(double i = t; i < t + 1; i += DELTA_T) {
				s = s + v * DELTA_T;
				v = v - GRAVITY * DELTA_T;
			}
			System.out.println("Time: " + (t + 1));
			System.out.println("Simulation: " + s);
		}
		
		// Last value
		System.out.println("Formula: "
				+ ((-1 / 2.0) * GRAVITY * end * end + initialVelocity * end));
		
	}
}
