package test;

import static org.junit.Assert.*;
import group2.UserManager;

import java.util.HashMap;

import org.junit.Test;

public class UserManagerTest {

	@Test
	public void testFindID() {
		UserManager now = new UserManager();
		HashMap<String, String> findTable = new HashMap<String, String>();
		findTable.put("myuser", "jin");
		now.allUsers = findTable;
		assertTrue("Got the user",now.findID("myuser", "jin"));
		assertFalse("Wrong username", now.findID("id", "jin"));
		assertFalse("Wrong password", now.findID("myuser", "pass"));
	}

	@Test
	public void testSignUp() {
		UserManager now = new UserManager();
		HashMap<String, String> signTable = new HashMap<String, String>();
		signTable.put("myuser", "jin");
		now.allUsers = signTable;
		assertFalse("Existed username", now.signUp("myuser", "jung"));
		assertFalse("Empty username", now.signUp("", "jin"));
		assertFalse("Empty password", now.signUp("myId", ""));
		assertTrue("Success", now.signUp("myID", "jin"));
	}
}
