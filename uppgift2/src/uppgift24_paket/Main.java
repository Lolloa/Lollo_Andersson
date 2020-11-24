package uppgift24_paket;

public class Main {

	public static void main(String[] args) {
		Katt cat = new Katt("Bosse", "huskatt");
		Matte matte = new Matte("Aimee", cat);
		
		matte.showInfo();
		System.out.println("Min matte heter " + matte.getName());

	}

}
