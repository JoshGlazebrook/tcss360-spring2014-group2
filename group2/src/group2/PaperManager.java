package group2;

import java.util.*;

public class PaperManager {
	
	private HashMap<Integer, Paper> papers;
	
	public PaperManager() {
		papers = new HashMap<Integer, Paper>();
	}
	
	public boolean addPaper(Paper paper) {
		if (papers.containsKey(paper.getID())) return false;
		
		papers.put(paper.getID(), paper);
		return true;
	}
	
	public boolean removePaper(int paper_id) {
		if (papers.containsKey(paper_id))  return true;
		
		papers.remove(papers.get(paper_id));
		return true;
	}
}
