/**
 * FactorGenerator.java - generates the prime factors
 * for a number.
 * 
 * @author ethan.lee
 *
 */
public class FactorGenerator {
	
	public int number;
	private int factor = 2;
	
	public FactorGenerator(int number) {
		this.number = number;
	}
	
	// Probably should generate all the factors
	// upon initialization and add it to a global
	// InputStream for a Scanner to handle.
	
	// TODO: implement algorithm to feed primes
	// instead of every number less than itself.
	
	public int nextFactor() {
		int retval = 0;
		while(retval == 0) {
			if(number % factor == 0) {
				number /= factor;
				retval = factor;
			}
			else {
				factor++;
			}
		}
		return retval;
	}
	
	public boolean hasMoreFactors() {
		if(factor > number) {
			return false;
		}
		else {
			return true;
		}
	}
}
