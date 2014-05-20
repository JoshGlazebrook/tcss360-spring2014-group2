package group2;

public class Paper {
	private Author author;
	private String data;
	private boolean reviewed;
	
	public Paper(Author author, String data) {
		this.author = author;
		this.data = data;
	}
	
	public Author getAuthor() {
		return this.author;
	}
	
	public String getData() {
		return this.data;
	}
	
	public boolean getReviewed() {
		return this.reviewed;
	}
	
	public void setReviewedState(boolean new_state) {
		this.reviewed = new_state;
	}
	
	public int getID() {
		return this.data.hashCode();
	}
}
