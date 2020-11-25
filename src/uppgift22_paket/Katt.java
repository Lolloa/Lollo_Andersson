package uppgift22_paket;

public class Katt extends Animal{
	private String sound;

	Katt(String newName, String newBreed) {
		super(newName, newBreed);
	}
	
	public void setSound(String newSound) {
		this.sound = newSound;
	}
	
	public String getSound() {
		return sound;
	}

	
	
	
	

}
