package group2;

import java.util.LinkedList;
import java.util.List;

/**
 * The Conference class for the application
 * @author Jugbir Singh - Jay
 * @version 17 May, 2014
 */
public class Conference {
	
	ProgramChair programChair;
	String date;
	String deadline;
	List<User> users;
	
	Conference(final User theStarter, final String theDate, final String theDeadline) {
		programChair = theStarter;
		date = theDate;
		deadline = theDeadline;
		users = new LinkedList<User>();
		users.add(theStarter);
	}
	
	/*
	public void setPC(final User theStarter) {
		programChair = theStarter;
	}*/
	
	public boolean checkExist(String data) {
		
	}
	
	checkIfReviewed(String title) {
		
	}
	
	
}
