package utilties.statistics;

import scene.control.attributeDialer.AttributeDial;
import scene.control.attributeDialer.CharismaDial;
import scene.control.attributeDialer.ConsitutionDial;
import scene.control.attributeDialer.DexterityDial;
import scene.control.attributeDialer.IntelligenceDial;
import scene.control.attributeDialer.StrengthDial;
import scene.control.attributeDialer.WisdomDial;
import scene.layout.CharacterBuilderPane;
import utilties.character.CharacterBuilderPaneUtil;

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
