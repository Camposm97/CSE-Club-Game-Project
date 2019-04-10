package models.statistics;

import java.io.Serializable;

public class Statistics implements Serializable {
	private static final long serialVersionUID = 1L;
	private Level lvl;
	private Stat health, mana;
	private Abilities abilities;
	
	public Statistics(Level lvl, Abilities abilities) {
		this.lvl = lvl;
		this.abilities = abilities;
	}
	
	public Statistics(Abilities abilities) {
		this.lvl = new Level();
		this.abilities = abilities;
	}

	public Level getLvl() {
		return lvl;
	}

	public void setLvl(Level lvl) {
		this.lvl = lvl;
	}
	
	public Health getHealth() {
		return health;
	}
	
	public Mana getMana() {
		return mana;
	}

	public Abilities getAbilities() {
		return abilities;
	}

	public void setAbilities(Abilities abilities) {
		this.abilities = abilities;
	}
	
	public static void main(String[] args) {
		Statistics stats = new Statistics(new Abilities(1, 1, 1, 1, 1, 1));
		System.out.println(stats);
	}
}