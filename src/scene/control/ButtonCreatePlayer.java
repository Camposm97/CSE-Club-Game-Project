package scene.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import models.entities.Player;
import scene.layout.CharacterBuilderPane;
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
				createPlayer();
			else
				WindowLoader.showWarningAllAttrNotSpent();
		}

		public void createPlayer() {
			String name = charPane.getTfName().getText();
			String backStory = charPane.getBackStory().getTaBackground().getText();
			Player player = new Player(name, charPane.getAbilitiesViewer().getAbilities(), backStory);
			
			// Display Player
			System.out.println(player.toString());
			charPane.getPlayerBag().add(player);
			DataSaver.savePlayerBag(charPane.getPlayerBag());
		}
	}
}
