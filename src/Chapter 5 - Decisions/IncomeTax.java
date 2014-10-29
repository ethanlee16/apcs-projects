import java.util.Scanner;

/**
 * IncomeTax.java - computes the income tax like it's 1913
 * - but it can also calculate the tax for any six-bracket
 * tax collection system.
 * 
 * @author ethan.lee
 *
 */
public class IncomeTax {
	
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
	
	public static final int BRACKET_MAX_6 = 500000;
	public static final int BRACKET_MAX_5 = 250000;
	public static final int BRACKET_MAX_4 = 100000;
	public static final int BRACKET_MAX_3 = 75000;
	public static final int BRACKET_MAX_2 = 50000;
	public static final int BRACKET_MAX_1 = 0;
	
	public static final double BRACKET_PERCENT_6 = 0.06;
	public static final double BRACKET_PERCENT_5 = 0.05;
	public static final double BRACKET_PERCENT_4 = 0.04;
	public static final double BRACKET_PERCENT_3 = 0.03;
	public static final double BRACKET_PERCENT_2 = 0.02;
	public static final double BRACKET_PERCENT_1 = 0.01;
	
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
		int tax = 0;
		while(!prompt.hasNextInt()) {
			System.out.println("Please enter an integer amount of "
					+ "an approximated annual income.");
			prompt.next();
		}
		income = prompt.nextInt();
		int incomeMutated = 0;
		
		if(income > BRACKET_MAX_6) {
			tax += BRACKET_PERCENT_6 * (income - BRACKET_MAX_6 - incomeMutated);
			incomeMutated += income - BRACKET_MAX_6 - incomeMutated;
			System.out.println(tax);
		}
		if(income > BRACKET_MAX_5) {
			tax += BRACKET_PERCENT_5 * (income - BRACKET_MAX_5 - incomeMutated);
			incomeMutated += income - BRACKET_MAX_5 - incomeMutated;
			System.out.println(tax);
		}
		if(income > BRACKET_MAX_4) {
			tax += BRACKET_PERCENT_4 * (income - BRACKET_MAX_4 - incomeMutated);
			incomeMutated += income - BRACKET_MAX_4 - incomeMutated;
			System.out.println(tax);
		}
		if(income > BRACKET_MAX_3) {
			tax += BRACKET_PERCENT_3 * (income - BRACKET_MAX_3 - incomeMutated);
			incomeMutated += income - BRACKET_MAX_3 - incomeMutated;
			System.out.println(tax);
		}
		if(income > BRACKET_MAX_2) {
			tax += BRACKET_PERCENT_2 * (income - BRACKET_MAX_2 - incomeMutated);
			incomeMutated += income - BRACKET_MAX_2 - incomeMutated;
			System.out.println(tax);
		}
		if(income > BRACKET_MAX_1) {
			tax += BRACKET_PERCENT_1 * (income - BRACKET_MAX_1 - incomeMutated);
			incomeMutated += income - BRACKET_MAX_1 - incomeMutated;
			System.out.println(tax);
		}
		
		System.out.println("Your total tax is $"
				+ tax + " for your income of $"
				+ income + ".\nLove, the IRS.");
		
	}
}
