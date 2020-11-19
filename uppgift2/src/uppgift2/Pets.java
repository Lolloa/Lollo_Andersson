package uppgift2;

public class Pets {

	public static void main(String[] args) {
		Hund dog1 = new Hund("Maya", "tibetansk terrier");
		Hund dog2 = new Hund("Trippel", "tibetansk terrier");
		Katt cat1 = new Katt("Bosse", "huskatt");
		Katt cat2 = new Katt("Ginny", "bondkatt");
		Matte matte = new Matte("Lollo", cat1);
		
		System.out.println("Hunden heter " + dog1.getName() + " och är en " + dog1.getBreed()); //Ett sätt ta hämta info
		System.out.println("Den andra hunden heter " + dog2.getName() + " och är en " + dog2.getBreed());

		matte.showInfo(); //Ett annat sätt att hämta info
		cat1.showInfo();
		cat2.showInfo();
		
		

	}

}
