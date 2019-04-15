package models;

import java.io.Serializable;

public class Enemy extends Character implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8266467201329757102L;
	int[] loot; 
	int experience;
	
	public Enemy(String name, String description, int level, int hp, int currentHp, int energy, int currentEnergy, int stamina, int strength, int defense, int magic, int resistance,
			int speed, int crit, int accuracy, int skill, int avoidance, int[] loot, int xpBonus) {
		
		super(name, description, level, hp, currentHp, energy, currentEnergy, stamina, strength, defense, magic, resistance, speed, crit, accuracy, skill, avoidance);
		this.loot = loot;
		this.experience = level + strength + magic + xpBonus;
	}
	public Enemy(){
		
	}

}
