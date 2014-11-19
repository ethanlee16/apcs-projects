/**
 * StringProcessor.java - does a few things to String inputs:
 * 
 *  - prints upper-case letters
 *  - prints every second letter
 *  - replaces all vowels with underscores
 *  - prints number of vowels
 *  - prints positions of vowels
 *  
 * @author ethan.lee
 *
 */
import java.util.Scanner;
import java.util.regex.*;

public class StringProcessor {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Please enter a string to be "
				+ "processed.");
		prompt = new Scanner(System.in);
		String input = prompt.nextLine();
		
		// Prints all upper-case letters.
		System.out.print("Uppercase letters: ");
		for(int i = 0; i < input.length(); i++) {
			if(Character.isUpperCase(input.charAt(i))) {
				System.out.print(input.charAt(i));
			}
		}
		System.out.print("\nEvery second letter: ");
		
		// Prints every second letter.
		for(int i = 1; i < input.length(); i += 2) {
			System.out.print(input.charAt(i));
		}
		System.out.print("\nVowels taken out: ");
		
		// Replaces vowels with underscores.
		System.out.print(input.replaceAll("[AEIOUaeiou]", "_"));
		
		// Prints number of vowels.
		Pattern pattern = Pattern.compile("[AEIOUaeiou]");
		Matcher matcher = pattern.matcher(input);
		String positions = "";
		int count = 0;
		
		while(matcher.find()) {
			count++;
			positions += matcher.start() + ", ";
		}
		// Remove trailing comma and whitespace
		positions = positions.substring(0, (positions.length() - 2));
		
		System.out.println("\nNumber of vowels: " + count
				+ "\nPositions of vowels: " + positions);

		
	}

}
