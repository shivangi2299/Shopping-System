package sys.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sys.Payment;

//Tests for Payment class
public class PaymentTest {

	private Payment payment;

	@Before
	public void setUp() {
		payment = new Payment(1);
	}

	@Test
	public void payAmountTest() {
		assertEquals(1, payment.getAmount(), 0);
	}

}
