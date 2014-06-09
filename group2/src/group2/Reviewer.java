package group2;

public class Reviewer extends User{
	public String userName;
	public String password;
	public Reviewer(String username, String password) {
		super(username, password);
		this.userName = username;
		this.password = password;
	}
}
