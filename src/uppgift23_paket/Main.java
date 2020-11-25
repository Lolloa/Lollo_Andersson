package uppgift23_paket;

public class Main {

	public static void main(String[] args) {
		Hund dog1 = new Hund("Maya", "tibetansk terrier");
		Hund dog2 = new Hund("Denzel", "pudel");
		Husse husse = new Husse("Rolf", new Hund[]{dog1, dog2});
		
		System.out.println("Husse heter " + husse.getName() + " och hans hundar är: ");
		husse.printDogs();

	}

}
