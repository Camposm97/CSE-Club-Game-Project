package scene.control.buttons;

import javafx.scene.control.Button;
import scene.control.attributeDialer.AttributeDial;

public abstract class ButtonOperator extends Button {
	protected AttributeDial dial;
	
	public ButtonOperator(AttributeDial dial) {
		this.dial = dial;
	}
}
