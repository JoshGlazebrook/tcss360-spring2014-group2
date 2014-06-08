package group2;

public class Review {
	private String reviewer;
	private String data;
	public Review(String reviewer) {
		this.reviewer = reviewer;
	}
	
	public String getReviewer() {
		return reviewer;
	}
	
	public String getReview() {
		return data;
	}
	
	public void setReview(String review) {
		data = review;
	}
}
