package group2;

public class Paper {
	private Author author;
	private String data;
	
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
	
	public int getID() {
		return this.data.hashCode();
	}
}
