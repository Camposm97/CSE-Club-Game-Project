package application;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.MainWindow;

/**
 * Implement: 
 * 	CharacterEditor extends CharacterPane
 * 	MonsterFactory
 * 	ItemFactory
 * 	CharacterBuilder (resourcePoints?)
 * 	Player should have totalResourcePoints and resourcePointsSpentr 
 * 	Some way to enable and disable the CharacterEditor controls to increment ability points.
 * @author Camposm97
 */
public class Main extends Application {	
	@Override
	public void start(Stage stage) throws Exception {
		new MainWindow(stage);		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
