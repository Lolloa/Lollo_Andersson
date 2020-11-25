package uppgift24_paket;

public class Katt extends Animal{
	private Matte matte;
	
	Katt(String newName, String newBreed) {
		super(newName, newBreed);
	}
	
	public void setMatte(Matte newMatte) {
		matte = newMatte;
	}

	public String getMatte() {
		return matte.getName();
	}
	
	
	
	
	
	
	
	

}
