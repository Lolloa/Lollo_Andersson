package uppgift5;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String pass;
	private int balance;
	private String latestTrans;
	private DateTime date;
	private String createdDate;
	
	

	public User() {

	}

	public User(String username, String pass, String id,  int balance, String createdDate) {
		this.id = id;
		this.pass = pass;
		this.username = username;
		this.balance = balance;
		this.createdDate = createdDate;

	}
	
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int i) {
		this.balance += i;
	}

	public String getLatestTrans() {
		return latestTrans;
	}

	public void setLatestTrans(String latestTrans) {
		this.latestTrans = latestTrans;
	}

}
