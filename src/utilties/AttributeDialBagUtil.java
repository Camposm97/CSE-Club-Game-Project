package utilties;

import controller.attributeDialers.AttributeDial;
import controller.attributeDialers.CharismaDial;
import controller.attributeDialers.ConsitutionDial;
import controller.attributeDialers.DexterityDial;
import controller.attributeDialers.IntelligenceDial;
import controller.attributeDialers.StrengthDial;
import controller.attributeDialers.WisdomDial;
import view.CharacterBuilderPane;

public class AttributeDialBagUtil {	
	public static AttributeDial[] loadAttributeDial(CharacterBuilderPane charPane) {
		AttributeDial[] arr = {new StrengthDial(charPane), new DexterityDial(charPane), new ConsitutionDial(charPane), 
				new IntelligenceDial(charPane), new WisdomDial(charPane), new CharismaDial(charPane)};
		return arr;
	}
	
	public static boolean hasNoPointsInvested(AttributeDial dial) {
		return Integer.parseInt(dial.getTfNum().getText()) <= CharacterBuilderPaneUtil.INIT_VALUE;
	}
	
	public static boolean hasPointsInvested(AttributeDial dial) {
		return Integer.parseInt(dial.getTfNum().getText()) > CharacterBuilderPaneUtil.INIT_VALUE;
	}
}
