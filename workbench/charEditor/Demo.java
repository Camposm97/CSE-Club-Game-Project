package charEditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.entities.Player;
import models.statistics.Abilities;
import models.statistics.Statistics;
import scene.layout.PlayerEditorPane;
import utilties.LevelUtil;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Player player = new Player("Camposm", new Statistics(10, 10, 15, 10, new Abilities(20, 10, 5, 2, 25, 34)), "Hello World");
		LevelUtil.autoLevelUp(player.getStats().getLvl());
		player.getStats().getHitPts().minusFromCurrent(7);
		PlayerEditorPane pane = new PlayerEditorPane(player);
		stage.setScene(new Scene(pane));
		stage.setTitle("Demo");
//		stage.setFullScreen(true);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
