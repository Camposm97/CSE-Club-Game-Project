package controller.buttons;

import controller.attributeDialers.AttributeDial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ButtonPlus extends ButtonOperator {

	public ButtonPlus(AttributeDial dial) {
		super(dial);
		super.setText("+");
		super.setOnAction(new ButtonPlusHandler());
	}

	private class ButtonPlusHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			int attributePoints = Integer.parseInt(dial.getTfNum().getText()) + 1;
			dial.getTfNum().setText(String.valueOf(attributePoints));
			dial.getCharPane().setAvailableAttrPoints(dial.getCharPane().getAvailableAttrPoints() - 1);
			dial.getCharPane().updateLblAvailablePoints();

			if (dial.getCharPane().isAvAttrPtsEmpty())	// Are there no more available attribute points?
				dial.getCharPane().getAttrViewer().getDialBag().disableDialersWithPoints();
			else
				dial.getCharPane().getAttrViewer().getDialBag().disableDialersWithNoPoints();
		}
	}
}
