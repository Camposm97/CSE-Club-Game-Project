package scene.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.statistics.Ability;

public class ButtonPlus extends ButtonOperator {

	public ButtonPlus(AbilityDial dial) {
		super(dial);
		super.setText("+");
		super.setOnAction(new ButtonPlusHandler());
	}

	private class ButtonPlusHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			int attributePoints = Integer.parseInt(dial.getTfScore().getText()) + 1;
			dial.getTfScore().setText(String.valueOf(attributePoints));
			dial.getCharPane().setAvailableAttrPoints(dial.getCharPane().getAvailableAttrPoints() - 1);
			dial.getTfModifer().setText(Ability.computeModifier(dial.getTfScore().getText()));
			dial.getCharPane().updateLblAvailablePoints();
			
			if (dial.getCharPane().isAvAttrPtsEmpty()) // Are there no more available attribute points?
				dial.getCharPane().getAbilitiesViewer().getDialBag().disableDialersWithPoints();
			else
				dial.getCharPane().getAbilitiesViewer().getDialBag().disableDialersWithNoPoints();
		}
	}
}
