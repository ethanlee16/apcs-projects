/**
 * DewTempCalculator.java - calculates the dew point temperature with
 * given values for relative humidity and temperature.
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class DewTempCalculator {
	
	/** The Scanner to read all values for the program **/
	static Scanner prompt = new Scanner(System.in);
	
	/** DecimalFormat object to format the output. **/
	static DecimalFormat decimal = new DecimalFormat("#.###");
	
	/** Represents "a" in the dewpoint formula. **/
	static final double a = 17.27;
	
	/** Represents "b" in the dewpoint formula. **/
	static final double b = 237.7;
	
	public static void main(String[] args) {
		System.out.println("Please enter a value between 0 and 1 for the relative humidity: ");
		
		double relativeHumidity;
		while(!prompt.hasNextDouble() || !prompt.hasNext("0(\\.\\d+)?|1(\\.0)?")) {
			System.out.println("Try again, the value must be between 0 and 1.");
			prompt.next();
		}
		relativeHumidity = prompt.nextDouble();
		
		System.out.println("Please enter a value in Celsius for the temperature.");
		double temp;
		while(!prompt.hasNextDouble()) {
			System.out.println("Try again, must be a floating-point value.");
			prompt.next();
		}
		temp = prompt.nextDouble();
		
		double func = ((temp * a) / (temp + b)) + Math.log(relativeHumidity);
		System.out.println("The dewpoint is: "
				+ decimal.format((b * func) / (a - func)) + " degrees Celsius.");
	}
}
