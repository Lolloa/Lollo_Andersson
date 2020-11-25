package uppgift21_paket;

public abstract class Animal {
	private String name;
	private String breed;
	
	Animal(String newName, String newBreed){ 
		this.name = newName;
		this.breed = newBreed;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setBreed(String newBreed) {
		breed = newBreed;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBreed() {
		return breed;
	}

}
