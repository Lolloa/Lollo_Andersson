package uppgift4;

import java.io.Serializable;

public class Players implements Serializable {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String jerseyNumber;

	public Players() {

	}

	public Players(String firstName, String lastName, String jerseyNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.jerseyNumber = jerseyNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(String jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

}
