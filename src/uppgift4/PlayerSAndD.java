package uppgift4;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class PlayerSAndD {
	private XMLEncoder encoder;
	private XMLDecoder decoder;
	private static final String FILE_NAME = "Players.xml";

	public PlayerSAndD() {

	}

	public void encodePlayers(List<Players> player) {
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILE_NAME)));
			System.out.println("File stream opened and XMLEncoder created");
			encoder.writeObject(player);

		} catch (Exception e) {
			System.out.println("Error: while creating or opening the file");
		}
		System.out.println("Finished");
		encoder.close();
	}

	public ObservableList<Players> decodePlayers() {
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(FILE_NAME)));
			List<Players> player = (List<Players>) decoder.readObject();

			System.out.println("File stream opened and XMLDecoder created");
			decoder.close();
			System.out.println("Decoded");
			return FXCollections.observableArrayList(player);

		} catch (Exception e) {
			System.out.println("Error: while decoding or opening the file");
			return null;
		}
	}

}
