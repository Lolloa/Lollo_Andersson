package uppgift2;

public class Pets {

	public static void main(String[] args) {
		Hund dog1 = new Hund("Maya", "tibetansk terrier");
		Hund dog2 = new Hund("Trippel", "tibetansk terrier");
		Katt cat1 = new Katt("Bosse", "huskatt");
		Katt cat2 = new Katt("Ginny", "bondkatt");
		Matte matte = new Matte("Lollo", cat1);
		
		System.out.println("Hunden heter " + dog1.getName() + " och �r en " + dog1.getBreed()); //Ett s�tt ta h�mta info
		System.out.println("Den andra hunden heter " + dog2.getName() + " och �r en " + dog2.getBreed());

		matte.showInfo(); //Ett annat s�tt att h�mta info
		cat1.showInfo();
		cat2.showInfo();
		
		

	}

}
