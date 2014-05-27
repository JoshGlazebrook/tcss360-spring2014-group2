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
	
	public boolean hasPaper(Paper paper) {
		return papers.containsValue(paper);
	}
	
	public Paper[] getPapers() {
		return papers.values().toArray(new Paper[0]);
	}
	
	public Paper[] getPapersByAuthor(String author_name) {
		ArrayList<Paper> tmp = new ArrayList<Paper>();
		
		for(Paper x : papers.values()) {
			if (x.getAuthor().getUserName().equals(author_name))
				tmp.add(x);
		}
		return tmp.toArray(new Paper[0]);
	}
	
	public Paper[] getPapersByAuthor(Author author) {
		ArrayList<Paper> tmp = new ArrayList<Paper>();
		
		for(Paper x : papers.values()) {
			if (x.getAuthor() == author)
				tmp.add(x);
		}
		return tmp.toArray(new Paper[0]);
	}
	
	public Paper getPaperByID(int id) {
			for(Paper x : papers.values()) {
				if (x.getID() == id)
					return x;
			}
			return null;
	}
	
}
