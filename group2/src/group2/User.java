package group2;

public class User {
	
	/**
	 * The ID.
	 */
	final String id;
	
	/**
	 * The password.
	 */
	String pass;
	
	/**
	 * A constructor for User.
	 * @param the_id, the id
	 * @param the_pass, the password
	 */
	public User(String the_id, String the_pass) {
		id = the_id;
		pass = the_pass;
	}
	
	/*
	public void startConference(){
		
	}*/
	
	public String getID() { 
		return id; 
	}
	
	public String getPass() { 
		return pass; 
	}

}
