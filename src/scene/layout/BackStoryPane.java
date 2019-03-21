package scene.layout;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import utilties.character.BackStoryUtil;

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
