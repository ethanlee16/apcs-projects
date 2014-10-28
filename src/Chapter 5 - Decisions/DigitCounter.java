/**
 * DigitCounter.java - counts the number of digits in a given number
 * @author ethan.lee
 *
 */
import java.util.Scanner;

public class DigitCounter {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		
		System.out.println("Welcome to DigitCounter. Enter any integer number.");
		prompt = new Scanner(System.in);
		
		int num;
		String numString;
		while(!prompt.hasNextInt()) {
			System.out.println("Error: requires an integer number.");
			prompt.next();
		}
		num = prompt.nextInt();
		numString = Integer.toString(Math.abs(num));
		// Takes absolute value for negative numbers,
		// i.e. the negative sign is not a digit.
		
		System.out.println("The number " + num + " has "
				+ numString.length() + " digits.");
		
	}
	
}
