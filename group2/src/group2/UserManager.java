package group2;

import java.util.HashMap;

public class UserManager {
	HashMap<String, User> allUsers = new HashMap<String, User>();
	
	User findID(String id) {
		if(allUsers.containsKey(id)) {
			return allUsers.get(id);
		}
		return null;
	}
	
	boolean signUp(String id, String pass) {
		if(allUsers.containsKey(id)) return false;
		
		User cur = new User(id, pass);
		
		allUsers.put(id, cur);
		return true;
	}
}