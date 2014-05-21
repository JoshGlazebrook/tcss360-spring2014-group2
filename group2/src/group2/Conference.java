package group2;

import java.util.ArrayList;
import java.util.List;

/**
 * The Conference class for the system.
 * @author Jugbir Singh - Jay
 * @version 17 May, 2014
 */
public class Conference {
	
	private final ProgramChair programChair;
	private final String date;
	private final String deadline;
	private final String name;
	private List<User> users;
	private PaperManager paperManager;
	
	public Conference(final User theStarter, final String theName, final String theDate, final String theDeadline) {
		programChair = (ProgramChair) theStarter;
		name = theName;
		date = theDate;
		deadline = theDeadline;
		users = new ArrayList<User>();
		users.add(theStarter);
		paperManager = new PaperManager();
	}
	
	/*
	public boolean checkPaperExists(Paper paper) {
		return papers.hasPaper(paper);
	}
	
	public boolean checkIfReviewed(Paper paper) {
		return paper.getReviewed();
	}*/
	
	public void addPaper(Paper paper) {
		paperManager.addPaper(paper);
	}
	
	public User getProgramChair() {
		return programChair;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getDeadline() {
		return deadline;
	}
	
	public String getName() {
		return name;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	
}
