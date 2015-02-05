
public class CallingCard extends Card {
	private String cardNumber;
	private int pin;
	
	/*
	public CallingCard() {
		super();
	}
	
	public CallingCard(String name) {
		super(name);
	}*/
	
	public CallingCard(String name, String number, int pin) {
		super(name);
		this.cardNumber = number;
		this.pin = pin;
	}
	
	public String format() {
		return super.format() + "\nType: " 
				+ this.getClass().getName() + "\nCard Number: " + cardNumber 
				+ "\nPIN: " + pin + "\n****************************\n";
	}
}
