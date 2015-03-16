
public class Quiz implements Measurable {
	
	private double grade;
	
	public Quiz(double grade) {
		this.grade = grade;
	}
	
	public String getLetterGrade() {
		
		// goes by the SMCHS grading scale,
		// rounded to nearest integer
		if(grade >= 98.5) {
			return "A+";
		} else if(grade >= 91.5) {
			return "A";
		} else if(grade >= 89.5) {
			return "A-";
		} else if(grade >= 87.5) {
			return "B+";
		} else if(grade >= 81.5) {
			return "B";
		} else if(grade >= 79.5) {
			return "B-";
		} else if(grade >= 77.5) {
			return "C+";
		} else if(grade >= 71.5) {
			return "C";
		} else if(grade >= 69.5) {
			return "C-";
		} else if(grade >= 67.5) {
			return "D+";
		} else if(grade >= 61.5) {
			return "D";
		} else if(grade >= 59.5) {
			return "D-";
		} else {
			return "F";
		}
		
	}
	
	public double getMeasure() {
		return grade;
	}
	
}
