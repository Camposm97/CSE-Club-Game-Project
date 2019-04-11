package scene.control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import models.entities.Player;
import scene.layout.CharacterBuilderPane;
import statistics.Stat;
import statistics.StatType;
import statistics.Statistics;
import utilties.CharBuilderUtil;
import utilties.DataSaver;
import utilties.WindowLoader;

public class ButtonCreatePlayer extends Button {
	public static final int WIDTH = 256;
	private CharacterBuilderPane charPane;

	public ButtonCreatePlayer(CharacterBuilderPane charPane) {
		super("Create Character");
		super.setPrefWidth(WIDTH);
		this.charPane = charPane;
		this.setOnAction(new HandlerCreatePlayer());
	}

	private class HandlerCreatePlayer implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if (charPane.isAvAttrPtsEmpty())
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
			Stat abilityPts = new Stat(StatType.Ability, CharBuilderUtil.INIT_ABILITY_POINTS, CharBuilderUtil.INIT_ABILITY_POINTS);
			Player p1 = new Player(name, new Statistics(abilityPts, 15, 10, charPane.getAbilitiesViewer().getAbilities()), backStory);

			// Display Player
			System.out.println(p1.toString());
			charPane.getPlayerBag().add(p1);
			DataSaver.savePlayerBag(charPane.getPlayerBag());
		}
	}
}
