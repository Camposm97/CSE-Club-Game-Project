package view;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import utilties.BackStoryUtil;

public class BackStoryPane extends VBox {
	private TextArea taBackground;
	
	public BackStoryPane() {
		this.taBackground = BackStoryUtil.loadTaBackgroundStory();
		BackStoryUtil.displayControls(this);
	}
	
	public TextArea getTaBackground() {
		return taBackground;
	}
}
