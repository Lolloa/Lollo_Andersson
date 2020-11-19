package uppgift2;

public class Pets {

	public static void main(String[] args) {
		Hund dog1 = new Hund("Fido", "breed");
		Hund dog2 = new Hund("", "");
		Katt cat1 = new Katt("", "");
		Katt cat2 = new Katt("", "");
		System.out.println(dog1.getName() + dog1.getBreed());
		dog1.setName("Maya");
		System.out.println(dog1.getName());

	}

}
