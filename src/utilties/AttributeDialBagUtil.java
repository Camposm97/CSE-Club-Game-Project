package utilties;

import attributeDialers.AttributeDial;
import attributeDialers.CharismaDial;
import attributeDialers.ConsitutionDial;
import attributeDialers.DexterityDial;
import attributeDialers.IntelligenceDial;
import attributeDialers.StrengthDial;
import attributeDialers.WisdomDial;
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
