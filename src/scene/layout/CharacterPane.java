package scene.layout;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public abstract class CharacterPane extends GridPane {
	protected TextField tfName;
	protected BackStoryPane backStory;
	
	public CharacterPane() {
		this.backStory = new BackStoryPane();
	}
	
	public TextField getTfName() {
		return tfName;
	}

	public BackStoryPane getBackStory() {
		return backStory;
	}
}
