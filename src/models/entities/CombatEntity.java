package models.entities;

import models.statistics.Attributes;
import models.statistics.Level;
import models.statistics.Statistics;

public abstract class CombatEntity extends Entity {
	protected Statistics stats;

	public CombatEntity(String name, Level lvl, Attributes attribs) {
		super(name);
		this.stats = new Statistics(lvl, attribs);
	}

	public CombatEntity(String name, Attributes attribs) {
		super(name);
		this.stats = new Statistics(attribs);
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
