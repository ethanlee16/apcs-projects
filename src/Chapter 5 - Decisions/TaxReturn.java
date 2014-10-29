import java.util.Scanner;

/**
 * IncomeTax.java - computes the income tax like it's 1913
 * - but it can also calculate the tax for any six-bracket
 * tax collection system.
 * 
 * @author ethan.lee
 *
 */
public class TaxReturn {
	
	/**
	 *  Fields of all of the following are to 
	 *  avoid magic numbers and improve extensibility.
	**/
	
	// TODO: This could be much better implemented,
	// and it could even have an infinite number of
	// brackets and less repetitive code.
	// Would require a List<Integer, Integer> for
	// both percentages and bracket caps. A for loop
	// could then be used for the calculation logic.
	
	public static final int BRACKET_MAX_3_M = 64000;
	public static final int BRACKET_MAX_2_M = 16000;
	public static final int BRACKET_MAX_1_M = 0;
	
	public static final int BRACKET_MAX_3 = 32000;
	public static final int BRACKET_MAX_2 = 8000;
	public static final int BRACKET_MAX_1 = 0;
	
	public static final double BRACKET_PERCENT_3_M = 0.25;
	public static final double BRACKET_PERCENT_2_M = 0.15;
	public static final double BRACKET_PERCENT_1_M = 0.1;
	
	public static final double BRACKET_PERCENT_3 = 0.25;
	public static final double BRACKET_PERCENT_2 = 0.15;
	public static final double BRACKET_PERCENT_1 = 0.1;
	
	public static final int BRACKET_BASE_3 = 4400;
	public static final int BRACKET_BASE_2 = 800;
	public static final int BRACKET_BASE_1 = 0;
	
	public static final int BRACKET_BASE_3_M = 8800;
	public static final int BRACKET_BASE_2_M = 1600;
	public static final int BRACKET_BASE_1_M = 0;
	
	/** Scanner to read all user inputs **/
	private static Scanner prompt;
	
	/** 
	 * Runs the program, takes input, processes.
	 * @param args Array of runtime arguments  
	**/
	public static void main(String[] args) {
		System.out.println("Please enter your annual income.");
		prompt = new Scanner(System.in);
		
		int income;
		boolean married = false;
		int tax = 0;
		while(!prompt.hasNextInt()) {
			System.out.println("Please enter an integer amount of "
					+ "an approximated annual income.");
			prompt.next();
		}
		income = prompt.nextInt();
		
		String response = "";
		System.out.println("Are you married? [y/n]");
		while(!prompt.hasNext("y") && !prompt.hasNext("n")) {
			System.out.println("Invalid response.");	
			prompt.next();
		}
		response = prompt.nextLine();
		response = prompt.nextLine(); // second required for correct line
		
		switch (response.trim()) {
		case "y":
			married = true;
			break;
		case "n":
			married = false;
			break;
		}

		int incomeMutated = 0;
		if(married) {
			if(income > BRACKET_MAX_3_M) {
				tax += BRACKET_PERCENT_3_M * (income - BRACKET_MAX_3_M - incomeMutated) + BRACKET_BASE_3_M;
				incomeMutated += income - BRACKET_MAX_3_M - incomeMutated;
			}
			if(income > BRACKET_MAX_2_M) {
				tax += BRACKET_PERCENT_2_M * (income - BRACKET_MAX_2_M - incomeMutated) + BRACKET_BASE_2_M;
				incomeMutated += income - BRACKET_MAX_2_M - incomeMutated;
			}
			if(income > BRACKET_MAX_1_M) {
				tax += BRACKET_PERCENT_1_M * (income - BRACKET_MAX_1_M - incomeMutated) + BRACKET_BASE_1_M;
				incomeMutated += income - BRACKET_MAX_1_M - incomeMutated;
			}
		}
		else {
			if(income > BRACKET_MAX_3) {
				tax += BRACKET_PERCENT_3 * (income - BRACKET_MAX_3 - incomeMutated) + BRACKET_BASE_3;
				incomeMutated += income - BRACKET_MAX_3 - incomeMutated;
			}
			if(income > BRACKET_MAX_2) {
				tax += BRACKET_PERCENT_2 * (income - BRACKET_MAX_2 - incomeMutated) + BRACKET_BASE_2;
				incomeMutated += income - BRACKET_MAX_2 - incomeMutated;
			}
			if(income > BRACKET_MAX_1) {
				tax += BRACKET_PERCENT_1 * (income - BRACKET_MAX_1 - incomeMutated) + BRACKET_BASE_1;
				incomeMutated += income - BRACKET_MAX_1 - incomeMutated;
			}
		}

		System.out.println("Your total tax is $"
				+ tax + " for your income of $"
				+ income + ".\nLove, the IRS.");
		
	}
}
