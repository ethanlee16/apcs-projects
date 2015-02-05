
public class CardTester {
	public static void main(String[] args) {
		
		IDCard id = new IDCard("Ethan Lee", Integer.toString(Integer.MAX_VALUE));
		DriverLicense dl = new DriverLicense("John Smith", "7402381", 2017);
		CallingCard cc = new CallingCard("Tim Cook", "4085555555", 1234);
		
		System.out.print(id.format() + "\n" + dl.format() + "\n" + cc.format());
	}
}
