package sys.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sys.Product;

//Tests for Product class
public class ProductTest {

	private Product product;

	@Before
	public void setUp() {
		product = new Product("test", 1);
	}

	@Test
	public void nameTest() {
		assertEquals("test", product.getName());
		product.setName("test2");
		assertEquals("test2", product.getName());
	}

	@Test
	public void priceTest() {
		assertEquals(1, product.getPrice(), 0);
		product.setPrice(2);
		assertEquals(2, product.getPrice(), 0);
	}
}
