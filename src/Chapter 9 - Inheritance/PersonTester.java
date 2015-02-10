
public class PersonTester {
	public static void main(String[] args) {
		Person p = new Person("John Smith", 1989);
		Pupil pupil = new Pupil("Ethan Lee", "Computer Science", 1998);
		Instructor i = new Instructor("Albert Lee", Integer.MAX_VALUE, 1999);
		
		System.out.println(p.toString() + "\n");
		System.out.println(pupil.toString() + "\n");
		System.out.println(i.toString() + "\n");
	}
}
