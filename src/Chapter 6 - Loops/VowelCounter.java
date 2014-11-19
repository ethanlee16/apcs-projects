/**
 * VowelCounter.java - counts number of vowels
 * @author - ethan.lee
 * 
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class VowelCounter {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Please enter a phrase "
				+ "to count the vowels.");
		prompt = new Scanner(System.in);
		String input = prompt.nextLine();
		Pattern pattern = Pattern.compile("[AEIOUYaeiouy]");
		Matcher matcher = pattern.matcher(input);
		
		int count = 0;	
		while(matcher.find()) {
			count++;
		}
		
		System.out.println("Number of vowels: " + count);
	}
}
