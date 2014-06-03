package group2;

import java.util.HashMap;

public class UserManager {
	public HashMap<String, String> allUsers = new HashMap<String, String>();
	
	
	public boolean findID(String id, String pass) {
		if(allUsers.containsKey(id)) {
			if(allUsers.get(id).equals(pass)) return true;
		}
		return false;
	}
	
	public boolean signUp(String id, String pass) {
		if(allUsers.containsKey(id) || id.isEmpty() || pass.isEmpty()) return false;
		allUsers.put(id, pass);
		return true;
	}
}
