package utilties;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import scene.layout.CharacterEditor;

public class CharacterViewerUtil {

	public static void displayControls(CharacterEditor charViewer) {
		charViewer.setPadding(new Insets(20));
		charViewer.setAlignment(Pos.CENTER);
		charViewer.setHgap(10);
		charViewer.setVgap(10);
		charViewer.add(FXUtil.loadHBox(Pos.CENTER_LEFT, new Label("Name:"), charViewer.getTfName()), 0, 0);
	}

	public static TextField loadTfName() {
		TextField tf = new TextField();
		tf.setEditable(false);
		return tf;
	}
}
