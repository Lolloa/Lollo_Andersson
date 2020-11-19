package uppgift2;

public class Katt {
	private String name;
	private String breed;
	
	Katt(String newName, String newBreed){
		this.name = newName;
		this.breed = newBreed;
	}
	
	public void setName(String newName) {
		newName = name;
	}
	
	public void setBreed (String newBreed) {
		newBreed = breed;
	}
	
	public String getName(String newName) {
		return newName;
	}
	
	public String getBreed(String newBreed) {
		return newBreed;
	}

}
