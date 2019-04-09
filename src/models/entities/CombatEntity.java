package models.entities;

import models.statistics.Abilities;
import models.statistics.Level;
import models.statistics.Statistics;

public abstract class CombatEntity extends Entity {
	private static final long serialVersionUID = 1L;
	protected Statistics stats;
//	protected EquipmentBag equipBag;

	public CombatEntity(String name, Level lvl, Abilities abilities) {
		super(name);
		this.stats = new Statistics(lvl, abilities);
	}

	public CombatEntity(String name, Abilities abilities) {
		super(name);
		this.stats = new Statistics(abilities);
	}

	public Statistics getStats() {
		return stats;
	}

	public void setStats(Statistics stats) {
		this.stats = stats;
	}

	@Override
	public String toString() {
		return "CombatEntity [" + super.toString() + ", stats=" + stats + "]";
	}
}
