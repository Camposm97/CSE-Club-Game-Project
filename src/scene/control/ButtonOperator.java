package scene.control;

import javafx.scene.control.Button;

public abstract class ButtonOperator extends Button {
	protected AbilityDial dial;
	
	public ButtonOperator(AbilityDial dial) {
		this.dial = dial;
	}
}
