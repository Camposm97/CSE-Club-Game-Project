package statistics;

import java.io.Serializable;

public class Statistics implements Serializable {
	private static final long serialVersionUID = 1L;
	private Level level;
	private Stat abilityPts, hitPts, manaPts;
	private Abilities abils;

	public Statistics(Stat abilityPts, int totalHitPoints, int totalManaPoints, Abilities abils) {	// Default
		this.level = new Level(this);
		this.abilityPts = abilityPts;
		this.hitPts = new Stat(StatType.Health, totalHitPoints);
		this.manaPts = new Stat(StatType.Mana, totalManaPoints);
		this.abils = abils;
	}
	
	public Statistics(int totalAbilityPoints, int currentAbilityPoints, int totalHitPoints, int totalManaPoints, Abilities abils) {
		this.level = new Level(this);
		this.abilityPts = new Stat(StatType.Ability, totalAbilityPoints, currentAbilityPoints);
		this.hitPts = new Stat(StatType.Health, totalHitPoints);
		this.manaPts = new Stat(StatType.Mana, totalManaPoints);
		this.abils = abils;
	}

	public Level getLevel() {
		return level;
	}

	public Stat getAbilityPts() {
		return abilityPts;
	}

	public Stat getHitPts() {
		return hitPts;
	}

	public Stat getManaPts() {
		return manaPts;
	}

	public Abilities getAbils() {
		return abils;
	}

	@Override
	public String toString() {
		return "Statistics [level=" + level + ", abilityPts=" + abilityPts + ", hitPts=" + hitPts + ", manaPts="
				+ manaPts + ", abils=" + abils + "]";
	}
}
