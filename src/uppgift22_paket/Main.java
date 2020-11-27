package uppgift22_paket;

public class Main {

	public static void main(String[] args) {
		Katt cat = new Katt("Bosse", "huskatt");
		Matte matte = new Matte("Lollo", cat);

		cat.setSound("Mjauuuu");

		matte.showInfo();

	}

}
