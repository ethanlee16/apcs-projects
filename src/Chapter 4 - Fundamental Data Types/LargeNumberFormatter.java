/**
 * LargeNumberFormatter.java - strips large numbers of commas.
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class LargeNumberFormatter {
	private static Scanner prompt = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Please enter a number between 1,000 and 999,999 to format.");
		
		String number;
		while (!prompt.hasNext("[0-9]{1,3},[0-9]{3}")) {
			System.out.println("Must enter a number 1,000-999,999 with a comma.");
			prompt.next();
		}
		number = prompt.nextLine();
		
		System.out.println(number.substring(0, number.length() - 4)
				+ number.substring((number.length() - 3), number.length()));
		
	}
}
