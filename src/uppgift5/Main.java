package uppgift5;
	
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Main extends Application {
	Stage window;
	Scene scene1, scene2, scene3, scene4;
	TextField username, createUsername;
	PasswordField password, createPass;
	Button loginButton, createAccountButton, changePass;
	XMLHandler xml = new XMLHandler();
	List<User> users = new ArrayList<User>();//(xml.decodePlayers());
	User user = new User();
	Bank addUser;
	Label saldo, date, message;
	DateTime dateTime;
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		message = new Label();
		loginButton = new Button("Login");
		loginButton.setPrefSize(150, 35);
		createAccountButton = new Button("Create a new account");
		createAccountButton.setPrefSize(150, 35);

		loginButton.setOnAction(e -> login());
		createAccountButton.setOnAction(e -> scene2());

		username = new TextField();
		username.setPrefSize(150, 30);
		username.setPromptText("Username");

		password = new PasswordField();
		password.setPrefSize(150, 30);
		password.setPromptText("Password");
		
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.getChildren().addAll(username, password, message);

		HBox hBox = new HBox(50);
		hBox.setPadding(new Insets(20, 20, 20, 20));
		hBox.setLayoutY(120);
		hBox.getChildren().addAll(loginButton, createAccountButton);
		hBox.setStyle("-fx-background-color: #f578b6");

		Pane pane = new Pane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setStyle("-fx-background-color: #FFFFFF");
		pane.getChildren().addAll(vBox, hBox);
		

		scene1 = new Scene(pane, 385, 250);
		
		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(scene1);
		window.show();
	}
	
	private void login() {
		
		for(int i = 0; i<users.size(); i++) {
			if (username.getText().equals(users.get(i).getUsername()) && password.getText().equals(users.get(i).getPass())) {
				message.setText("Login succesfully...");
				message.setTextFill(Color.rgb(21, 117, 84));
				scene3(users.get(i));
			} else {
				message.setText("Incorrect username or password");
				message.setTextFill(Color.rgb(210,  39, 30));
			}
		}
		
		
	}
	
	public void scene2() {
		
		Label createLabel = new Label();
		message = new Label();
		createLabel.setText("Create a new account");
		createLabel.setFont(new Font("Calibri", 20));

		Button saveButton = new Button("Save");
		saveButton.setPrefSize(150, 35);
		Button previousButton = new Button("Previous page");
		previousButton.setPrefSize(150, 35);

		saveButton.setOnAction(e -> save());
		previousButton.setOnAction(e -> previoiusPage());

		createUsername = new TextField();
		createUsername.setPrefSize(150, 30);
		createUsername.setPromptText("User Name");

		createPass = new PasswordField();
		createPass.setPrefSize(150, 30);
		createPass.setPromptText("Password");
		
		VBox label = new VBox(20);
		label.setPadding(new Insets(20, 20, 20, 20));
		label.getChildren().addAll(createLabel, message);

		VBox vBox = new VBox(20);
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.setLayoutX(200);
		vBox.getChildren().addAll(createUsername, createPass);

		HBox hBox = new HBox(50);
		hBox.setPadding(new Insets(20, 20, 20, 20));
		hBox.setLayoutY(120);
		hBox.getChildren().addAll(previousButton, saveButton);
		hBox.setStyle("-fx-background-color: #f578b6");

		Pane pane2 = new Pane();
		pane2.getChildren().addAll(label, vBox, hBox);
		pane2.setStyle("-fx-background-color: #FFFFFF");
		

		scene2 = new Scene(pane2, 385, 250);

		window.setScene(scene2);
		window.show();
	}
	
	private void save() {
		Random rng = new Random();
		addUser = new Bank();
		dateTime = new DateTime();
		user.setUsername(createUsername.getText());
		user.setPass(createPass.getText());
		user.setId(((Integer) rng.nextInt(10000000)).toString());
		user.setCreatedDate(dateTime.getDate());
		addUser.addUser(createUsername.getText(), createPass.getText(), user.getId(), 0, user.getCreatedDate());
		users.add(user);
		message.setText("New user created!");
		message.setTextFill(Color.rgb(21, 117, 84));
		System.out.println(user.getUsername());
		System.out.println(user.getPass());

		XMLHandler xmlEncoder = new XMLHandler();
		xmlEncoder.encode(users);
	}
	
	private void previoiusPage() {
		start(window);
	}
	
	private void scene3(User newUser) {
		Label kontonr = new Label();
		kontonr.setFont(new Font("Arial", 14));
		dateTime = new DateTime();
		saldo = new Label();
		saldo.setFont(new Font("Arial", 14));
		date = new Label();
		date.setFont(new Font("Arial", 14));
		Label createdDate = new Label();
		createdDate.setFont(new Font("Arial", 14));
		
		createdDate.setText("Created date: " + newUser.getCreatedDate());
		kontonr.setText("Account number: " + newUser.getId());
		saldo.setText("Saldo: " + newUser.getBalance());
		

		Button withdraw = new Button("Withdraw");
		withdraw.setPrefSize(150, 35);
		withdraw.setOnAction(e -> withdrawmethod(newUser));
		withdraw.setStyle("-fx-border-color: #f578b6");
		Button deposit = new Button("Deposit");
		deposit.setPrefSize(150, 35);
		deposit.setOnAction(e -> depositmethod(newUser));
		deposit.setStyle("-fx-border-color: #f578b6");
		Button changePass = new Button("Change password");
		changePass.setPrefSize(150, 35);
		changePass.setOnAction(e -> changePassword(newUser));
		changePass.setStyle("-fx-border-color: #f578b6");
		
		VBox buttonLayout = new VBox();
		buttonLayout.setPadding(new Insets(20, 20, 20, 20));
		buttonLayout.setLayoutY(180);
		buttonLayout.getChildren().add(changePass);
		buttonLayout.setLayoutX(90);
		

		VBox vBox = new VBox(20);
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.getChildren().addAll(kontonr, saldo, createdDate);
		

		HBox hBox = new HBox(50);
		hBox.setPadding(new Insets(20, 20, 20, 20));
		hBox.setLayoutY(120);
		hBox.getChildren().addAll(withdraw, deposit);
		hBox.setStyle("-fx-background-color: #f578b6");

		Pane pane = new Pane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().addAll(vBox, hBox, buttonLayout);
		pane.setStyle("-fx-background-color: #FFFFFF");

		scene3 = new Scene(pane, 385, 250);
		window.setScene(scene3);
		window.show();

	}
	
	private void changePassword(User newUser) {
		Label setNewPass = new Label();
		setNewPass.setFont(new Font("Arial", 14));
		Button previous = new Button("Previous page");
		previous.setPrefSize(150, 35);
		message = new Label();
		setNewPass.setText("Write your new password");
		PasswordField newPass = new PasswordField();
		newPass.setPrefSize(150, 30);
		Button submit = new Button("Submit");
		submit.setPrefSize(150, 35);
		submit.setOnAction(e -> {
			newUser.setPass(newPass.getText());
			message.setText("Password changed!");
			message.setTextFill(Color.rgb(21, 117, 84));
			XMLHandler xmlEncoder = new XMLHandler();
			xmlEncoder.encode(users);
		});
		
		previous.setOnAction(e -> window.setScene(scene3));
		
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.getChildren().addAll(setNewPass, newPass, message, submit);
		
		HBox hBox = new HBox(50);
		hBox.setPadding(new Insets(20, 20, 20, 20));
		hBox.setLayoutY(120);
		hBox.getChildren().addAll(submit, previous);
		hBox.setStyle("-fx-background-color: #f578b6");

		Pane pane = new Pane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setStyle("-fx-background-color: #FFFFFF");
		pane.getChildren().addAll(vBox, hBox);
		pane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		scene4 = new Scene(pane, 385, 250);
		window.setScene(scene4);
		window.show();
	}

	private void depositmethod(User newUser) {
		TextField depText = new TextField();
		depText.setPrefSize(150, 30);
		Label label = new Label();
		label.setFont(new Font("Arial", 14));
		Label message = new Label();
		dateTime = new DateTime();
		Button depButton = new Button("Deposit");
		depButton.setPrefSize(150, 35);
		date.setText("Latest transaction date: "+ newUser.getLatestTrans());
		depButton.setOnAction(e -> {
			try {	
				int test = Integer.parseInt(depText.getText());
				newUser.setBalance(test);
				saldo.setText("Saldo: " + newUser.getBalance());
				message.setText("Money has been added to this account!");
				message.setTextFill(Color.rgb(21, 117, 84));
				label.setText("New Saldo :" + " " + newUser.getBalance());
				newUser.setLatestTrans(dateTime.getDate());
				date.setText("Latest transaction date: "+ dateTime.getDate());
				XMLHandler xmlEncoder = new XMLHandler();
				xmlEncoder.encode(users);

			} catch (Exception e2) {
			}

		});
		
		Button previousPage = new Button("Previous page");
		previousPage.setPrefSize(150, 35);
		previousPage.setOnAction(e -> window.setScene(scene3));

		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.getChildren().addAll(depText, date, label, message);

		HBox hBox = new HBox(50);
		hBox.setPadding(new Insets(20, 20, 20, 20));
		hBox.setLayoutY(150);
		hBox.getChildren().addAll(depButton, previousPage);
		hBox.setStyle("-fx-background-color: #f578b6");

		Pane pane = new Pane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().addAll(vBox, hBox);
		pane.setStyle("-fx-background-color: #FFFFFF");

		scene4 = new Scene(pane, 385, 250);
		window.setScene(scene4);
		window.show();
	}
	
	private void withdrawmethod(User newUser) {
		TextField withdraw = new TextField();
		withdraw.setPrefSize(150, 30);
		Label label = new Label();
		label.setFont(new Font("Arial", 14));
		message = new Label();
		dateTime = new DateTime();
		Button withButton = new Button("Withdraw");
		withButton.setPrefSize(150, 35);
		date.setText("Latest transaction date: "+ newUser.getLatestTrans());
		withButton.setOnAction(e -> {
			
			label.setText("New Saldo :" + " " + newUser.getBalance());
			int with = 0;
			try {
				with = Integer.parseInt(withdraw.getText());
			
			if (with < 0) {
				message.setText("Can't withdraw a negativ amount");
				message.setTextFill(Color.rgb(210,  39, 30));
			} else if (newUser.getBalance() < with) {
				message.setText("Not enough money");
				message.setTextFill(Color.rgb(210,  39, 30));
			} else {

				newUser.setBalance(-1 * with);
				message.setText("Money has been withdrawn");
				message.setTextFill(Color.rgb(21, 117, 84));
				
				saldo.setText("Saldo: " + newUser.getBalance());
				label.setText("New Saldo :" + " " + newUser.getBalance());
				date.setText("Latest transaction date: "+ dateTime.getDate());
				XMLHandler xmlEncoder = new XMLHandler();
				xmlEncoder.encode(users);

			}
			
			
			
			} catch (Exception e2) {
			}
		});
		
		
		
		Button previousPage = new Button("Previous page");
		previousPage.setPrefSize(150, 35);
		previousPage.setOnAction(e -> window.setScene(scene3));
		
		VBox vBox = new VBox(12);
		vBox.setPadding(new Insets(20, 20, 20, 20));
		vBox.getChildren().addAll(withdraw, date, label, message);

		HBox hBox = new HBox(50);
		hBox.setPadding(new Insets(20, 20, 20, 20));
		hBox.setLayoutY(140);
		hBox.getChildren().addAll(withButton, previousPage);
		hBox.setStyle("-fx-background-color: #f578b6");

		Pane pane = new Pane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().addAll(vBox, hBox);
		pane.setStyle("-fx-background-color: #FFFFFF");

		scene4 = new Scene(pane, 385, 250);
		window.setScene(scene4);
		window.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
