package uppgift23_paket;

public class Hund {
	private String name;
	private String breed;
	
	Hund(String newName, String newBreed){
		this.name = newName;
		this.breed = newBreed;
	}
	
	public void setName(String newName) {
		newName = name;
	}
	
	public void setBreed(String newBreed) {
		newBreed = breed;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBreed() {
		return breed;
	}
	

}