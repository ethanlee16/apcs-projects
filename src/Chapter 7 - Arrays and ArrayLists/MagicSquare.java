import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class MagicSquare {
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		prompt = new Scanner(System.in);
		boolean valid = true;
		int[] array;
		ArrayList<Integer> acceptableValues = new ArrayList<Integer>(
				Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
		
		// Valid conditions for this input are 
		// 16 integers that have 1, 2, 3...16.
		// i.e. cannot have 17 for response.
		
		do {
			System.out.print("Please enter 16 integers, 1-16 (in any order)"
					+ " separated by spaces to test a magic square (in that order).\n> ");
			String input;
		
			input = prompt.nextLine();
			String[] sArray = input.split(" ");
			array = new int[16];
			
			// we will say that the minimum value will be an unreasonable response
			// and check later if all 16 values were filled.
			Arrays.fill(array, Integer.MIN_VALUE);
			
			it:
			for(int i = 0; i < sArray.length; i++) {
				try {
					array[i] = Integer.valueOf(sArray[i]);
					valid = true;
				}
				catch (NumberFormatException e) {
					System.out.println("Illegal character \'" + sArray[i]
							+ "\' - must be of Integer type.");
					valid = false;
					break it;
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("Array only takes 16 values!");
					valid = false;
					break it;
				}
			}
			if(valid) {
				it:
				for(int num : array) {
					if(num == Integer.MIN_VALUE) {
						System.out.println("Array is not filled correctly! Check number of values.");
						valid = false;
						break it;
					}
				}
			}
			
			// separate logic statement so that
			// previous is *required* for this execution
			if(valid) {
				it:
				for(int num : array) {
					if(acceptableValues.indexOf(num) == -1) {
						System.out.println("Array can only hold values 1-16! Try again.");
						valid = false;
						break it;
					}
					else {
						acceptableValues.remove(acceptableValues.indexOf(num));
					}
				}
				if(acceptableValues.size() != 16) {
					// reset the acceptable values
					acceptableValues = new ArrayList<Integer>(
							Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 
									10, 11, 12, 13, 14, 15, 16));
				}
			}
			
		} while(!valid);
		
		// Convert to two-dimensional
		System.out.println("User-inputted original square:");
		int[][] newArray = new int[4][4];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					newArray[j][k] = array[i];
					System.out.print(newArray[j][k] + "\t");
					i++;
				}
				System.out.print("\n");
			}
		}
		
		// Check the rows
		int row1 = 0, row2 = 0, row3 = 0, row4 = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				switch(i) {
				case 0:
					row1 += newArray[0][j];
					break;
				case 1:
					row2 += newArray[1][j];
					break;
				case 2:
					row3 += newArray[2][j];
					break;
				case 3:
					row4 += newArray[3][j];
					break;
				}
			}
		}
		
		// And the columns
		int col1 = 0, col2 = 0, col3 = 0, col4 = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				switch(i) {
				case 0:
					col1 += newArray[j][0];
					break;
				case 1:
					col2 += newArray[j][1];
					break;
				case 2:
					col3 += newArray[j][2];
					break;
				case 3:
					col4 += newArray[j][3];
					break;
				}
			}
		}
		
		int diag1 = newArray[0][0] + newArray[1][1] + newArray[2][2] + newArray[3][3];
		int diag2 = newArray[3][0] + newArray[2][1] + newArray[1][2] + newArray[0][3];
		
		if(row1 == row2
				&& row2 == row3 && row3 == row4
				&& row4 == col1 && col1 == col2
				&& col2 == col3 && col3 == col4
				&& col4 == diag1 && diag1 == diag2) {
			System.out.println("It's a magic square!");
		}
		
		else {
			System.out.println("Doesn't look like a magic square...");
		}
	}
}
