/**
 * CurrencyConverter.java - converts currency
 * @author ethan.lee
 *
 */
import java.util.Scanner;

public class CurrencyConverter {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;		
		
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		double total = 0;
		
		prompt = new Scanner(System.in);
		System.out.println("Please enter the exchange rate "
				+ "of dollars to Japanese Yen (JPY).");
		
		while(!prompt.hasNextDouble()) {
			System.out.println("Invalid amount.");
		}
		
		double rate = prompt.nextDouble();
		
		System.out.println("Please enter an amount you wish to convert.");
		while(prompt.hasNextDouble()) {
			double amount = prompt.nextDouble();
			
			// Instead of an extra conditional and variable,
			// a break statement is used to detect the sentinel
			// to ensure immediate break of the loop when input
			// is received. 
			if (amount == 0) {
				break;
			}
			System.out.println("$" + amount + " converts to "
				+ rate * amount + " yen.");
			total += rate * amount;
			
			System.out.println("Please enter the next amount you wish "
				+ "to convert. Enter 0 to quit.");
		}
		
		System.out.println("Exiting... Total converted was "
				+ total + " yen.");
	}
}
