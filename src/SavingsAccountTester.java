import java.text.NumberFormat;

public class SavingsAccountTester {
	public static void main (String[] args) {
		NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
		SavingsAccount s = new SavingsAccount(1000, 10);
		s.addInterest();
		
		System.out.println("Expected: $" + 1000.0 * (10.0 / 100.0 + 1.0));
		System.out.println("Result: " + toCurrency.format(s.balance));
	}
}
