import java.text.NumberFormat;

/**
 * CashRegister.java - simple thing that charges for items,
 * receives moola, and prints receipts. 
 * 
 * @author ethan.lee
 * @version 0.6
 * 
 */
public class CashRegister {
	private double purchase;
	private double payment;
	private double taxCollected;
	private final double SALES_TAX = 8.75;
	private String receipt = "=====RECEIPT======\n\n";
	private NumberFormat toDollars = NumberFormat.getCurrencyInstance();
	
	/** Constructs an empty new CashRegister. */
	public CashRegister () {
		purchase = 0;
		payment = 0;
	}
	
	public void recordPurchase(double amount) {
		purchase += amount;
		receipt += "* " + toDollars.format(amount) + "\n";
	}
	
	public void recordTaxablePurchase(double amount) {
		purchase += amount;
		taxCollected += (SALES_TAX / 100) * amount;
		receipt += "* " + toDollars.format(amount) + " - taxed\n";
	}
	
	public void receivePayment(double amount) {
		payment += amount;
	}
	
	public void printReceipt() {
		receipt += "\nSUBTOTAL: " + toDollars.format(purchase) + "\n";
		receipt += "SALES TAX (" + SALES_TAX + "%): " + toDollars.format(taxCollected) + "\n\n";
		receipt += "TOTAL: " + toDollars.format(purchase + taxCollected) + "\n";
		receipt += "AMOUNT TENDERED: " + toDollars.format(payment) + "\n";
		receipt += "CHANGE DUE: " + toDollars.format(this.giveChange()) + "\n";
		receipt += "=================";
		System.out.println(receipt);
	}
	
	public double giveChange() {
		double change;
		if (payment <= purchase + taxCollected) {
			change = 0;
		}
		else {
			change = payment - (purchase + taxCollected);
		}
		purchase = 0;
		payment = 0;
		return change;
	}
}
