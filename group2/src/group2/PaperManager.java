package group2;

import java.util.*;

/**
 * Manages a collection of Papers for a Conference.
 * @author Josh
 *
 */
public class PaperManager {
	
	/** 
	 * The collection of Papers.
	 */
	private HashMap<Integer, Paper> papers;
	
	/**
	 * Constructs a new PaperManager object instance.
	 */
	public PaperManager() {
		papers = new HashMap<Integer, Paper>();
	}
	
	/**
	 * Adds the given Paper to the manager,
	 * @param paper The Paper to add.
	 */
	public void addPaper(Paper paper) {
		papers.put(paper.getID(), paper);
	}
	
	/**
	 * Removes the Paper from the manager.
	 * @param paper_id The id of the Paper to remove.
	 * @return True if the paper was removed or doesn't exist, false otherwise.
	 */
	public void removePaper(int paper_id) {
		papers.remove(papers.get(paper_id));
	}
	
	/**
	 * Removes the Paper from the manager.
	 * @param paper The Paper object to remove.
	 */
	public void removePaper(Paper paper) {
		papers.remove(paper.getID());
	}
	
	/**
	 * Checks if the Paper exists.
	 * @param paper The Paper to check for.
	 * @return True if the Paper exists, false otherwise.
	 */
	public boolean hasPaper(Paper paper) {
		return papers.containsValue(paper);
	}
	
	/**
	 * checks if the Paper exists.
	 * @param id The id of the Paper to check for.
	 * @return True if the Paper exists, false otherwise.
	 */
	public boolean hasPaper(int id) {
		return papers.containsKey(id);
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
	public Paper getPaper(int id) {
			for(Paper x : papers.values()) {
				if (x.getID() == id)
					return x;
			}
			return null;
	}
	
}
