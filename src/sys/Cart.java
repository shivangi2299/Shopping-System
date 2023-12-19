package sys;
import java.util.ArrayList;
import java.util.List;

//Singleton class
public class Cart {

	// Single instance of Cart as requested in project
	private static Cart instance;

	// List of Products
	private List<Product> products;

	// Private because singleton
	private Cart() {
		products = new ArrayList<>();
	}

	// Static method to get the instance of the class
	public static Cart getInstance() {
		if (instance == null) {
			instance = new Cart();
		}
		return instance;
	}

	// Add a Product to the cart
	public void addProduct(Product product) {
		products.add(product);
	}

	// Get total price of products in cart
	public double getTotalPrice() {
		double totalPrice = 0.0;
		for (int i = 0; i < products.size(); i++) {
			totalPrice += products.get(i).getPrice();
		}
		return totalPrice;
	}

	// Display product details of cart items
	public void displayCartItems() {
		for (int i = 0; i < products.size(); i++) {
			products.get(i).displayInfo();
		}
	}

	// Remove the products in the cart
	public void emptyCart() {
		products.clear();
	}
}
