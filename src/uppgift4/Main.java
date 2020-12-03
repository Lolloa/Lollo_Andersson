package uppgift4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	
	Stage window;
	Scene scene;
	
	TableView <Info>tableView;
	ObservableList<Info> human = FXCollections.observableArrayList();
	
	
	
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label firstNameLabel = new Label("First name: ");
		firstNameLabel.setFont(new Font("Calibri", 16));
		Label lastNameLabel = new Label("Last name: ");
		lastNameLabel.setFont(new Font("Calibri", 16));
		Label ageLabel = new Label("Age :");
		ageLabel.setFont(new Font("Calibri", 16));
		
		TextField firstNameText = new TextField();
		
		firstNameText.setPromptText("First name");
		firstNameText.setPrefSize(250, 20);
		
		TextField lastNameText = new TextField();
		lastNameText.setPromptText("Last name");
		
		TextField ageText = new TextField();
		ageText.setPromptText("Age");
		
		TableColumn<Info, String> firstNameColumn = new TableColumn<>("First name");
		firstNameColumn.setMinWidth(220);
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		
		TableColumn<Info, String> lastNameColumn = new TableColumn<>("Last name");
		lastNameColumn.setMinWidth(220);
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		
		TableColumn<Info, Integer> ageColumn = new TableColumn<>("Age");
		ageColumn.setMinWidth(120);
		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
		
		
		
		Button addButton = new Button("Add");
		Button deleteButton = new Button("Delete");
		
		addButton.setOnAction(e -> addHuman(firstNameText, lastNameText, ageText));
		deleteButton.setOnAction(e -> deleteHuman());
		
		window = primaryStage;
		window.setTitle("Uppgift 4");
		
		VBox vBoxLabel = new VBox(19);
		vBoxLabel.setPadding(new Insets(12, 10, 10, 10));
		vBoxLabel.getChildren().addAll(firstNameLabel, lastNameLabel, ageLabel);
		
		HBox buttonHbox = new HBox(20);
		buttonHbox.setPadding(new Insets(10, 10, 10, 10));
		buttonHbox.getChildren().addAll(addButton, deleteButton);
		buttonHbox.setLayoutY(510);
		
		tableView = new TableView<>();
		tableView.getColumns().addAll(firstNameColumn, lastNameColumn, ageColumn);
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.getChildren().addAll(tableView);
		hBox.setLayoutY(100);
		
		VBox vBoxText = new VBox(10);
		vBoxText.setPadding(new Insets(10, 10, 10, 10));
		vBoxText.getChildren().addAll(firstNameText, lastNameText, ageText);
		vBoxText.setLayoutX(310);
		
		Pane pane = new Pane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().addAll(vBoxLabel, vBoxText, hBox, buttonHbox);
		
		
		
		scene = new Scene(pane, 580, 550);
		
		window.setScene(scene);
		window.show();
		
	}
//Gets error if whole  list is deleted
	private void deleteHuman() {
		ObservableList<Info> humanSelected;
		ObservableList<Info> allInfoHumanSelected;
		
		allInfoHumanSelected = tableView.getItems();
		humanSelected = tableView.getSelectionModel().getSelectedItems(); //Delete users choice
		
		humanSelected.forEach(allInfoHumanSelected::remove); //Deletes all info of human
		
	}

	private void addHuman(TextField firstNameText, TextField lastNameText, TextField ageText) {
		Info human = new Info("", "", 0);
		human.setFirstName(firstNameText.getText());
		human.setLastName(lastNameText.getText());
		human.setAge(Integer.parseInt(ageText.getText()));
		tableView.getItems().add(human);
		firstNameText.clear(); //Clears the User input from textfield
		lastNameText.clear();
		ageText.clear();
	}
	


}
