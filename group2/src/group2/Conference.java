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
	private List<User> users;
	private PaperManager papers;
	
	public Conference(final User theStarter, final String theDate, final String theDeadline) {
		programChair = (ProgramChair) theStarter;
		date = theDate;
		deadline = theDeadline;
		users = new ArrayList<User>();
		users.add(theStarter);
		papers = new PaperManager();
	}
	
	/*
	public void setPC(final User theStarter) {
		programChair = theStarter;
	}*/
	
	public boolean checkPaperExists(Paper paper) {
		return papers.hasPaper(paper);
	}
	
	public boolean checkIfReviewed(Paper paper) {
		return paper.getReviewed();
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
	
	public List<User> getUsers() {
		return users;
	}
	
	public List<Paper> getPapers() {
		return papers;
	}
}
