package application;

import javafx.application.Application;
import javafx.stage.Stage;
import scene.MainWindow;

/**
 * Implement: 
 * 	CharacterEditor
 * 	MonsterMaker
 * 	ItemMaker
 * 	CharacterBuilder (resourcePoints)
 * 	Player should have totalResourcePoints and resourcePointsSpent
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
