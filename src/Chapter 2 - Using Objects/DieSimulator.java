/**
 * DieSimulator - the kind you roll around on a table. Does not imply death.
 * 
 * Version 1.1
 * - added support for tie games and re-uploaded
 * 
 * @author ethan.lee
 *
 * @TODO
 * * needs to validate user input for Players, to make sure that their choice falls within the sides of die
 * * > 2 player support
 */
import java.util.*;

public class DieSimulator {
	
	static Random die = new Random();
	static Scanner prompt = new Scanner(System.in);
	
	//	0 will indicate the number of sides of die, 1 will indicate Player 1's choice and 2 
	//	will indicate Player 2's choice
	static int[] nums = new int[3];
	
	public static void main (String[] args) {
		System.out.println("Welcome to the DieSimulator. Choose the number of sides on your die.");
		loopValidate(0); //get and validate number of sides on die
		
		System.out.println("This is a game where the system will randomly generate a number. The closest"
				+ " number wins.");
		
		System.out.println("Player 1's choice:");
		loopValidate(1);
		
		System.out.println("Player 2's choice:");
		loopValidate(2);
		
		int luckyNumber = die.nextInt(nums[0]) + 1;
		
		if(Math.abs(nums[1] - luckyNumber) < Math.abs(nums[2] - luckyNumber)) {
			System.out.println("Player 1 wins! The winning number was " + luckyNumber);
		}
		else if ((Math.abs(nums[1] - luckyNumber) == Math.abs(nums[2] - luckyNumber))) {
			System.out.println("Player 1 and Player 2 tie! Winning number was " + luckyNumber);
		}
		else {
			System.out.println("Player 2 wins! The winning number was " + luckyNumber);
		}
		
	}
		
	private static void loopValidate(int i){
		//	Taken from AreaTester.java, since this code took a long time to make and it would be
		//	nice to reuse in future code requiring an integer.
		
		try {nums[i] = prompt.nextInt();}
		catch (Exception e) {nums[i] = 0; prompt.nextLine();} //reset variable, clear buffers
		
		while(nums[i] <= 0 || (nums[i] % 1) != 0){
			System.out.println("Error, requires integer number above zero. Try again.");
			try {nums[i]=prompt.nextInt();}
			catch (Exception e) {nums[i] = 0; prompt.nextLine();}	
		}
	}
}