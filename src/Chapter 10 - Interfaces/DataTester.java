
public class DataTester implements Measurable {
	
	private double measure;
	
	public DataTester(double measure) {
		this.measure = measure;
	}
	
	public double getMeasure() {
		return measure;
	}
	
	public static void main(String[] args) {
		Measurable[] testObjects = {new DataTester(123.2), new DataTester(9012.3), new DataTester(-32.3)};
		System.out.println("Largest object has value: " + Data.max(testObjects).getMeasure());
	}
}
