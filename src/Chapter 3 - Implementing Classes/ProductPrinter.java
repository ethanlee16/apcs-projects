/**
 * ProductPrinter.java - interfaces with <code>Product</code class.
 * 
 * @author ethan.lee
 * @version 0.1
 *
 */
public class ProductPrinter {
	
	public static void main(String[] args) {
		
		System.out.println("--- PRODUCT LISTINGS ---");
		Product product1 = new Product("Cereal", 9.99);
		Product product2 = new Product("Bacon", 7.99);
		
		System.out.println("* " + product1.getName() + " / " + product1.getPrice());
		System.out.println("* " + product2.getName() + " / " + product2.getPrice());
		
		product1.reducePrice(5);
		product2.reducePrice(5);
		
		System.out.println("--- PRODUCT LISTINGS AFTER DISCOUNT ---");
		System.out.println("* " + product1.getName() + " / " + product1.getPrice());
		System.out.println("* " + product2.getName() + " / " + product2.getPrice());
		
	}

}
