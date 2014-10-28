/**
 * Product.java - represents a product.
 * So simple, my grandmother could have written this.
 * 
 * @author ethan.lee
 * @version 0.1
 */
public class Product {
	private String productName = "";
	private double price;
	
	public Product (String name, double price) {
		productName = name;
		this.price = price;
	}
	
	public String getName() {
		return productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void reducePrice(double discount) {
		price -= discount;
	}
}
