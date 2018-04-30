
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
	public String toString() {
		String redactedPassword="";
		if (password.length()>3) {
			redactedPassword="";
			redactedPassword+=password.substring(0,1);
			for (int i=1; i<password.length()-1; i++) {
				redactedPassword+="*";
			}
			redactedPassword+=password.substring(password.length()-2,password.length()-1);
		}
		else {
			for (int i=1; i<password.length(); i++) {
				redactedPassword+="*";
			}
		}
		return firstName+" "+lastName +": "+username +", "+redactedPassword;
	}
}
