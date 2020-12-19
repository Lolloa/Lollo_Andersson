package uppgift5;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class XMLHandler {
	
	XMLEncoder encoder;
	XMLDecoder decoder;
	private static final String FILE_NAME = "Bank.xml";
	
	public XMLHandler () {
		
	}
	
	public void encode (List<User> saveUser) {
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILE_NAME)));
			System.out.println("File stream opened and XMLEncoder created");
				encoder.writeObject(saveUser);
			
	

		} catch (Exception e) {
			System.out.println("Error: while creating or opening the file");
		}
		System.out.println("Finished");
		encoder.close();
	}
	
	public List<User> decodePlayers() {
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILE_NAME)));
			List<User> people = (List<User>) decoder.readObject();

			System.out.println("File stream opened and XMLDecoder created");
			decoder.close();
			System.out.println("Decoded");
			return people;
			//return FXCollections.observableArrayList(people);

		} catch (Exception e) {
			System.out.println("Error: while decoding or opening the file");
			return null;
		}
	}

}
