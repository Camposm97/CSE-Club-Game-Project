package models;

import java.io.Serializable;

public class Weapon extends Item implements Serializable {
	private static final long serialVersionUID = -7315268583015396210L;
	private Stats mods;
	private int handsUsed; 
	
	public Weapon (int id, String name, String description, int hands) {
		
		super(id, name, description);
		setMods(new Stats());
		setHandsUsed(hands);
	}

	public Weapon (int id, String name, String description, Stats mod, int hands) {
		super(id, name, description);
		setMods(mod);
		setHandsUsed(hands);
	}
	public Weapon (int id, String name, String description, int level, int hp, int currenthp, int energy, int currentEnergy, int stamina, int strength, int defense, int magic, 
			int resistance, int speed, int skill, int crit, int accuracy,  int avoidance, int hands){
		
		super(id, name, description);
		setMods(new Stats (level, hp, currenthp, energy, currentEnergy, stamina, strength, defense, magic, resistance, speed, skill, crit, accuracy, avoidance));
		setHandsUsed(hands);
	}
	public Weapon (Weapon weapon){
		super(weapon.getId(), weapon.getName(), weapon.getDescription());
		setMods(weapon.getMods());
		handsUsed = weapon.getHandsUsed();
		
	}

	public int getHandsUsed() {
		return handsUsed;
	}

	public void setHandsUsed(int handsUsed) {
		this.handsUsed = handsUsed;
	}

	public Stats getMods() {
		return mods;
	}

	public void setMods(Stats mods) {
		this.mods = mods;
	}

}
