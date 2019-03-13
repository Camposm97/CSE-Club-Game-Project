package application;

import javafx.application.Application;
import javafx.stage.Stage;
import window.MainWindow;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		new MainWindow(stage);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
