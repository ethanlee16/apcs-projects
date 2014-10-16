import java.text.NumberFormat;

/**
 * <code>BankAccount.java</code> - stores balances, allows deposits/withdraws.
 * <p><code>BankAccount</code> can be called by the following:
 * <ul><li><code>BankAccount b = new BankAccount();</code></li>
 * <li><code>BankAccount c = new BankAccount(2342.12);</code></li>
 * <li><code>BankAccount d = new BankAccount(2342.12, "Ethan Lee", 2.25, 1234);</code></li>
 * </ul>
 * </p><p>These parameters are explained below.</p>
 * 
 * @version 1.6
 * @author ethan.lee
 *
 */
public class BankAccount {
	
	/** Stores the balance for a BankAccount, in a double format. */
	protected double balance;
	
	/** Stores the interest for a BankAccount, in a double format. */
	protected double interest;
	
	/** 
	 * Stores an integer PIN number for a BankAccount. Although
	 * it can be called directly by a negative integer, the BankAccount
	 * command line interface prevents this. It is generally considered
	 * bad practices to have a negative PIN number.  
	 */
	protected int pinNumber;
	
	/** Used for authentication, indicates if account is
	 *  open to transactions or not. */ 
	protected boolean transactOn = false;
	
	protected int numTransactions;
	protected final double BANK_FEE = 3.0;
	protected final int MAX_FREE_TRANSACTIONS = 10;
	
	/** Used to printout money values in the correct locale format. */
	private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(); 
	
	/** A misnomer, really - only holds the name of the account holder.
	 *  Public scope so that other classes can access this for login. */
	public String accountID;

	/**　
	 * Constructs a new BankAccount with an empty balance. Name, rate, and PIN
	 * are not set and authentication will fail.
	 */
	public BankAccount() {
		balance = 0;
	}
	/** Constructs a BankAccount with only an initial balance. */
	public BankAccount(double initial) {
		balance = initial;
	}
	
	/** Constructs a new BankAccount with all set parameters. */
	public BankAccount(double initial, String name, double rate, int pin) {
		balance = initial;
		accountID = name;
		interest = rate;
		pinNumber = pin;
	}
	
	/** Checks PIN authentication.
	 *  @param challenge the attempted PIN */
	public boolean doAuth(int challenge) {
		if (challenge == pinNumber) {
			transactOn = true;
			return true;
		}
		else {
			System.out.println("Authentication failed.");
			return false;
		}
	}
	
	/** Disables transaction sending, essentially logging out. */
	public void voidAuth() {
		transactOn = false;
	}
	
	/** Deposits a certain amount into the current account if 
	 *  logged in.
	 *  @param amount the amount to be deposited */
	public void deposit(double amount) {
		if (transactOn) {
			balance += amount;
			numTransactions++;
		}
		else {
			System.out.println("This action requires authentication.");
		}
	}
	
	/** Withdraws a certain amount if logged in.
	 *  @param amount the amount to be withdrawn */
	public void withdraw(double amount){
		if (transactOn) {
			if(balance >= amount){
				balance -= amount;
				numTransactions++;
			}
			else {
				System.out.println("Insufficient balance.");
			}
		}
		else {
			System.out.println("This action requires authentication.");
		}
	}
	
	/** Calculates and deducts the monthly charge from the current bank account. */
	public void deductMonthlyCharge() {
		double currentFees;
		if (numTransactions > MAX_FREE_TRANSACTIONS) {
			currentFees = (MAX_FREE_TRANSACTIONS - numTransactions) * BANK_FEE;
		} else {
			currentFees = 0;
		}
		System.out.println("Charged "  + currencyFormat.format(currentFees)
				+ " for monthly bank fees at " + currencyFormat.format(BANK_FEE) +
				" per transaction over " + MAX_FREE_TRANSACTIONS + ".");
		numTransactions = 0;
	}
	
	/** Sends a certain amount from one account (implicit) to another.
	 *  @param recipient the BankAccount receiving the money
	 *  @param amount the amount to be sent */
	public void send(BankAccount recipient, double amount) {
		this.withdraw(amount);
		recipient.balance += amount;
	}
	
	/** Applies a certain interest rate and adds it to the balance.
	 *  @param percentageRate the rate of interest to be calculated in */
	public void addInterest(double percentageRate){
		balance = balance * (percentageRate/100.0 + 1);
	}
	
	/** Returns the balance for an account. */
	public double getBalance() {
		return balance;
	}
	
	/** Returns a summary of the account when called via toString(),
	 *  overrides default Object toString() method. */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("*******************\n");
		str.append("SUMMARY FOR ACCOUNT: " + accountID + "\n");
		str.append("Current Posted Balance: " + 
				currencyFormat.format(this.getBalance()) + "\n");
		
		// str.append("Transaction History: ");
		// COMING SOON
		str.append("Interest Rate: " + interest + "%\n");
		str.append("*******************\n");
		return str.toString();
	}
}