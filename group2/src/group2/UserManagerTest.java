package group2;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class UserManagerTest {

	@Test
	public void testFindID() {
		UserManager now = new UserManager();
		User cur = new User("myuser", "jin");
		HashMap<String, User> findTable = new HashMap<String, User>();
		findTable.put(cur.getID(), cur);
		now.allUsers = findTable;
		assertEquals("same pass", now.findID("myuser").getPass(), "jin");
		assertNull("Null", now.findID("mako"));
	}

	@Test
	public void testSignUp() {
		UserManager now = new UserManager();
		HashMap<String, User> signTable = new HashMap<String, User>();
		User cur = new User("mysignup", "jung");
		now.allUsers = signTable;
		
	}
}