package uppgift4;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Main extends Application {

	Label firstNameLabel, lastNameLabel, jerseyNumLabel;
	Button addButton, deleteButton, updateButton, saveUpdateButton;
	Scene scene;
	TextField firstNameText, lastNameText, jerseyNumText;
	TableView<Players> tableView;
	TableColumn<Players, String> firstName, lastName, jerseyNumber;
	ObservableList<Players> playerInfo;
	List<Players> playerList = new ArrayList<Players>();
	PlayerSAndD encoder, decoder;
	Players pSelected, players;

	@Override
	public void start(Stage primaryStage) {

		firstNameLabel = new Label("First name: ");
		firstNameLabel.setFont(new Font("Calibri", 16));
		firstNameLabel.setTextFill(Color.web("#f2f2f2"));
		lastNameLabel = new Label("Last name: ");
		lastNameLabel.setFont(new Font("Calibri", 16));
		lastNameLabel.setTextFill(Color.web("#f2f2f2"));
		jerseyNumLabel = new Label("Jersey Number:");
		jerseyNumLabel.setFont(new Font("Calibri", 16));
		jerseyNumLabel.setTextFill(Color.web("#f2f2f2"));

		addButton = new Button("Add");
		deleteButton = new Button("Delete");
		updateButton = new Button("Update");
		saveUpdateButton = new Button("Save update");
		addButton.setOnAction(e -> add());
		deleteButton.setOnAction(e -> delete());
		updateButton.setOnAction(e -> update());
		saveUpdateButton.setOnAction(e -> saveUpdate());

		firstNameText = new TextField();
		lastNameText = new TextField();
		jerseyNumText = new TextField();

		firstNameText.setPromptText("First name");
		firstNameText.setPrefSize(167, 20);
		lastNameText.setPromptText("Last name");
		jerseyNumText.setPromptText("Jersey Number");

		tableView = new TableView();
		tableView.setEditable(true);
		firstName = new TableColumn<>("First Name");
		firstName.setCellValueFactory(new PropertyValueFactory("firstName"));
		firstName.setMinWidth(192);
		lastName = new TableColumn<>("Last Name");
		lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		lastName.setMinWidth(192);
		jerseyNumber = new TableColumn<>("Jersey Number");
		jerseyNumber.setCellValueFactory(new PropertyValueFactory("jerseyNumber"));
		jerseyNumber.setMinWidth(92);

		tableView.getColumns().addAll(firstName, lastName, jerseyNumber);

		decoded();

		VBox vBoxLabel = new VBox(19);
		vBoxLabel.setPadding(new Insets(12, 10, 10, 10));
		vBoxLabel.getChildren().addAll(firstNameLabel, lastNameLabel, jerseyNumLabel);

		HBox buttonHbox = new HBox(20);
		buttonHbox.setPadding(new Insets(10, 10, 10, 10));
		buttonHbox.getChildren().addAll(addButton, deleteButton, updateButton, saveUpdateButton);
		buttonHbox.setLayoutY(510);

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.getChildren().addAll(tableView);
		hBox.setLayoutY(100);

		VBox vBoxText = new VBox(10);
		vBoxText.setPadding(new Insets(10, 10, 10, 10));
		vBoxText.getChildren().addAll(firstNameText, lastNameText, jerseyNumText);
		vBoxText.setLayoutX(310);

		Pane pane = new Pane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().addAll(vBoxLabel, vBoxText, hBox, buttonHbox);

		scene = new Scene(pane, 500, 550);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setTitle("AIK Fotboll");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void decoded() {
		PlayerSAndD decoder = new PlayerSAndD();
		ObservableList<Players> newPlayerList = FXCollections.observableArrayList(decoder.decodePlayers());
		tableView.setItems(newPlayerList);

	}

	private void saveUpdate() {

		playerInfo = tableView.getItems();
		pSelected = (Players) tableView.getSelectionModel().getSelectedItem();

		pSelected.setFirstName(firstNameText.getText());
		pSelected.setLastName(lastNameText.getText());
		pSelected.setJerseyNumber(jerseyNumText.getText());

		tableView.refresh();
		
		firstNameText.clear();
		lastNameText.clear();
		jerseyNumText.clear();
		
		playerList = new ArrayList<Players>(tableView.getItems());
		encoder = new PlayerSAndD();
		encoder.encodePlayers(playerList);
	}

	private void update() {

		playerInfo = FXCollections.observableArrayList();
		playerInfo = tableView.getItems();
		pSelected = (Players) tableView.getSelectionModel().getSelectedItem();

		firstNameText.setText(pSelected.getFirstName());
		lastNameText.setText(pSelected.getLastName());
		jerseyNumText.setText(pSelected.getJerseyNumber());

		playerList = new ArrayList<Players>(tableView.getItems());
		encoder = new PlayerSAndD();
		encoder.encodePlayers(playerList);
	}

	private void delete() {
		playerInfo = FXCollections.observableArrayList();
		playerInfo = tableView.getItems();

		pSelected = (Players) tableView.getSelectionModel().getSelectedItem();
		tableView.getItems().remove(pSelected);
		
		playerList = new ArrayList<Players>(tableView.getItems());
		encoder = new PlayerSAndD();
		encoder.encodePlayers(playerList);

	}

	private void add() {
		players = new Players();
		players.setFirstName(firstNameText.getText());
		players.setLastName(lastNameText.getText());
		players.setJerseyNumber(jerseyNumText.getText());
		tableView.getItems().add(players);

		firstNameText.clear();
		lastNameText.clear();
		jerseyNumText.clear();

		playerList = new ArrayList<Players>(tableView.getItems());
		encoder = new PlayerSAndD();
		encoder.encodePlayers(playerList);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
