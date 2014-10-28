import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;

/**
 * <code>BankAccountTester.java</code> - began as a simple initialization for <code>BankAccount.</code> 
 * Now it's much more - including a functioning command line interface for an ATM.
 * 
 * <p><code>BankAccountTester</code> is really a standalone program written all into a
 * <code>main()</code> loop and delegates things account to <code>BankAccount</code> and
 * other private methods within itself. In the future it could be better than this and 
 * instead return an interface to other classes calling it. Extensibility, you know?</p>
 *  <ul>
 *  <li>Version 1.0 created a BankAccount and showed its values.</li>
 *  <li>Version 1.5 added a command-line interface to BankAccount and added support 
 *  for multiple, user-created accounts</li>
 *  <li>Version 1.5.1 fixes an infinite loop error</li>
 *  <li>Version 1.6 adds sending functionality</li>
 *  <li>Version 1.7 adds PIN code functionality</li>
 *  <li>Version 1.7.1 adds minor bug fixes and improvements</li>
 *  <li>Version 1.7.2 fixes multiple login exception error, amongst others</li>
 *  <li>Version 1.8 refactors a substantial amount of code for efficiency and adds
 *  Javadoc documentation. Also corrects dollar listing amount.</li>
 *  <li>Version 1.8.1 adds references to the new interest options in BankAccount.</li>
 *  </ul>
 *  
 *  @version 1.8.1
 *  @author ethan.lee
 *  
 * 
 **/
public class BankAccountTester {
	
	/** Scanner for console interface to BankAccount class. */
	private static Scanner prompt = new Scanner(System.in);
	
	/** Lists available commands this interface can handle. */ 
	private static final String AVAILABLE_CMDS
		= "[1]CREATE ACCOUNT [2]LOGIN [3]LOGOUT"
		+ " [4]DEPOSIT [5]WITHDRAW [6]SEND"
		+ " [7]LIST ACCOUNTS [8]ACCOUNT SUMMARY"
		+ " [9]APPLY INTEREST [10]EXIT";
	
	/** Stores instances of BankAccount for a single run. */
	private static List<BankAccount> accounts
		= new ArrayList<BankAccount>();
	
	/** 
	 * loggedAcct indicates which account is currently logged in.
	 *  -1 indicates that no account is currently logged in. 
	 */
	private static int loggedAcct = -1; 
	
	public static void main(String[] args){
		
		//
		// This part of the class represents the actual requirements of the assignment.
		//
		// Everything below where indicated is part of the ATM command-line interface
		// used to create new accounts and deposit/withdraw, etc.
		//
		// NOTE: not required for Project 3.9
		//
		
		/*
		double iPhoneARV = 199.99;
		double salary = 3000;
		double savingsInterest = 2.25;
		int monthsOwned = 4;
		int setPIN = 1111;
		
		BankAccount primary
			= new BankAccount(salary * monthsOwned, "<<Test Account Name>>", savingsInterest, setPIN);
		
		primary.doAuth(1111);
		primary.withdraw(iPhoneARV); 
		primary.deposit(salary);
		primary.addInterest(savingsInterest);
		
		System.out.println("Expected: "
				+ toCurrency.format(((salary * monthsOwned) - iPhoneARV + salary) * (savingsInterest/100 + 1)));
		System.out.println("Actual: " + toCurrency.format(primary.getBalance())
				+ " (this will be properly rounded)");
		*/
		
		//
		// END - assignment requirements
		//
		// BEGIN - atm-cli-1.8.1
		//
		
		NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
		System.out.println("Loading command line interface for ATM.\n\n"
				+ "Success. Entering interactive mode.");
		boolean isRunning = true;
		
		// Test accounts. For demonstration purposes. Later this
		// may not be necessary if we incorporate File I/O.
		
		accounts.add(new BankAccount(889.17, "John Smith", 1.155, 1000));
		accounts.add(new BankAccount(9263.12, "Julius Caesar", 9.001, 7777));
		accounts.add(new BankAccount(12.43, "Ethan Lee", 0, 1337));
		
		while(isRunning) {
			System.out.println("\nPlease select a command:" + AVAILABLE_CMDS);
			
			if (loggedAcct >= 0) {
				System.out.println("Currently logged into account for "
					+ accounts.get(loggedAcct).accountID + ".");
			}
			int cmd;
			while (!prompt.hasNextInt()){
				prompt.next();
				System.out.println("Error - invalid command received. Try again.");
			}
			cmd = prompt.nextInt();
			
			switch (cmd) {
			case 1:
				setupAccount();
				break;
			case 2:
				selectAccount();
				break;
			case 3:
				if (loggedAcct != -1) {
					accounts.get(loggedAcct).voidAuth();
					loggedAcct = -1;
					System.out.println("Logged out.");
				} else {
					System.out.println("Can't logout of nothing!");
				}
				break;
			case 4:
				if (loggedAcct >= 0) {
					System.out.println("Please enter an amount to deposit.");
					double amount = prompt.nextDouble();
					accounts.get(loggedAcct).deposit(amount);
					System.out.println("Successfully deposited "
						+ toCurrency.format(amount) + "!");
				} else {
					System.out.println("Cannot complete action,"
							+ "you are not logged into an account.");
				}
				break;
			case 5:
				if (loggedAcct >= 0) {
					System.out.println("Please enter an amount to withdraw.");
					double amount = prompt.nextDouble();
					accounts.get(loggedAcct).withdraw(amount);
					System.out.println("Withdrew " + toCurrency.format(amount) + "!");
				} else {
					System.out.println("Cannot complete action,"
							+ " you are not logged into an account.");
				}
				break;
			case 6:
				if (loggedAcct >= 0) {
					System.out.println("Please enter an amount to send from \""
							+ accounts.get(loggedAcct).accountID + "\"");
					double amount = prompt.nextDouble();
					System.out.println("Please choose an account to send to.");
					for (int i = 0; i < accounts.size(); i++) {
						if (i != loggedAcct) {
							System.out.println("[" + i + "]" + accounts.get(i).accountID);
						}
					}
					int recipientID = prompt.nextInt();
					accounts.get(loggedAcct).send(accounts.get(recipientID), amount);
					System.out.println("Successfully sent money.");
				} else {
					System.out.println("Cannot complete action,"
							+ " you are not logged into an account.");
				}
				break;
			case 7:
				for(int i = 0; i < accounts.size(); i++) {
					System.out.println(accounts.get(i).toString());
				}
				break;
			case 8:
				if (loggedAcct >= 0) {
					System.out.println(accounts.get(loggedAcct).toString());
				} else {
					System.out.println("Cannot complete action,"
							+ " you are not logged into an account.");
				}
				break;
			case 9:
				if (loggedAcct >= 0) {
					accounts.get(loggedAcct).deductMonthlyCharge();
				} else {
					System.out.println("Cannot complete action,"
							+ " you are not logged into an account.");
				}
				break;
			case 10:
				isRunning = false;
				break;
				
			}
		}
		System.out.println("Goodbye!");
	}
	
