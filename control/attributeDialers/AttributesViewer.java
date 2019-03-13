package attributeDialers;

import javafx.scene.layout.GridPane;
import utilties.AttributesViewerUtil;
import view.CharacterBuilderPane;

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
