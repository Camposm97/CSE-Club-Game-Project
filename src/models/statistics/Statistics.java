package models.statistics;

import java.io.Serializable;

public class Statistics implements Serializable {
	private static final long serialVersionUID = 1L;
	private Level lvl;
	private Stat abilityPts, hitPts, manaPts;
	private Abilities abils;

	public Statistics(Stat abilityPts, int totalHitPoints, int totalManaPoints, Abilities abils) {	// Default
		this.lvl = new Level(this);
		this.abilityPts = abilityPts;
		this.hitPts = new Stat(StatType.Health, totalHitPoints);
		this.manaPts = new Stat(StatType.Mana, totalManaPoints);
		this.abils = abils;
	}
	
	public Statistics(int totalAbilityPoints, int currentAbilityPoints, int totalHitPoints, int totalManaPoints, Abilities abils) {
		this.lvl = new Level(this);
		this.abilityPts = new Stat(StatType.Ability, totalAbilityPoints, currentAbilityPoints);
		this.hitPts = new Stat(StatType.Health, totalHitPoints);
		this.manaPts = new Stat(StatType.Mana, totalManaPoints);
		this.abils = abils;
	}

	public Level getLvl() {
		return lvl;
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
		return "Statistics [level=" + lvl + ", abilityPts=" + abilityPts + ", hitPts=" + hitPts + ", manaPts="
				+ manaPts + ", abils=" + abils + "]";
	}
}