	/** 
	 * Takes user through a series of steps inside of the console to start a new instance
	 * of BankAccount with all of the proper parameters. Adds to the accounts List at 
	 * the end.
	 */ 
	private static void setupAccount() {
		System.out.println("Confirm new account? [Y/n]"); prompt.nextLine();
		String response = prompt.nextLine();
		while(!response.toLowerCase().equals("y")) {
			System.out.println("Cancelling...");
			return;
		}
		
		System.out.println("Please put in the name of the primary account holder for this account.");
		String name = prompt.nextLine();
		
		System.out.println("Please put in the amount of free money"
				+ " you would like with the account for \"" + name + "\"");
		
		double initialValue;
		while (!prompt.hasNextDouble() || !prompt.hasNext("[0-9]+(\\.[0-9][0-9]?)?")) {
			prompt.next();	
			System.out.println("Error - requires a *dollar value* at least zero. Try again.");
		}
		initialValue = prompt.nextDouble();
		
		double rate;
		System.out.println("Please enter your desired interest rate."
				+ " If you do not want an interest rate, type 0.");

		while (!prompt.hasNextDouble() || !prompt.hasNext("[0-9]+(\\.[0-9]*)?")) {
			prompt.next();
			System.out.println("Error - requires a number value above zero. Try again.");
		}
		rate = prompt.nextDouble();
		
		int pin;
		System.out.println("Please enter a PIN code you will use to transact on your bank account.");
		while (!prompt.hasNextInt() || !prompt.hasNext("[0-9]+")){
			prompt.next();
			System.out.println("Error - requires a number above zero. Try again.");
		}
		pin = prompt.nextInt(); 

		System.out.println("Creating your bank account...");
		BankAccount b = new BankAccount(initialValue, name, rate, pin);
		System.out.println("Created successfully. Printing details...\n\n"
				+ b.toString());
		accounts.add(b);
	}
	
	/** Called to start the login interface for BankAccountTester. */
	private static void selectAccount(){
		
		if (loggedAcct == -1) {
			System.out.println("Please enter which account you would like to login to: ");
			for(int i = 0; i < accounts.size(); i++) {
				System.out.print("\t[" + i + "] " + accounts.get(i).accountID + "\n");
			}
			int intent = prompt.nextInt();
			if (intent <= (accounts.size() - 1) && intent >= 0) {
				loggedAcct = intent;
			
				if (authenticate()) {
					System.out.println("Logged in successfully.");
				}
				else {
					System.out.println("Login failed.");
					loggedAcct = -1;
				}
			}
			else { 
				System.out.println("Account does not exist, exiting..."); return;
			}
		}
		else {
			System.out.println("Multiple accounts are not supported yet."
					+ "Please logout before you login again.");
		}
	}
	
	/**
	 *  Called to start the authentication interface for BankAccountTester.
	 *  Returns <code>true</code> if authentication was successful.
	 */
	private static boolean authenticate() {
		System.out.println("Please enter your PIN code which you created during setup.");
		int challenge = prompt.nextInt();
		if (accounts.get(loggedAcct).doAuth(challenge)) {
			return true;
		}
		else {
			return false;
		}
	}

}
