package sys;

// Make a payment
public class Payment {
	private double amount;

	public Payment(double amount) {
		this.amount = amount;
	}

	// Make a payment. payment info is requested from the user
	public void makePayment() {
		System.out.println("Payment successful!");
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}