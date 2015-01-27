/**
 * Student.java
 * @author ethan.lee
 *
 */
public class Student {
	
	private String name = "";
	private double[] scores;
	
	public Student() {
		this.name = null;
		scores = null;
	}
	
	public Student(String name) {
		this.name = name;
		scores = null;
	}
	
	public Student(String name, double[] quizScores) {
		this.name = name;
		scores = quizScores;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScores(double[] quizScores) {
		scores = quizScores;
	}
	
	public double getAverage() {
		double sum = 0;
		int count = 0;
		
		for(double score : scores) {
			sum += score;
			count++;
		}
		
		return sum / count;
	}
	
}
