/**
 * MeterConverter.java - converts meters into those Imperial unit things
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class MeterConverter {
	/** Conversion factor, approximated, for number of miles for one meter. */
	public static final double MILES_IN_METER = 0.000621371;
	
	/** Conversion factor, approximated, for number of feet for one meter. */
	public static final double FEET_IN_METER = 3.28084;
	
	/** Conversion factor, approximated, for number of inches for one meter. */
	public static final double INCHES_IN_METER = 39.3701;
	
	private static Scanner prompt = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Please enter a certain number of meters to be converted: ");
		while (!prompt.hasNextDouble()) {
			prompt.next();	
			System.out.println("Error - must be a number value.");
		}
		double meters = Math.abs(prompt.nextDouble());
		System.out.println(meters + " meters converted to:" +
				"\n" + meters * MILES_IN_METER + " miles," +
				"\n" + meters * FEET_IN_METER + " feet, and" +
				"\n"+ meters * INCHES_IN_METER + " inches.");
	}
}
