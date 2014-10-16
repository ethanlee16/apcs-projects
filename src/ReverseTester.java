/**
 * ReverseTester.java - Demonstrates the uses of StringBuilder's reverse();
 * 
 * Version 1.0
 * @author ethan.lee
 *
 */
import java.util.*;

public class ReverseTester {
	static StringBuilder longString = new StringBuilder();
	static StringBuilder expectedReversedString = new StringBuilder();
	static Scanner prompt = new Scanner(System.in);
	public static void main (String[] args) {
		
		System.out.println("Welcome to the ReverseTester! Type in a string to be reversed.");
		longString.append(prompt.nextLine());
		
		System.out.println("A drumroll please!");
		
		int length = longString.toString().length();
		for (int i = (length - 1); i >= 0; i--) {
			expectedReversedString.append(longString.charAt(i));
			System.out.print("tum ");
		}
		
		System.out.println("\nAha!\nOriginal: " + longString.toString());
		System.out.println("Expected reversed: " + expectedReversedString);
		System.out.println("Actual: " + longString.reverse().toString());
		
	}
}
