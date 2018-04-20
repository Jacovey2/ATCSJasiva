
public class User {
	private String firstName = "";
	private String lastName = "";
	private String username = "";
	private String password = "";


	public User(String first, String last, String user, String pass) { // constructs objects
		firstName = first;
		lastName = last;
		username = user;
		password = pass;
		
	}

	public String getFirstName() { // getter methods to get variables
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
