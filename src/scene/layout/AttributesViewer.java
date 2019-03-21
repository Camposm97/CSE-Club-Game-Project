package scene.layout;

import javafx.scene.layout.GridPane;
import scene.control.attributeDialer.AttributeDialBag;
import utilties.statistics.AttributesViewerUtil;

public class AttributesViewer extends GridPane {
	private AttributeDialBag dialBag;
	
	public AttributesViewer(CharacterBuilderPane charPane) {
		this.dialBag = new AttributeDialBag(charPane);
		AttributesViewerUtil.displayControls(this);
	}
	
	public AttributeDialBag getDialBag() {
		return dialBag;
	}
}
