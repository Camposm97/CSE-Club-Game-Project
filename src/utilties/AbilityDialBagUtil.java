package utilties;

import scene.control.AbilityDial;
import scene.control.CharismaDial;
import scene.control.ConsitutionDial;
import scene.control.DexterityDial;
import scene.control.IntelligenceDial;
import scene.control.StrengthDial;
import scene.control.WisdomDial;
import scene.layout.PlayerBuilderPane;

public class AbilityDialBagUtil {	
	public static AbilityDial[] loadAttributeDial(PlayerBuilderPane charPane) {
		AbilityDial[] arr = {new StrengthDial(charPane), new DexterityDial(charPane), new ConsitutionDial(charPane), 
				new IntelligenceDial(charPane), new WisdomDial(charPane), new CharismaDial(charPane)};
		return arr;
	}
	
	public static boolean hasNoPointsInvested(AbilityDial dial) {
		return Integer.parseInt(dial.getTfScore().getText()) <= CharBuilderUtil.INIT_ABILITY_SCORE;
	}
	
	public static boolean hasPointsInvested(AbilityDial dial) {
		return Integer.parseInt(dial.getTfScore().getText()) > CharBuilderUtil.INIT_ABILITY_SCORE;
	}
}
