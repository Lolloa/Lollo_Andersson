package uppgift24_paket;

public class Main {

	public static void main(String[] args) {
		Katt cat = new Katt("Bosse", "huskatt");
		Matte matte = new Matte("Gittan", cat);
		
		
		System.out.println("Jag heter " + cat.getName() + " och är av rasen " + cat.getBreed());
		cat.setMatte(matte);
		System.out.println("Min matte heter " + cat.getMatte());

	}

}
