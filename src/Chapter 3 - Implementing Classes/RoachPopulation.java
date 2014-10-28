/**
 * RoachPopulation.java - what even
 * 
 * @author ethan.lee
 * @version 0.1
 *
 */
public class RoachPopulation {
	private int count;
	public RoachPopulation(int initial) {
		count = initial;
	}
	
	public void breed() {
		count *= 2;
	}
	
	public void spray(double percent) {
		count -= percent * count;
	}
	
	public int getRoaches() {
		return count;
	}
}
