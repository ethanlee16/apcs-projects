/**
 * <code>SavingsAccount.java</code> - an extension of <code>BankAccount</code>
 *  that includes new ways to store, modify, and access interest. 
 *  
 * <p>Note that <code>SavingsAccount</code>, unlike <code>BankAccount </code>
 * can be called up like <code>SavingsAccount s = new SavingsAccount(1521.23, "Ethan", 2.23);
 * </code> with the interest rate as part of the constructor.</p>
 * 
 * @author ethan.lee
 * @version 1.0
 */
public class SavingsAccount extends BankAccount {
	
	// Note that the BankAccount class already had a field for interest.
	// This was not extraneous, but because the command line interface
	// needed to instantiate a new BankAccount with an interest field.
	
	public SavingsAccount(){
		balance = 0;
	}
	
	public SavingsAccount(double initial, double rate) {
		balance = initial;
		interest = rate;
	}
	
	public SavingsAccount(double initial, double rate, int pin) {
		balance = initial;
		accountID = "Unset Account Name";
		interest = rate;
		pinNumber = pin;
	}
	
	public SavingsAccount(double initial, String name, double rate, int pin) {
		balance = initial;
		accountID = name;
		interest = rate;
		pinNumber = pin;
	}
	
	public void addInterest() {
		balance *= interest/100.0 + 1;
	}
}