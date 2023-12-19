package sys;

import java.util.List;
import java.util.Scanner;

//Menu class is what interacts with the user and delegates which classes to process tasks
public class Menu {

	// Variables needed
	private User user;
	ProductFactoryConcrete productfactory = new ProductFactoryConcrete();
	private Authenticator authenticator;
	private Catalog catalog;
	private Cart cart;
	private Scanner scan;
	private boolean isAuthenticated;

	public Menu() {
		authenticator = new Authenticator();
		catalog = new Catalog(new ProductFactoryConcrete());
		cart = Cart.getInstance();
		scan = new Scanner(System.in);
		isAuthenticated = false;
	}

	public void displayMenu() {
		while (true) {

			// If user is not authenticated/signed up, display the signup/sign in screen
			if (!isAuthenticated) {
				System.out.println("");
				System.out.println("-------Shopping System-------");
				System.out.println("1. Sign Up");
				System.out.println("2. Log In");
				System.out.println("3. Exit");

				// Get user selection
				int choice = scan.nextInt();
				scan.nextLine();

				// Sign up
				if (choice == 1) {
					signUpScreen();

					// Login
				} else if (choice == 2) {
					isAuthenticated = authenticateUser();
					catalog.fillCatalog();

					// Exit
				} else if (choice == 3) {
					System.out.println("Exiting program.");
					return;

					// Invalid selection
				} else {
					System.out.println("Invalid selection. Please enter 1, 2, or 3");
				}
			} else {
				// If user is authenticated, display shopping menu
				System.out.println("");
				System.out.println("-------Main Menu -------");
				System.out.println("1. View catalog");
				System.out.println("2. Add product to cart");
				System.out.println("3. View cart");
				System.out.println("4. Checkout");
				System.out.println("5. View history");
				System.out.println("6. Logout");

				// Get user selection
				int option = scan.nextInt();
				scan.nextLine();

				// View the catalog
				if (option == 1) {
					System.out.println("");
					catalog.displayCatalog();

					// Add Product to cart
				} else if (option == 2) {

					// Get product name
					System.out.print("Enter product name to add to cart: ");
					String productName = scan.nextLine();

					// Check if product exists in catalog
					if (catalog.productExist(productName)) {

						// Create a duplicate product as this product will be the one added to the cart
						Product product = productfactory.createProduct(productName,
								catalog.getProductByName(productName).getPrice());

						// Add log for user
						user.getLogger().addLog("Product added to cart: " + productName);

						// Add the product
						if (product != null) {
							cart.addProduct(product);
							System.out.println("Product added to cart: " + productName);
						}

						// Product not found
					} else {
						System.out.println("Product not found");
					}

					// View cart
				} else if (option == 3) {
					System.out.println("");
					System.out.println("Current cart: ");
					cart.displayCartItems();
				}

				// Checkout and make a payment
				else if (option == 4) {
					displayCheckout();

					// View history
				} else if (option == 5) {
					displayUserHistory();

					// Logout
				} else if (option == 6) {
					isAuthenticated = false;
					System.out.println("Logged out successfully.");

					// Invalid option
				} else {
					System.out.println("Invalid option. Please try again.");
				}
			}
		}
	}

	// Displays checkout screen to user
	private void displayCheckout() {

		// Total of current cart
		double total = cart.getTotalPrice();
		System.out.println("Total: " + total);

		// Prompt for credit card information. Not stored, but need to pause program
		// here
		System.out.println("-----Payment Gateway-----");
		System.out.println("Enter your credit card number: ");
		String creditCardNumber = scan.nextLine();
		System.out.print("Enter your name: ");
		String name = scan.nextLine();

		// Make new payment
		System.out.println("");
		System.out.println("Processing payment: " + total);
		Payment payment = new Payment(total);
		payment.makePayment();

		// add payment to user history
		if (user != null) {
			user.getLogger().addLog("Payment of " + total + " made");
		}

		// Remove items form cart on successful payment
		cart.emptyCart();
	}

	// Display sign up directions
	private void signUpScreen() {
		System.out.println("");
		System.out.println("-------Sign up-------");
		System.out.print("Enter username: ");
		String username = scan.nextLine();
		System.out.print("Enter password: ");
		String password = scan.nextLine();
		System.out.println("");

		// Check if already registered
		boolean isRegistered = authenticator.signUpUser(username, password);
		if (isRegistered) {
			System.out.println("");
		} else {
			System.out.println("User already exists");
		}
	}

	// Display the user history
	private void displayUserHistory() {
		if (user != null) {
			System.out.println("");
			System.out.println("-------User history-------");

			// Get history from list
			List<String> logs = user.getLogger().getHistory();
			if (logs.isEmpty()) {
				System.out.println("No history found");
			} else {
				for (int i = 0; i < logs.size(); i++) {
					System.out.println(logs.get(i));
				}
			}
		} else {
			System.out.println("No history found");
		}
	}

	// Login Screen
	private boolean authenticateUser() {
		System.out.println("");
		System.out.println("-------Login-------");

		// Get user details
		System.out.print("Enter username: ");
		String username = scan.nextLine();
		System.out.print("Enter password: ");
		String password = scan.nextLine();

		// Authenticate user using the Authentication class
		user = authenticator.authenticate(username, password);
		if (user != null) {
			isAuthenticated = true;
		} else {
			isAuthenticated = false;
		}

		// Check if passed
		if (isAuthenticated) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed. Incorrect information");
		}
		return isAuthenticated;
	}
}