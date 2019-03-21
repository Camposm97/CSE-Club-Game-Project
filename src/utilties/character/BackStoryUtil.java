package utilties.character;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import scene.layout.BackStoryPane;

public class BackStoryUtil {
	private static final int TA_WIDTH = 20;
	private static final int TA_HEIGHT = 4;
	
	public static void displayControls(BackStoryPane background) {
		background.setSpacing(5);
		background.setAlignment(Pos.CENTER_LEFT);
		background.getChildren().add(new Label("Background Story:"));
		background.getChildren().add(background.getTaBackground());
	}
	
	public static TextArea loadTaBackgroundStory() {
		TextArea ta = new TextArea();
		ta.setWrapText(true);
		ta.setPromptText("EDIT HERE!");
		ta.setPrefColumnCount(TA_WIDTH);
		ta.setPrefRowCount(TA_HEIGHT);
		return ta;
	}
}
