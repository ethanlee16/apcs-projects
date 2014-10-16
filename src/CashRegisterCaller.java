
public class CashRegisterCaller {
	
	public static void main(String[] args) {
		
		CashRegister c = new CashRegister();
		
		c.recordTaxablePurchase(23.12);
		c.recordPurchase(34.12);
		c.recordTaxablePurchase(15.23);
		
		c.receivePayment(100);
		
		c.printReceipt();
		
	}
}
