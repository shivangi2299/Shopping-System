package sys.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import sys.Authenticator;
import sys.User;

//Tests for Authenticator class
public class AuthenticatorTest {

	private Authenticator authenticator;

	@Before
	public void setUp() {
		authenticator = new Authenticator();
	}

	@Test
	public void signUpUserTest() {
		boolean result = authenticator.signUpUser("Jacob", "1234");
		assertTrue(result);
	}

	@Test
	public void authenticateTest() {
		authenticator.signUpUser("jake", "yes");
		User user = authenticator.authenticate("jake", "yes");
		assertNotNull(user);
	}

	@Test
	public void invalidTest() {
		authenticator.signUpUser("jones", "asdf");
		User user = authenticator.authenticate("jones", "123456");
		assertNull(user);
	}

}
