
public class DriverLicense extends IDCard {
	
	private int expirationYear;
	
	/*
	public DriverLicense() {
		super();
	}
	
	public DriverLicense(String name) {
		super(name);
	}*/
	
	public DriverLicense(String name, String id, int expirationYear) {
		super(name, id);
		this.expirationYear = expirationYear;
	}
	
	public String format() {
		return super.format().substring(0, super.format().length() - 30) + "\nExpiration Year: " 
				+ expirationYear + "\n****************************\n";
	}
	
}
