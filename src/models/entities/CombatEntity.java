package models.entities;

import models.statistics.Abilities;
import models.statistics.Level;
import models.statistics.Statistics;

public abstract class CombatEntity extends Entity {
	private static final long serialVersionUID = 1L;
	protected Statistics stats;
//	protected Inventory inv;
	
	public CombatEntity(String name, Level lvl, Abilities abilities) {
		super(name);
		this.stats = new Statistics(lvl, abilities);
	}

	public CombatEntity(String name, Abilities abilities) {
		super(name);
		this.stats = new Statistics(abilities);
	}
	
	public CombatEntity(String name, Statistics stats) {
		super(name);
		this.stats = stats;
	}

	public Statistics getStats() {
		return stats;
	}

	@Override
	public String toString() {
		return "CombatEntity [" + super.toString() + ", stats=" + stats + "]";
	}
}
