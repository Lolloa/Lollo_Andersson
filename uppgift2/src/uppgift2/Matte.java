package uppgift2;

public class Matte{
	private String humanName;
	private Katt cat;
	
	public Matte(String newHumanName, Katt cat) {
		this.humanName = newHumanName;
		this.cat = cat;
		
	}
	
	public void showInfo() {
		System.out.println("Mattes namn är " + humanName + " och katten heter " + cat.getName());
	}
	
	public void setName(String newHumanName) {
		newHumanName = humanName;
	}
	
	public String getName() {
		return humanName;
	}

	
	
	

	
	
	

}
