package models.statistics;

import java.io.Serializable;

public class Statistics implements Serializable {
	private Level lvl;
	private Abilities abilities;
	
	public Statistics(Level lvl, Abilities attribs) {
		this.lvl = lvl;
		this.abilities = attribs;
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

	public Abilities getAbilities() {
		return abilities;
	}

	public void setAbilities(Abilities abilities) {
		this.abilities = abilities;
	}

	@Override
	public String toString() {
		return "Statistics [lvl=" + lvl + ", abilities=" + abilities + "]";
	}
}