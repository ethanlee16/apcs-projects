/**
 * RomanNumerals.java - converts base-10 Arabic numerals
 * to the ancient Roman kind.
 * 
 * @author ethan.lee
 *
 */
import java.util.Scanner;
public class RomanNumerals {

	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		
		System.out.println("Please enter a number between 0 and 3999.");
		prompt = new Scanner(System.in);
		
		int input;
		String numeral = "";
		while(!prompt.hasNext("[0-3]?[0-9]?[0-9]?[0-9]?")) {
			System.out.println("Test");
			prompt.next();
		}
		input = prompt.nextInt();
		
		while(input >= 1000) {
			input -= 1000;
			numeral += "M";
		}
		while(input >= 900) {
			input -= 900;
			numeral += "CM";
		}
		while (input >= 500) {
			input -= 500;
			numeral += "D";
		}
		while(input >= 400) {
			input -= 400;
			numeral += "CD";
		}
		while (input >= 100) {
			input -= 100;
			numeral += "C";
		}
		while(input >= 90) {
			input -= 90;
			numeral += "XC";
		}
		while (input >= 50) {
			input -= 50;
			numeral += "L";
		}
		while(input >= 40) {
			input -= 40;
			numeral += "XL";
		}
		while (input >= 10) {
			input -= 10;
			numeral += "X";
		}
		while(input >= 9) {
			input -= 9;
			numeral += "IX";
		}
		while (input >= 5) {
			input -= 5;
			numeral += "V";
		}
		while(input >= 4) {
			input -= 4;
			numeral += "IV";
		}
		while (input >= 1) {
			input -= 1;
			numeral += "I";
		}
		System.out.println(numeral);
	}
}
