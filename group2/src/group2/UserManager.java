package group2;

import java.awt.Window.Type;
import java.util.HashMap;

import com.google.gson.*;

/**
 * @author Anh Bui
 */
public class UserManager {
	public HashMap<String, String> allUsers = new HashMap<String, String>();
	
	public UserManager() {
		loadUsers();
	}
	
	public boolean findID(String id, String pass) {
		if(allUsers.containsKey(id)) {
			if(allUsers.get(id).equals(pass)) return true;
		}
		return false;
	}
	
	public boolean signUp(String id, String pass) {
		if(allUsers.containsKey(id) || id.isEmpty() || pass.isEmpty()) return false;
		allUsers.put(id, pass);
		saveUsers();
		return true;
	}
	
	/**
	 * Loads all Users from the persistent data file.
	 */
	private void loadUsers() {
		HashMap<String, String> result;
		result = JSONHelper.deserializeFromFile("data/users/users.json", new HashMap<String, String>().getClass());
		if (result != null)
			allUsers = result;
	}
	
	/**
	 * Saves all Users to the persistent data file.
	 */
	private void saveUsers() {
		JSONHelper.serializeToFile("data/users/users.json", allUsers);
	}
}
