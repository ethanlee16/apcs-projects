/**
 * Battery.java - charges.
 * 
 * @author ethan.lee
 *
 */
public class Battery {
	private double capacity;
	private double currentCharge;
	
	public Battery(double charge) {
		capacity = charge;
		currentCharge = capacity;
	}
	
	public void drain(double amount) {
		if(currentCharge < amount) {
			currentCharge = 0;
			System.out.println("Time for a recharge!");
		} else {
			currentCharge -= amount;
		}
	}
	
	public void charge(){
		currentCharge = capacity;
	}
	
	public double getRemainingCapacity() {
		return currentCharge;
	}
}
