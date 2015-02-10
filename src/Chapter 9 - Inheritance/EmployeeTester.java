
public class EmployeeTester {
	public static void main(String[] args) {
		Employee e = new Employee("John Smith", 50000);
		Manager m = new Manager("Bill Smith", "Accounting/Finance", 55000);
		Executive ex = new Executive("Tim Cook", "Executive/Board", "CEO", 4300000);
		
		System.out.println(e.toString() + "\n");
		System.out.println(m.toString() + "\n");
		System.out.println(ex.toString() + "\n");
	}
}
