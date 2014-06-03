package group2;

/**
 * Represents a Paper in the conference system.
 * @author Josh, Anh Bui
 *
 */
public class Paper {
	private Author author;
	private String data;
	private boolean reviewed;
	
	/**
	 * Constructs a new Paper object.
	 * @param author The author of the paper;
	 * @param data The paper text itself.
	 */
	public Paper(Author author, String data) {
		this.author = author;
		this.data = data;
	}
	
	/**
	 * Gets the Author of this Paper.
	 * @return the Author.
	 */
	public Author getAuthor() {
		return this.author;
	}
	
	/**
	 * Gets the paper data of this Paper.
	 * @return String representing the Paper.
	 */
	public String getData() {
		return this.data;
	}
	
	/**
	 * Gets the paper reviewed state.
	 * @return True if reviewed, false otherwise.
	 */
	public boolean getReviewed() {
		return this.reviewed;
	}
	
	/**
	 * Sets the Paper's reviewed state.
	 * @param new_state True for reviewed, false otherwise.
	 */
	public void setReviewedState(boolean new_state) {
		this.reviewed = new_state;
	}
	
	/**
	 * Gets the unique id for this Paper.
	 * @return the integer id.
	 */
	public int getID() {
		return this.data.hashCode();
	}
}
