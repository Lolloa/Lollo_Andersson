package uppgift3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Main extends Application {
	

	int milliSec = 0;
	int sec = 0;
	int min = 0;

	String timer;

	Timeline timeLine;
	Label label;

	Button startButton;
	Button stopButton;
	Button clearButton;

	TableView<DateTime> table;
	ObservableList<DateTime> list = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) {

		label = new Label("00 : 00 : 000");
		label.setFont(new Font("Arial", 20));
		timeLine = new Timeline(new KeyFrame(Duration.millis(1), e -> { // Thread
			milliSec++;

			if (milliSec == 1000) {
				milliSec = 0;
				sec++;
			}
			if (sec == 60) {
				sec = 0;
				min++;
			}

			timer = String.format("%02d : %02d : %03d ", min, sec, milliSec);

			label.setText(timer);

		}));

		timeLine.setCycleCount(Animation.INDEFINITE);

		startButton = new Button("Start");
		stopButton = new Button("Reset");
		clearButton = new Button("Clear history");
		
		startButton.setPrefSize(55, 20);
		stopButton.setPrefSize(55, 20);
		clearButton.setPrefSize(85, 30);
		
		startButton.setStyle("-fx-border-color: #e699b3; ");
		stopButton.setStyle("-fx-border-color: #e699b3; ");
		clearButton.setStyle("-fx-border-color: #e699b3; ");
		
		

		startButton.setOnAction(e -> startTimer());
		stopButton.setOnAction(e -> stopTimer());
		clearButton.setOnAction(e -> clearTime());

		table = new TableView<>();

		TableColumn<DateTime, String> dateTime = new TableColumn<>("Date Time");
		TableColumn<DateTime, String> time = new TableColumn<>("Time");
		
		dateTime.setStyle("-fx-border-color: #e699b3; ");
		time.setStyle("-fx-border-color: #e699b3; ");

		dateTime.setCellValueFactory(new PropertyValueFactory<>("date"));
		time.setCellValueFactory(new PropertyValueFactory<>("time"));

		table.setItems(list);

		table.getColumns().addAll(dateTime, time);

		dateTime.setPrefWidth(150);
		time.setPrefWidth(150);
		
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(startButton, stopButton);

		GridPane gridPane = new GridPane();
		gridPane.add(label, 2, 1); // column, rows
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setConstraints(hBox, 2, 2);
		gridPane.setConstraints(table, 1, 3);
		GridPane.setColumnSpan(table, 2);
		gridPane.setConstraints(clearButton, 1, 4);
		
		
		gridPane.getChildren().addAll(table, clearButton, hBox);

		Scene scene = new Scene(gridPane, 350, 500);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void clearTime() {
		list.clear();
	}

	public void startTimer() {
		if (startButton.getText().equals("Start")) {
			startButton.setText("Stop");
			timeLine.play();
		} else if (startButton.getText().equals("Stop")) {
			startButton.setText("Start");
			list.add(new DateTime(timer));
			timeLine.stop();
		}
	}

	public void stopTimer() {
		timeLine.stop();
		milliSec = 0;
		sec = 0;
		min = 0;

		label.setText("00 : 00 : 000");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
