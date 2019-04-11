package demoCharEditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.entities.Player;
import scene.layout.CharacterEditorPane;
import statistics.Abilities;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Player player = new Player("Camposm", new Abilities(6, 8, 4, 7, 4, 2), "Hello World");
		CharacterEditorPane pane = new CharacterEditorPane(player);
		stage.setScene(new Scene(pane));
		stage.setTitle("Demo");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
