package uppgift23_paket;

public class Husse {
	private String name;
	private Hund[] dogs;

	public Husse(String newName, Hund[] newDogs) {
		this.name = newName;
		this.dogs = newDogs;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void printDogs() {
		for (int i = 0; i < dogs.length; i++) {
			System.out.println(dogs[i].getName());
		}
	}

}
