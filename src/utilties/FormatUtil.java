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
						p.getStats().getAbils().getAbilStr().getScore(),
						p.getStats().getAbils().getAbilDex().getScore(),
						p.getStats().getAbils().getAbilCon().getScore(),
						p.getStats().getAbils().getAbilInt().getScore(),
						p.getStats().getAbils().getAbilWis().getScore(),
						p.getStats().getAbils().getAbilCha().getScore());
	}
}
