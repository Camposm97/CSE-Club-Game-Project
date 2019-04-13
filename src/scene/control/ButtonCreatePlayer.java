package scene.control;

import java.io.IOException;

import io.DataSaver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import models.entities.Player;
import models.statistics.Abilities;
import models.statistics.Stat;
import models.statistics.StatType;
import models.statistics.Statistics;
import scene.layout.PlayerBuilderPane;
import utilties.CharBuilderUtil;
import utilties.WindowLoader;

public class ButtonCreatePlayer extends Button {
	public static final int WIDTH = 256;
	private PlayerBuilderPane charPane;

	public ButtonCreatePlayer(PlayerBuilderPane charPane) {
		super("Create Character");
		super.setPrefWidth(WIDTH);
		this.charPane = charPane;
		this.setOnAction(new HandlerCreatePlayer());
	}

	private class HandlerCreatePlayer implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if (charPane.isAvailAbilPtsEmpty())
				try {
					createPlayer();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			else
				WindowLoader.showWarningAllAttrNotSpent();
		}

		public void createPlayer() throws IOException {
			String name = charPane.getTfName().getText();
			String backStory = charPane.getBackStory().getTaBackground().getText();
			Stat abilityPts = new Stat(StatType.Ability, CharBuilderUtil.INIT_ABILITY_PTS);
			Abilities abils = charPane.getAbilsViewer().getAbilities();
			Statistics stats = new Statistics(abilityPts, 15, 10, abils);
			Player p1 = new Player(name, stats, backStory);

			// Display Player
			System.out.println(p1.toString());
			charPane.getPlayerBag().add(p1);
			DataSaver.savePlayerBag(charPane.getPlayerBag());
		}
	}
}
