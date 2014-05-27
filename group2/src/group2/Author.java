package group2;


public class Author extends User{
	PaperManager papers;
	
	public Author(PaperManager manager) {
		papers = manager;
		super(null);
	}
	
	public int submitPaper(String data) {
		
	}
	
	public boolean unsubmitPaper(int paper_id) {
		
	}
	
	public void askForReview(int paper_id) {
		
	}
	
	
}
