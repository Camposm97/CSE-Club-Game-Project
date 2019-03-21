package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.layout.TitleScreenPane;

public class Main extends Application {
	private TitleScreenPane titleScreen;
	@Override
	public void init() {
		titleScreen = new TitleScreenPane();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(titleScreen, 900, 700));
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
