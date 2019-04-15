package models;

import java.io.Serializable;

public class Armor extends Item implements Serializable{
	
	private static final long serialVersionUID = -6414018878829230744L;
	private Stats stats;
	
	public Armor (int id, String name, String desc, Stats stats) {
		super (id, name, desc);
		this.stats = new Stats (stats);
	}
	
	public Armor (int id, String name, String desc, int level, int hp, int currenthp, int energy, int currentEnergy, int stamina, int strength, int defense, int magic, 
			int resistance, int speed,  int skill, int crit, int accuracy, int avoidance){
		
		super(id, name , desc);
		
		stats = new Stats (level, hp, currenthp, energy, currentEnergy, stamina, strength, defense, magic, resistance, speed, skill, crit, accuracy,  avoidance);
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}


}
