package utilties.character;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import scene.layout.CharacterViewer;
import utilties.loader.FXLoader;

public class CharacterViewerUtil {

	public static void displayControls(CharacterViewer charViewer) {
		charViewer.setPadding(new Insets(20));
		charViewer.setAlignment(Pos.CENTER);
		charViewer.setHgap(10);
		charViewer.setVgap(10);
		charViewer.add(FXLoader.loadHBox(Pos.CENTER_LEFT, new Label("Name:"), charViewer.getTfName()), 0, 0);

	}
}
