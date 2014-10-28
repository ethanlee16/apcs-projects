/**
 * CarTester.java - tests the Car.
 * @author ethan.lee
 * @version 0.1
 * 
 */
public class CarTester {
	public static void main(String[] args) {
		Car c = new Car(24);
		c.addGas(20);
		c.drive(153);
		System.out.println("Gas after 153 miles: " + c.getGasInTank() + " gallons.");
	}
}
