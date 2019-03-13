package buttons;

import attributeDialers.AttributeDial;
import javafx.scene.control.Button;

public abstract class ButtonOperator extends Button {
	protected AttributeDial dial;
	
	public ButtonOperator(AttributeDial dial) {
		this.dial = dial;
	}
}
