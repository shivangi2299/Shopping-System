package sys;

import java.util.HashMap;
import java.util.Map;

public class Authenticator {

	// List of Users that have successfully signed up. Contains usernames and
	// passwords
	private Map<String, String> users;

	public Map<String, String> getUsers() {
		return users;
	}

	public void setUsers(Map<String, String> users) {
		this.users = users;
	}

	public Authenticator() {
		users = new HashMap<>();
	}

	// Signup for a new user
	public boolean signUpUser(String username, String password) {
		if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
			System.out.println("INVALID username or password");
			return false;
		}

		// Check for existing username
		if (users.containsKey(username)) {
			System.out.println("Username exists, try again");
			return false;
		}

		// Add user to user lists
		users.put(username, password);
		return true;
	}

	// Authenticates user on login
	public User authenticate(String username, String password) {
		String pass = users.get(username);
		if (pass != null && pass.equals(password)) {
			System.out.println("Authentication passed");
			return new User(username, password);
		} else {
			System.out.println("Authentication failed");
			return null;
		}
	}
}