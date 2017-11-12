package usersinfo;

public class User {
	private String username;
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean verify(String username, String password) {
		boolean res = false;
		if (username.equals(this.username) && password.equals(this.password)) {
			res = true;
		}
		return res;
	}

	public String toString() {
		String res = this.username + " " + this.password;
		return res;
	}
}
