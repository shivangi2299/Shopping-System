package sys;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

	// The list of available products
	private List<Product> products;
	private IProductFactory productFactory;

	public Catalog(IProductFactory productFactory) {
		this.products = new ArrayList<>();
		this.productFactory = productFactory;
	}

	// Checks if the product exists when given the product name.
	public boolean productExist(String name) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	// Displays the list of products in the catalog.
	public void displayCatalog() {
		for (int i = 0; i < products.size(); i++) {
			products.get(i).displayInfo();
		}
	}

	// Allows retrieval of the product when the user adds it to the cart.
	public Product getProductByName(String name) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}

	// Populate the catalog with Products.
	public void fillCatalog() {
		addProductNotPresent(productFactory.createProduct("tv", 100));
		addProductNotPresent(productFactory.createProduct("car", 1000));
		addProductNotPresent(productFactory.createProduct("boat", 10000));
		addProductNotPresent(productFactory.createProduct("house", 100000));
		addProductNotPresent(productFactory.createProduct("dog", 550));
		addProductNotPresent(productFactory.createProduct("cat", 255));
		addProductNotPresent(productFactory.createProduct("food", 9));
	}

	// Added this helper because was having issues when more than 1 sign up occurred
	// catalog list was adding same products.
	private void addProductNotPresent(Product product) {
		if (!productExist(product.getName())) {
			addProduct(product);
		}
	}

	// Adds a product to the catalog.
	public void addProduct(Product product) {
		products.add(product);
	}

	// Getters/Setters
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
