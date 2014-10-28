/**
 * 
 * Architect.java - builds console houses of any size!
 * 
 * 0.1 only built the top and second layers of roof
 * 0.2 puts the whole roof on
 * 1.0 actually builds the whole house!
 * 1.1 adds select optimizations from pr/1
 * 
 * @author ethan.lee and Timothy Gu
 *
 */
import java.util.*;

public class Architect {
	
	private static Scanner prompt = new Scanner(System.in);
	private static StringBuilder houseStr = new StringBuilder();
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Architect. Please enter an ODD number for the width of your new house. "
				+ "The minimum and standard is seven.");
		
		// Uses double to accept anything (although still crashes on String input clearly)
        // We check this with the conditionals to see if odd and integer
        
		double width = prompt.nextDouble();	
		while (width % 2 == 0 || width < 7) {
            System.out.println("Error: number must be at least 7 and odd. Try again:  ");
            width = prompt.nextDouble();
        }
		
		double half = Math.floor(width/2);
		double fourth = Math.ceil(width/4);
		double eighth = Math.floor(fourth/2);
		String equals = "";
		
		//First star for top of roof is about halfway
		for(int count = (int) half; count > 0; count--){
			houseStr.append(" ");
		}
		houseStr.append("*\n");
		
		//Seconds stars are about 1/4 of the way
		for (int count = (int) fourth; count > 0; count--){
			houseStr.append(" ");
		}
		houseStr.append("*");
		
		//Accounts for blanks in between two mid-stars
		for (int count = (int) (width - (fourth * 2) - 2); count > 0; count--) {
			houseStr.append(" ");
		}
		houseStr.append("*\n");
		
		for (int count = (int) eighth; count > 0; count--){
			houseStr.append(" ");
		}
		houseStr.append("*");
		 
		for (int count = (int) (width - (eighth * 2) - 2); count > 0; count--) {
			houseStr.append(" ");
		}
		houseStr.append("*\n");
		
		// Reusable code: the top two rows for the house are the same idea:
		// beginning symbol, character all the way across, and end symbol.

		for (int count = (int) width - 2; count > 0; count--){
			equals += "-";
		}
		houseStr.append("+" + equals + "+\n");
		houseStr.append("|" + equals.replace("-", " ") + "|\n");
		
		//Reset equals string for new loop
		equals = "";
		
		// Reusable code: the bottom three rows are essentially the same:
		// they have a beginning symbol, a repeating character, three symbols for the door,
		// repeating character again, and end symbol
		//
		// For example: +---+-+---+ makes up the bottom of the house, and |   .-.   | makes
		// the top of the door frame.
		
		for (int count = (int) half - 2; count > 0; count--){
			equals += " ";
		}
		houseStr.append("|" + equals + ".-." + equals + "|\n");
		houseStr.append("|" + equals + "| |" + equals + "|\n");
		houseStr.append("+" + equals.replace(" ", "-") + "+-+" + equals.replace(" ", "-") + "+");
		
		System.out.println(houseStr.toString());
		
	}

}
