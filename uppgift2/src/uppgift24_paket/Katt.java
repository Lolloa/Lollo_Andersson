package uppgift24_paket;

public class Katt {
	private String name;
	private String breed;
	private Matte matte;
	
	Katt(String newName, String newBreed){
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
	
	public void setMatte(Matte matte) {
		matte = matte;
	}
	
	public Matte getMatte() {
		return matte;
	}
	
	
	
	
	
	

}
