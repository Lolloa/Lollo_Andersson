package uppgift22_paket;

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
		System.out.println("Mattes namn är " + name + ", hennes katt heter " + cat.getName() + " och är av rasen "
				+ cat.getBreed());
		System.out.println(cat.getName() + " säger " + cat.getSound());

	}

}
