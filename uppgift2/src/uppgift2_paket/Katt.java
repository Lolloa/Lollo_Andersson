package uppgift2_paket;

public class Katt {
	private String name;
	private String breed;
	Matte matte;
	
	Katt(String newName, String newBreed, Matte matte){
		this.name = newName;
		this.breed = newBreed;
		this.matte = matte;
		
	}
	
	public void setName(String newName) {
		newName = name;
	}
	
	public void setBreed (String newBreed) {
		newBreed = breed;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBreed() {
		return breed;
	}
	
	public void showInfo() {
		System.out.println("\nKatten heter " + name + " och är en " + breed);
	}
	
	public void getMatte() {
		System.out.println(matte + " är min matte");
	}

}
