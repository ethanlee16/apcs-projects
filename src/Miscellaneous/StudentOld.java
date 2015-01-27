
public class StudentOld {
	
	private String name;
	private int quizCount;
	private int scoreSum;
	
	public StudentOld(String name) {
		this.name = name;
		quizCount = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScoreSum() {
		return scoreSum;
	}
	
	public double averageScore() {
		return (scoreSum + 1.0) / quizCount;
	}
	
	public void addScore(int score) {
		scoreSum += score;
		quizCount++;
	}
	
	public String toString() {
		return name + "\nNumber of quizzes taken: " + quizCount + "\nTotal sum of quiz scores: " + scoreSum;
	}
}

