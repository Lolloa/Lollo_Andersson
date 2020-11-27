package uppgift24_paket;

public class Matte {
	private String name;
	private Katt cat;

	Matte(String newName, Katt cat) {
		this.name = newName;
		this.cat = cat;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void showInfo() {
		System.out.println("Katten heter " + cat.getName() + " och är rasen är " + cat.getBreed());
	}

}
