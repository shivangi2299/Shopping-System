package sys.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sys.User;

//Tests for User class
public class UserTest {

	private User user;

	@Before
	public void setUp() {
		user = new User("user", "1234");
	}

	@Test
	public void userNameTest() {
		assertEquals("user", user.getName());
	}

	@Test
	public void passwordTest() {
		assertEquals("1234", user.getPassword());
	}
}
