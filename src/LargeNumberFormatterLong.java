/**
 * LargeNumberFormatterLong.java - adds commas to large numbers.
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class LargeNumberFormatterLong {
private static Scanner prompt = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Please enter a number between 1000 and 999999 to format.");
		
		String number;
		while (!prompt.hasNext("[0-9]{1,3}[0-9]{3}")) {
			System.out.println("Must enter a number 1000-999999 without a comma.");
			prompt.next();
		}
		number = prompt.nextLine();
		
		number = number.substring(0, number.length() - 3) + ","
				+ number.substring((number.length() - 3), number.length());
		System.out.println(number);
		
	}
}
