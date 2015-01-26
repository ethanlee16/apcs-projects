import java.util.Scanner;
import java.util.Arrays;
/*
 * THIS DOESN'T WORK, FIXING LATER
 */
public class TheaterSeats {
	
	private static Scanner prompt;
	
	private static int[][] seats = {	
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 
			{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 
			{10, 10, 20, 20, 20, 20, 20, 20, 10, 10}, 
			{10, 10, 20, 20, 20, 20, 20, 20, 10, 10}, 
			{10, 10, 20, 20, 20, 20, 20, 20, 10, 10}, 
			{20, 20, 30, 30, 40, 40, 30, 30, 20, 20}, 
			{20, 30, 30, 40, 50, 50, 40, 30, 30, 20}, 
			{30, 40, 50, 50, 50, 50, 50, 50, 40, 30}
	};
	
	public static void main(String[] args) {
		prompt = new Scanner(System.in);
		boolean running = true;
		
		while(running) {
			System.out.print(getAvailableSeats());
			System.out.print("Please enter one of the seats above, "
					+ "as a coordinate in the form 1 3 or a price "
					+ "(next available seat will be selected).\n> ");
			
			String input = prompt.nextLine();
			while(!prompt.hasNext("\\d+") || !prompt.hasNext("\\d+ \\d+")) {
				System.out.print("Invalid input. Try again.\n> ");
			}
			input = prompt.nextLine();
			
			dance:
			if(input.matches("\\d+")) {
				for(int i = 0; i < seats.length; i++) {
					for(int j = 0; j < seats[i].length; j++) {
						if(seats[i][j] == Integer.valueOf(input)) {
							System.out.println("Reserved seat at " 
									+ i + 1 + ", " + j + 1);
							break dance; //feeling silly
						}
					}
				}
				int index = Arrays.asList(seats).indexOf(Integer.valueOf(input));
				
				// seats[index] = 0; 
				// commented out because it gives an error (a stupid mistake on my part)
				// TODO: calculate index var to produce the correct 2d array numbers
				
				System.out.println("Reserved seat at " + index);
			} else if (input.matches("\\d+ \\d+")) {
				String[] coords = input.split(" ");
				
				int x = Integer.valueOf(coords[0]) - 1;
				int y = Integer.valueOf(coords[1]) - 1;
				
				if(seats[x][y] != 0) {
					System.out.println("Reserved seat at " + x + 1 + ", " + y + 1);
					seats[x][y] = 0;
				} 
				else {
					System.out.println("This seat is already reserved!");
				}
			} else if(input.matches("[Qq]")) {
				running = false;
			}
		}
		System.out.println("Goodbye!");
	}
	
	private static String getAvailableSeats() {
		String ret = "\n\n\t 1    2    3    4    5    6    7    8    9    10   \n";
		for(int i = 0; i < seats.length; i++) {
			for(int j = 0; j < seats[i].length; j++) {
				if(j == 0) {
					ret += i + 1 + "\t";
				}
				if(seats[i][j] == 0) {
					ret += "X  ";
				}
				else {
					ret += "$" + seats[i][j] + "  ";
				}
			}
			ret += "\n\n";
		}
		return ret;
	}
	
}
