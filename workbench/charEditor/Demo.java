package charEditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.entities.Player;
import models.statistics.Abilities;
import models.statistics.Statistics;
import scene.layout.PlayerEditorPane;
import utilties.HandlerUtil;
import utilties.LevelUtil;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Player player = new Player("Camposm", new Statistics(10, 10, 15, 10, new Abilities(35, 35, 24, 45, 23, 35)), "Back Story Goes Here");
		LevelUtil.autoLevelUp(player.getStats().getLvl());
		player.getStats().getHitPts().minusFromCurrent(7);
		PlayerEditorPane pane = new PlayerEditorPane(player);
		stage.setScene(new Scene(pane));
		stage.setTitle("Demo");
		HandlerUtil.impFullScreen(stage);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
