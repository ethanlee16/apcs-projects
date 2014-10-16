/**
 * 
 * Namebox.java - takes user's name and puts it in a classy ASCII box.
 * 
 * Version 1.0 was wiped because its careless author was trying to save on a computer that was on such
 * low battery the screen was flickering. Apparently it had no power left to drive disk saves.
 * 
 * Version 1.1 adds Longbox, supporting greater than 13 characters in a name.
 * 1.1 is called Phoenix. Rising up out of ashes and scorching 1.0, which died long before.
 * 
 * Version 1.2 removes the absurd disparity between using an int for blanksLeft and String for blanksRight.
 * Everything takes place in a for loop now. Much better. 
 * 
 * @author ethan.lee
 *
 */
import java.util.*;

public class Namebox {
	public static Scanner prompt = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Welcome to Namebox. Enter your name and we'll put it in a sweet looking box.");
		String username = prompt.nextLine();
		
		//	The difference between 13 character words/sentences vs. >13 is that we'll create a box
		//	with padding in shorter phrases. This requires a bit more math, as one might observe.
		
		if (username.length() <= 13){
			System.out.print(" +===========+\n|");
			
			//Strings to be built for spaced padding between name and "wall"
			String blanksLeft = "";
			String blanksRight = "";
		
			//Tests if this phrase is even, we need to add an extra right blank to normalize the centering
			if ((username.length() % 2) == 0) {
				blanksRight += " ";
			}
		
			for (int i = (13 - username.length())/2; i>0; i--) {
				blanksLeft += " ";
				blanksRight += " ";
			}
			System.out.print(blanksLeft + username + blanksRight + "|\n +-----------+");
		
		}
		else {
			//Is greater than 13 characters, needs extra equal signs for box.
			System.out.print(" +");
			int extraChars = username.length() + 2;
			String equals = "";
			
			while (extraChars > 0){
				equals += "=";
				extraChars--;
			}
			
			System.out.print(equals + "+\n|  " + username + "  |\n +" + equals + "+");
			
			
		}
		
	}
}