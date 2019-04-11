package utilties;

import models.entities.Player;

public class FormatUtil {
	/**
	 * Normally used to display Player's info when the user is choosing a Player to
	 * load from.
	 */
	public static String format(Player p) {
		return p.getName() + "\n" + String.format("LVL %-10s\t", p.getStats().getLvl().getLvl())
				+ String.format("STR: %-12sDEX: %-12sCON: %-12sINT: %-12sWIS: %-12sCHA: %-12s",
						p.getStats().getAbilities().getStrength().getScore(),
						p.getStats().getAbilities().getDexterity().getScore(),
						p.getStats().getAbilities().getConstitution().getScore(),
						p.getStats().getAbilities().getIntelligence().getScore(),
						p.getStats().getAbilities().getWisdom().getScore(),
						p.getStats().getAbilities().getCharisma().getScore());
	}
}
