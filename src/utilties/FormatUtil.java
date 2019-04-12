package utilties;

import models.entities.Player;

public class FormatUtil {
	/**
	 * Normally used to display Player's info when the user is choosing a Player to
	 * load from.
	 */
	public static String format(Player p) {
		return p.getName() + "\n" + String.format("LVL %-10s\t", p.getStats().getLvl().getLvl())
				+ String.format("STR: %-12s DEX: %-12s CON: %-12s INT: %-12s WIS: %-12s CHA: %-12s",
						p.getStats().getAbils().getStrength().getScore(),
						p.getStats().getAbils().getDexterity().getScore(),
						p.getStats().getAbils().getConstitution().getScore(),
						p.getStats().getAbils().getIntelligence().getScore(),
						p.getStats().getAbils().getWisdom().getScore(),
						p.getStats().getAbils().getCharisma().getScore());
	}
}
