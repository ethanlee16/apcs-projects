/**
 * BasicCarAnalyst - Analyzes simple properties of owning a car.
 * @author ethan.lee
 *
 */
import java.util.Scanner;
import java.text.NumberFormat;
public class BasicCarAnalyst {
	
	private static Scanner prompt = new Scanner(System.in);
	private static NumberFormat toDollars = NumberFormat.getCurrencyInstance();
	
	public static void main(String[] args) {
		double fuel, mpg, gasPrice;
		System.out.println("Please input your car's fuel tank level in gallons.");
		while (!prompt.hasNextDouble()) {
			System.out.println("Must be a number value!");
			prompt.next();
		}
		fuel = prompt.nextDouble();
		
		System.out.println("Please input your car's fuel efficiency in miles / gallon.");
		while (!prompt.hasNextDouble()) {
			System.out.println("Must be a number value!");
			prompt.next();
		}
		mpg = prompt.nextDouble();
		
		System.out.println("Please input the price of gas per gallon.");
		while (!prompt.hasNextDouble()) {
			System.out.println("Must be a number value!");
			prompt.next();
		}
		gasPrice = prompt.nextDouble();
		
		System.out.println("The cost per 100 miles is " 
				+ toDollars.format(100 / mpg * gasPrice)
				+ "\nand the amount remaining you can drive is "
				+ fuel * mpg + " miles.");
	}
}
