package scene.layout;

import javafx.scene.layout.GridPane;
import scene.control.AbilityDialBag;
import statistics.Abilities;
import utilties.AbilitiesViewerUtil;

public class AbilitiesViewer extends GridPane {
	private AbilityDialBag dialBag;

	public AbilitiesViewer(CharacterBuilderPane charPane) {
		this.dialBag = new AbilityDialBag(charPane);
		AbilitiesViewerUtil.displayControls(this);
	}

	public Abilities getAbilities() {
		return new Abilities(dialBag.getStrDial().getAbilityScore(), dialBag.getDexDial().getAbilityScore(),
				dialBag.getConDial().getAbilityScore(), dialBag.getIntDial().getAbilityScore(),
				dialBag.getWisDial().getAbilityScore(), dialBag.getChaDial().getAbilityScore());
	}

	public AbilityDialBag getDialBag() {
		return dialBag;
	}
}
