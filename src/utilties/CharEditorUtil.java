package utilties;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import scene.layout.CharacterEditorPane;

public class CharEditorUtil {
	public static void displayControls(CharacterEditorPane charEditor) {
		charEditor.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		charEditor.setStyle("-fx-font-size: 16;");
		Tab tabChar = new Tab("Character");
		tabChar.setGraphic(ImageUtil.loadIconChar());
		
		Tab tabInv = new Tab("Inventory");
		tabInv.setGraphic(ImageUtil.loadIconInventory());
		
		Tab tabSettings = new Tab("Settings");
		tabSettings.setGraphic(ImageUtil.loadIconOptions());
		charEditor.getTabs().addAll(tabChar, tabInv, tabSettings);
	}

	public static TextField loadTfName() {
		TextField tf = new TextField();
		tf.setEditable(false);
		return tf;
	}
}
