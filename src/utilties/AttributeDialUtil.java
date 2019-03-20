package utilties;

import controller.attributeDialers.AttributeDial;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

public class AttributeDialUtil {	
	public static void displayControls(AttributeDial pane) {
		pane.getLblAttr().setTooltip(new Tooltip(pane.getLblDesc().getText()));
		pane.setAlignment(Pos.CENTER);
		HBox hBox = FXUtil.asHBox(0, Pos.CENTER, pane.getBtMinus(), pane.getTfNum(), pane.getBtPlus());
		hBox.setPadding(new Insets(2.5));
		pane.add(hBox, 0, 0);
	}
	
	public static TextField loadTfNum() {
		TextField tf = new TextField(CharacterBuilderPaneUtil.INIT_VALUE.toString());
		tf.setEditable(false);
		tf.setAlignment(Pos.CENTER);
		tf.setPrefColumnCount(2);
		return tf;
	}
}
