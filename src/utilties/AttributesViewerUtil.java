package utilties;

import controller.attributeDialers.AttributesViewer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class AttributesViewerUtil {
	public static void displayControls(AttributesViewer pane) {
		pane.setAlignment(Pos.CENTER_LEFT);
		pane.setHgap(10);
		pane.add(loadLblAttrType(), 0, 0);
//		pane.add(loadLblDesc(), 1, 0);
		
		for (int i = 0; i < pane.getDialBag().size(); i++) {
			int j = i + 1;
			pane.add(pane.getDialBag().get(i).getLblAttr(), 0, j);
//			pane.add(pane.getDialBag().get(i).getLblDesc(), 1, j);
			pane.add(pane.getDialBag().get(i), 1, j);
		}
	}
	
	public static Label loadLblAttrType() {
		Label lbl = new Label("Attribute Type:");
		lbl.setStyle("-fx-underline: true");
		return lbl;
	}
	
	public static Label loadLblDesc() {
		Label lbl = new Label("Description:");
		lbl.setStyle("-fx-underline: true");
		return lbl;
	}
}
