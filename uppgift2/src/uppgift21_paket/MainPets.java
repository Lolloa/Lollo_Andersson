package uppgift21_paket;

public class MainPets {

	public static void main(String[] args) {
		Hund dog = new Hund("Maya", "Tibetansk terrier");
		Katt cat = new Katt("Bosse", "Huskatt");
		
		System.out.println("Hunden heter " + dog.getName() +" och �r en " + dog.getBreed());
		System.out.println("Katten heter " + cat.getName() + " och �r en " + cat.getBreed());

	}

}
