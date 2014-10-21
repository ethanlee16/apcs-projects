/**
 * PhoneNumberFormat.java - formats phone numbers
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class PhoneNumberFormat {
	private static Scanner prompt = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter a ten-digit number to be formatted here:");
		String number;
		while(!prompt.hasNext("[0-9]{10}")) {
			System.out.println("Invalid phone number, try again.");
			prompt.next();
		}
		number = prompt.nextLine(); // Will return nothing.
		number = prompt.nextLine(); // Required for validation
		number = "(" + number.substring(0, 3) + ") " + number.substring(3, 6) + "-" + number.substring(6, 10);
		System.out.println(number);
	}
}
