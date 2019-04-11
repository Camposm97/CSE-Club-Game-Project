package scene.control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import models.statistics.Ability;

public class ButtonMinus extends ButtonOperator {

	public ButtonMinus(AbilityDial dial) {
		super(dial);
		super.setText("-");
		super.setOnAction(new ButtonMinusHandler());
	}

	private class ButtonMinusHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			int attributePoints = Integer.parseInt(dial.getTfScore().getText()) - 1;
			dial.getTfScore().setText(String.valueOf(attributePoints));
			dial.getCharPane().setAvailAbilPts(dial.getCharPane().getAvailAbilityPts() + 1);
			dial.getTfModifer().setText(Ability.computeModifier(dial.getTfScore().getText()));
			dial.getCharPane().updateLblAvailPts();

			if (dial.getCharPane().isAvailAbilPtsFull()) // Check if available attribute points is >= total attribute points
				dial.getCharPane().getAbilsViewer().getDialBag().disableDialersWithPoints();
			else
				dial.getCharPane().getAbilsViewer().getDialBag().disableDialersWithNoPoints();
		}
	}
}
