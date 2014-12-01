/**
 * DataSet.java - contains implementation for calculating
 * standard deviation and mean.
 * 
 * @author ethan.lee
 *
 */
import java.util.ArrayList;
public class DataSet {
	
	private double total;
	
	private ArrayList<Double> values;

	public DataSet() {
		total = 0;
		values = new ArrayList<Double>();
	}
	
	public DataSet(double[] values) {
		for(double v : values) {
			this.add(v);
		}
	}
	
	public void add(double value) {
		total += value;
		values.add(value);
	}
	
	public double getAverage() {
		return total / values.size();
	}
	
	public double getStandardDeviation() {
		// Actually using the first formula in
		// the book, since we are using ArrayLists.
		double avg = this.getAverage();
		double sum = 0;
		for(int i = 0; i < values.size(); i++) {
			sum += Math.pow(values.get(i) - avg, 2);
		}
		return Math.sqrt(sum / (values.size() - 1));
	}
	
}
