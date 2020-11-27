package uppgift21_paket;

public class MainPets {

	public static void main(String[] args) {
		Animal dog = new Hund("Maya", "Tibetansk terrier");
		Animal cat = new Katt("Bosse", "Huskatt");

		System.out.println("Hunden heter " + dog.getName() + " och är en " + dog.getBreed());
		System.out.println("Katten heter " + cat.getName() + " och är en " + cat.getBreed());

	}

}
