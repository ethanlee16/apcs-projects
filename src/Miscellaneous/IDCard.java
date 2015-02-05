
public class IDCard extends Card {
	
	private String idNumber;
	
	/* extra methods...
	public IDCard() {
		super();
	}
	
	public IDCard(String name) {
		super(name);
	}*/
	
	public IDCard(String name, String id) {
		super(name);
		this.idNumber = id;
	}
	
	public String format() {
		return super.format() + "\nType: "
				+ this.getClass().getName() + "\nID: " + idNumber 
				+ "\n****************************\n";
	}
}
