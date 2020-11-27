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
		System.out.println("Mattes namn �r " + name + ", hennes katt heter " + cat.getName() + " och �r av rasen "
				+ cat.getBreed());
		System.out.println(cat.getName() + " s�ger " + cat.getSound());

	}

}
