package controller.buttons;

import controller.attributeDialers.AttributeDialBag;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import models.Attributes;
import models.entities.Player;
import utilties.WindowLoader;
import view.CharacterBuilderPane;

public class ButtonCreatePlayer extends Button {
	private CharacterBuilderPane charPane;
	
	public ButtonCreatePlayer(CharacterBuilderPane charPane) {
		super("Create Character");
		this.charPane = charPane;
		this.setOnAction(new HandlerCreatePlayer());
	}
	
	private class HandlerCreatePlayer implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			if (charPane.isAvAttrPtsEmpty())
				createPlayer();
		}
		
		public void createPlayer() {
			String name = charPane.getTfName().getText();
			String backStory = charPane.getBackStory().getTaBackground().getText();
			Player player = new Player(name, getAttributes(charPane.getAttrViewer().getDialBag()), backStory);
			WindowLoader.displayPlayer(player);
		}
		
		public Attributes getAttributes(AttributeDialBag attrBag) {
			int strength = Integer.parseInt(attrBag.getStrDial().getTfNum().getText());
			int dexterity = Integer.parseInt(attrBag.getDexDial().getTfNum().getText());
			int consitution = Integer.parseInt(attrBag.getConDial().getTfNum().getText());
			int intelligence = Integer.parseInt(attrBag.getIntDial().getTfNum().getText());
			int wisdom = Integer.parseInt(attrBag.getWisDial().getTfNum().getText());
			int charisma = Integer.parseInt(attrBag.getChaDial().getTfNum().getText());
			Attributes attributes = new Attributes(strength, dexterity, consitution, intelligence, wisdom, charisma);
			return attributes;
		}
	}
}
