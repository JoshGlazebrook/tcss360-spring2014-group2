package group2;

import java.util.HashMap;

public class UserManager {
	HashMap<String, String> allUsers = new HashMap<String, String>();
	
	
	
	String findID(String id) {
		if(allUsers.containsKey(id)) {
			return allUsers.get(id);
		}
		return null;
	}
	
	boolean signUp(String id, String pass) {
		if(allUsers.containsKey(id)) return false;
		allUsers.put(id, pass);
		return true;
	}
}