package charEditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.entities.Player;
import models.statistics.Statistics;
import scene.layout.CharacterEditorPane;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Player player = new Player("Camposm", new Statistics(10, 10, 15, 10, null), "Hello World");
		player.getStats().getHitPts().minusFromCurrent(5);
		CharacterEditorPane pane = new CharacterEditorPane(player);
		stage.setScene(new Scene(pane));
		stage.setTitle("Demo");
//		stage.setFullScreen(true);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
