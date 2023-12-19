package sys;
public class User {
	private String name;
	private String password;
	private Logger log;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
		this.log = new Logger();
	}

	// Getters/Setters
	public Logger getLogger() {
		return log;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
