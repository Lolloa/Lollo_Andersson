package uppgift2;

public class Pets {

	public static void main(String[] args) {
		Hund dog1 = new Hund("Maya", "tibetansk terrier");
		Hund dog2 = new Hund("Trippel", "tibetansk terrier");
		Katt cat1 = new Katt("Bosse", "huskatt");
		Katt cat2 = new Katt("Ginny", "bondkatt");
		
		System.out.println("Hunden heter " + dog1.getName() + " och är en " + dog1.getBreed());
		System.out.println("Den andra hunden heter " + dog2.getName() + " och är en " + dog2.getBreed());
		System.out.println("Katten heter " + cat1.getName() + " och är en " + cat1.getBreed());
		System.out.println("Den andra katten heter " + cat2.getName() + " och är en " + cat2.getBreed());
		

	}

}
