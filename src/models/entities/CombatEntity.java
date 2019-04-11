package models.entities;

import stats.Abilities;
import stats.Stat;
import stats.Statistics;

public abstract class CombatEntity extends Entity {
	private static final long serialVersionUID = 1L;
	protected Statistics stats;
//	protected Inventory inv;
	
	public CombatEntity(String name, Statistics stats) {
		super(name);
		this.stats = stats;
	}

	public CombatEntity(String name, Stat abilityPts, Abilities abils) {
		super(name);
		this.stats = new Statistics(abilityPts, abils);
	}

	public Statistics getStats() {
		return stats;
	}

	@Override
	public String toString() {
		return "CombatEntity [" + super.toString() + ", stats=" + stats + "]";
	}
}
