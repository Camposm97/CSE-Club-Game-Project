package scene.control.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import scene.control.attributeDialer.AttributeDial;

public class ButtonMinus extends ButtonOperator {

	public ButtonMinus(AttributeDial tuner) {
		super(tuner);
		super.setText("-");
		super.setOnAction(new ButtonMinusHandler());
	}
	
	private class ButtonMinusHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			int attributePoints = Integer.parseInt(dial.getTfNum().getText()) - 1;
			dial.getTfNum().setText(String.valueOf(attributePoints));
			dial.getCharPane().setAvailableAttrPoints(dial.getCharPane().getAvailableAttrPoints() + 1);
			dial.getCharPane().updateLblAvailablePoints();
			
			// Check if available attribute points is >= total attribute points
			if (dial.getCharPane().isAvAttrPtsFull())
				dial.getCharPane().getAttrViewer().getDialBag().disableDialersWithPoints();
			else
				dial.getCharPane().getAttrViewer().getDialBag().disableDialersWithNoPoints();
		}
	}
}
