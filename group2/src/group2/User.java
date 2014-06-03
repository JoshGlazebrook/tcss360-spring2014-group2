package group2;

/**
 * 
 * @author Anh Bui
 *
 */
public class User {
	
	/**
	 * The ID.
	 */
	final String userName;
	
	/**
	 * The password.
	 */
	final String password;
	
	String role = "User";
	
	/**
	 * A constructor for User.
	 * @param the_id, the id
	 * @param the_pass, the password
	 */
	public User(String theUserName, String thePassword) {
		userName = theUserName;
		password = thePassword;
	}
	
	/*
	public void startConference(){
		
	}*/
	
	public String getUserName() { 
		return userName; 
	}
	
	public String getPassword() { 
		return password; 
	}

}
