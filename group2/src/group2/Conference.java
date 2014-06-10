package group2;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.sound.sampled.ReverbType;

/**
 * The Conference class for the system.
 * @author Jugbir Singh - Jay
 * @version 17 May, 2014
 */
public class Conference {
	
	//confUser
	public HashMap<String, User> confUser;
	
	/**
	 * The ProgramChair of this conference.
	 */
	private final ProgramChair programChair;
	
	/**
	 * The date (mmddyy) of this conference..
	 */
	private final String date;
	
	/**
	 * The deadline (mmddyy) of this conference.
	 */
	private final String deadline;
	
	/**
	 * The name of this conference.
	 */
	private final String name;
	
	private Map<String, ArrayList<String>> subprogramList;
	
	private Map<String, ArrayList<String>> reviewerList;
	
	private Map<String, String> subprogramRecommend;
	/**
	 * 
	 * A PaperManager for this conference.
	 */
	private PaperManager paperManager;
	
	public Conference(final User theStarter, final String theName, final String theDate, final String theDeadline) {
		confUser = new HashMap<String, User>();
		programChair = new ProgramChair(theStarter.userName, theStarter.password);
		programChair.role = "Program Chair";
		name = theName;
		date = theDate;
		deadline = theDeadline;
		paperManager = new PaperManager(theName);
		subprogramList = new HashMap<String, ArrayList<String>>();
		reviewerList = new HashMap<String, ArrayList<String>>();
		subprogramRecommend = new HashMap<String, String>();
	}
	
	/*
	public boolean checkPaperExists(Paper paper) {
		return papers.hasPaper(paper);
	}
	
	public boolean checkIfReviewed(Paper paper) {
		return paper.getReviewed();
	}*/
	
	/**
	 * Add a paper to the PaperManager.
	 * @param paper, the paper
	 */
	public void addPaper(Paper paper) {
		paperManager.addPaper(paper);
	}
	
	/**
	 * Returns a ProgramChair.
	 * @return programChair
	 */
	public User getProgramChair() {
		return programChair;
	}
	
	/**
	 * Returns the date.
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Returns the deadline.
	 * @return deadline
	 */
	public String getDeadline() {
		return deadline;
	}
	
	/**
	 * Returns the name.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	public Paper[] getPapers() {
		return paperManager.getPapers();
	}
	
	public Map<String, ArrayList<String>> getSubprogramListKeys() {
		return subprogramList;
	}
	
	public Map<String, ArrayList<String>> getReviewerListKeys() {
		return reviewerList;
	}
	
	public Map<String, String> getSubprogramRecommend() {
		return subprogramRecommend;
	}
	
	/**
	 * Return the paper manager
	 * @return paperManager
	 */
	public PaperManager getPaperManager() {
		return paperManager;
	}
	
	/**
	 * String representation of a conference.
	 * @return the name of the conference
	 */
	public String toString() {
		return getName();
	}
}
