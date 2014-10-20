/**
 * Bookstore.java -simulates bookstore operations
 * @author - ethan.lee
 */
import java.util.Scanner;
import java.text.NumberFormat;

public class Bookstore {
	private static Scanner prompt = new Scanner(System.in);
	private static NumberFormat toDollars = NumberFormat.getCurrencyInstance();
	
	public static void main(String[] args) {
		
		//TODO: validate user input
		System.out.println("Enter the total cost of your books.");
		double bookCost = prompt.nextDouble();
		System.out.println("Enter the number of books purchased.");
		int bookNum = prompt.nextInt();
		
		bookCost = 1.075 * bookCost; //sales tax applied
		bookCost += bookNum * 2; //shipping charge
		System.out.println("The total cost, with shipping and tax, is: " + toDollars.format(bookCost));
	}
}
