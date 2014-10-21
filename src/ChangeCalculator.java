/**
 * ChangeCalculator.java - for a cashier, not the President
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class ChangeCalculator {
	
	private static Scanner prompt = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Please enter the amount, in pennies, that is due at this point-of-sale.");
		int amountDue;
		while(!prompt.hasNextInt() || !prompt.hasNext("[0-9]*")) {
			System.out.println("Must be an integer penny value.");
			prompt.next();
		}
		amountDue = prompt.nextInt();
		
		System.out.println("Please enter the amount, in pennies, that the customer has paid.");
		int amountReceived;
		while(!prompt.hasNextInt() || !prompt.hasNext("[0-9]*")) {
			System.out.println("Must be an integer penny value.");
			prompt.next();
		}
		amountReceived = prompt.nextInt();
		
		int change = amountReceived - amountDue;
		int dollars = change / 100;
		int quarters = (change % 100) / 25;
		int dimes = (change % 100 % 25) / 10;
		int nickels = (change % 100 % 25 % 10) / 5;
		int pennies = (change % 100 % 25 % 10 % 5) / 1;
		
		System.out.println("Customer is due " + dollars + " dollars, "
				+ quarters + " quarters, " + dimes + " dimes, "
				+ nickels + " nickels, and " + pennies + " pennies.");
	}
}
