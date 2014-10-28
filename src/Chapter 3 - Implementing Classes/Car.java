/**
 * Car.java - simulates car functions and properties.
 * @author ethan.lee
 *
 */
public class Car {
	private double mpg;
	private double gas;
	
	public Car(double efficiency) {
		mpg = efficiency;
	}
	
	public void addGas(double amount) {
		gas += amount;
	}
	
	public double getGasInTank() {
		return gas;
	}
	
	public void drive(double amount) {
		gas -= (1 / mpg) * amount;
	}
}
