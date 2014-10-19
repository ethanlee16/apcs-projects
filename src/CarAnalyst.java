/**
 * 
 * CarAnalyst.java - Calculates the cost of owning any kind of car for five years.
 * 
 * @author ethan.lee
 * @version 0.2
 *
 */
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CarAnalyst {
	
	/** Primary input for CarAnalyst; may change as UI is developed. **/
	private static Scanner prompt = new Scanner(System.in);
	
	/** Fixed until implemented as user input. **/
	private static final int YEARS = 5;
	
	/** 
	 * Used to list the following user-given properties for the car: 
	 * Cost of car, fuel efficiency, gas price, mileage after five years, and
	 * estimated value after five years.
	 */
	private Map<String, Double> properties = new HashMap<>();
	
	public static void main(String[] args) {
		
		// initialize instance of CarAnalyst for running its own functions
		// from the static void main context 
		CarAnalyst ca = new CarAnalyst();
		
		ca.validateInput("cost", "Please enter the cost of the car.");
		ca.validateInput("mpg", "Please enter the estimated miles per gallon for the car.");
		ca.validateInput("gasPrice", "Please enter the estimated gas price these days.");
		ca.validateInput("mileageAfterYears", "Please enter the estimated mileage after " +
				YEARS + " years of use.");
		ca.validateInput("valueAfterYears", "Please enter the estimated value of the car after "+
				YEARS + " years of use");
		
		// DIAGNOSTIC - prints contents of ca.properties
		for(Map.Entry<String,Double> entry : ca.properties.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
	}
	
	private void validateInput(String property, String userMessage) {
		System.out.println(userMessage);
		double temp;
		while (!prompt.hasNextDouble()) {
			prompt.next();	
			System.out.println("Error - value unacceptable for \"" + property + "\"");
		} temp = prompt.nextDouble();
		properties.put(property, temp);
	}
	
	private void storeInput(String property, double value) {
		properties.put(property, value);
	}
}
