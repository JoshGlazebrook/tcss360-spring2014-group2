package group2;

import java.util.ArrayList;

/**
 * Represents a Paper in the conference system.
 * @author Josh, Anh Bui
 *
 */
public class Paper {
	//name stuff -anh-
	private String name;
	private Author author;
	private String data;
	private boolean reviewed;
	private ArrayList<Review> reviews = new ArrayList<Review>();
	
	/**
	 * Constructs a new Paper object.
	 * @param author The author of the paper;
	 * @param data The paper text itself.
	 */
	public Paper(String name, Author author, String data) {
		this.name = name;
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
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	
	public Review getCurReview(String curReviewer) {
		if(reviews.size() == 0) {
			reviews.add(new Review(curReviewer));
			return reviews.get(0);
		}
		for (Review r : reviews) {
			if(r.getReviewer().equals(curReviewer)) return r;
		}
		return null;
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
