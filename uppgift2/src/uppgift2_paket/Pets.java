package uppgift2_paket;

public class Pets {

	public static void main(String[] args) {
		Hund dog1 = new Hund("Maya", "tibetansk terrier");
		Hund dog2 = new Hund("Trippel", "tibetansk terrier");
		Katt cat1 = new Katt("Bosse", "huskatt", null);
		Matte matte = new Matte("Lollo", cat1);
		
		Husse husse = new Husse("Måns", new Hund[]{dog1, dog2});
		
		System.out.println("Hunden heter " + dog1.getName() + " och är en " + dog1.getBreed()); //Ett sätt ta hämta info
		System.out.println("Den andra hunden heter " + dog2.getName() + " och är en " + dog2.getBreed());
		
		cat1.showInfo();

		matte.showInfo(); //Ett annat sätt att hämta info
		
		
		System.out.println("\nHusse heter " + husse.getName() + " hans hundar heter: ");
		husse.printDogs();
		
		cat1.getMatte();
		
		

	}

}
