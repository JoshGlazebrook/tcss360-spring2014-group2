package group2;

public class Paper {
	private int paper_id;
	private Author author;
	private String data;
	
	public Paper(int paper_id, Author author, String data) {
		this.paper_id = paper_id;
		this.author = author;
		this.data = data;
	}
	
	public int getID() {
		return this.paper_id;
	}
	
	public Author getAuthor() {
		return this.author;
	}
	
	public String getData() {
		return this.data;
	}
}
