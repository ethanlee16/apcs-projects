/**
 * Statistics.java - takes two numbers and gives simple calculations of them
 * @author ethan.lee
 *
 */
import java.util.Scanner;

public class Statistics {
	private static Scanner prompt = new Scanner(System.in);
	public static void main(String[] args) {
		int a, b;
		
		System.out.println("Please enter the first integer: ");
		while (!prompt.hasNextInt()) {
			prompt.next();	
			System.out.println("Error - must be an integer value.");
		}
		a = prompt.nextInt();
		
		System.out.println("Please enter the second integer: ");
		while (!prompt.hasNextInt()) {
			prompt.next();	
			System.out.println("Error - must be an integer value.");
		}
		b = prompt.nextInt();
		
		System.out.println("--- STATISTICS ---");
		System.out.println("Sum: \t\t" + (a + b) +
				"\nDifference: \t" + (a - b) +
				"\nProduct: \t" + (a * b) +
				"\nAverage: \t" + (a + b) / 2 +
				"\nDistance: \t" + Math.abs(a - b) +
				"\nMaximum: \t" + Math.max(a, b) +
				"\nMinimum: \t" + Math.min(a, b));
	}

}