package uppgift5;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<User> users;

	public Bank() {
		this.users = new ArrayList<User>();
	}
	
	public User addUser(String newUsername, String newPass, String id, int amount, String date) {
		User newUser = new User(newUsername, newPass, id, amount, date);
		this.users.add(newUser);

		return newUser;
	}

}
