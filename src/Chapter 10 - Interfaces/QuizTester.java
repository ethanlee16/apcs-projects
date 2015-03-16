
public class QuizTester {
	public static void main(String[] args) {
		Measurable[] quizzes = {new Quiz(58), new Quiz(95), new Quiz(80.2), new Quiz(92.3)};
		double average = Data.average(quizzes);
		Measurable max = Data.max(quizzes);
		System.out.println("Average score of quizzes: " 
				+ Data.average(quizzes) + " | " + new Quiz(average).getLetterGrade());
		System.out.println("Highest score: " 
				+ max.getMeasure() + " | " + ((Quiz) max).getLetterGrade());
	}
}
