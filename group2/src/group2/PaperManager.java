package group2;

import java.util.*;

/**
 * Manages a collection of Papers for a Conference.
 * @author Josh, Anh Bui
 *
 */
public class PaperManager {
	
	/** 
	 * The collection of Papers.
	 */
	private HashMap<String, Paper> papers;
	private String conference_name;
	
	/**
	 * Constructs a new PaperManager object instance.
	 */
	public PaperManager(String conference_name) {
		this.conference_name = conference_name;
		papers = new HashMap<String, Paper>();
		loadPapers();
	}
	
	/**
	 * Adds the given Paper to the manager,
	 * @param paper The Paper to add.
	 */
	public void addPaper(Paper paper) {
		papers.put(paper.getName(), paper);
		savePapers();
	}
	
	/**
	 * Removes the Paper from the manager.
	 * @param paper_id The id of the Paper to remove.
	 * @return True if the paper was removed or doesn't exist, false otherwise.
	 */
	public void removePaper(Author author) {
		papers.remove(author);
		savePapers();
	}
	
	/**
	 * Removes the Paper from the manager.
	 * @param paper The Paper object to remove.
	 */
	public void removePaper(Paper paper) {
		papers.remove(paper.getAuthor());
		savePapers();
	}
	
	/**
	 * Checks if the Paper exists.
	 * @param paper The Paper to check for.
	 * @return True if the Paper exists, false otherwise.
	 */
	public boolean hasPaper(Paper paper) {
		return papers.containsValue(paper.getName());
	}
	
	/**
	 * checks if the Paper exists.
	 * @param id The id of the Paper to check for.
	 * @return True if the Paper exists, false otherwise.
	 */
	public boolean hasPaper(String name) {
		return papers.containsKey(name);
	}
	
	/**
	 * Gets all the Papers in the manager.
	 * @return The Papers.
	 */
	public Paper[] getPapers() {
		return papers.values().toArray(new Paper[0]);
	}
	
	/**
	 * Gets all the Papers submitted by the given Author.
	 * @param author_name The Author's name.
	 * @return The Papers that were submitted by the Author.
	 */
	public Paper[] getPapers(String author_name) {
		ArrayList<Paper> tmp = new ArrayList<Paper>();
		
		for(Paper x : papers.values()) {
			if (x.getAuthor().getUserName().equals(author_name))
				tmp.add(x);
		}
		return tmp.toArray(new Paper[0]);
	}
	
	public String[] getTitles(String authorName) {
		ArrayList<String> tmp = new ArrayList<String>();
		
		for(Paper x : papers.values()) {
			if (x.getAuthor().getUserName().equals(authorName))
				tmp.add(x.getName());
		}
		return tmp.toArray(new String[0]);
	}
	
	public String[] getReviews(Reviewer reviewer) {
		ArrayList<String> tmp = new ArrayList<String>();
		
		for(Paper x : papers.values()) {
			for(Review r : x.getReviews()) {
				if(r.getReviewer().equals(reviewer.username)) {
					tmp.add(x.getName());
					break;
				}
			}
		}
		return tmp.toArray(new String[0]);
	}
	
	/**
	 * Gets all the Papers submitted by the given Author.
	 * @param author The Author object.
	 * @return The Papers that were submitted by the Author. 
	 */
	public Paper[] getPapers(Author author) {
		ArrayList<Paper> tmp = new ArrayList<Paper>();
		
		for(Paper x : papers.values()) {
			if (x.getAuthor() == author)
				tmp.add(x);
		}
		return tmp.toArray(new Paper[0]);
	}
	
	/**
	 * Gets the Paper with the given ID if it exists.
	 * @param id The id of the Paper to retrieve.
	 * @return The Paper if it exists, null otherwise.
	 */
	public Paper getPaper(Paper paper) {
		if (papers.containsKey(paper.getName())) return papers.get(paper.getName());
		return null;
	}
	
	public Paper getPaper(String name) {
		if (papers.containsKey(name)) return papers.get(name);
		return null;
	}
	
	/**
	 * Loads all Papers from the persistent data file.
	 */
	private void loadPapers() {
		HashMap<String, Paper> result;
		
		result = JSONHelper.deserializeFromFile("data/conferences/" + this.conference_name + "/papers.json", new HashMap<String, Paper>().getClass());
		
		if (result != null)
			papers = result;
	}
	
	/**
	 * Saves all Papers to the persistent data file.
	 */
	private void savePapers() {
		JSONHelper.serializeToFile("data/conferences/" + this.conference_name + "/papers.json", papers);
	}
	
	public int size() {
		return papers.size();
	}
}
