package utilties;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import scene.layout.CharacterEditor;

public class CharEditorUtil {

	public static void displayControls(CharacterEditor charEditor) {
		charEditor.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		charEditor.getTabs().addAll(new Tab());
	}

	public static TextField loadTfName() {
		TextField tf = new TextField();
		tf.setEditable(false);
		return tf;
	}
}
