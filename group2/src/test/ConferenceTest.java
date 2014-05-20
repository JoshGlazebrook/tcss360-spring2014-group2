package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import group2.Conference;
import group2.User;

import org.junit.Test;

/**
 * Test for Conference class. 
 * @author Jugbir Singh - Jay 
 * @version 19 May, 2014
 */
public class ConferenceTest {
	User user = new User("Jay", "tcss360");
	Conference conf = new Conference(user, "May 17", "May 19");
	
	@Test
	public void testConference() {
		
	}

	/*
	@Test
	public void testCheckPaperExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckIfReviewed() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testGetProgramChair() {
		assertEquals(user, conf.getProgramChair());
	}

	@Test
	public void testGetDate() {
		assertEquals("May 17", conf.getDate());
	}

	@Test
	public void testGetDeadline() {
		assertEquals("May 19", conf.getDeadline());
	}

	@Test
	public void testGetUsers() {
		List<User> list = conf.getUsers();
		assertSame(list, conf.getUsers());
	}
	
	@Test
	public void testGetPapers() {
		List<Paper> list = conf.getPapers();
		assertSame(list, conf.getPapers());
	}

}
