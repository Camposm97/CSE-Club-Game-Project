package models;

import java.io.Serializable;

public class Character extends Entity implements Serializable{
	private static final long serialVersionUID = 6571925932595290113L;
	private Stats baseStats;
	private Inventory inventory;
	private AttackList attacks;
	
	// create a blank character for editing 
	Character (){
		super();
		baseStats = new Stats(1, 1, 1, 1, 1, 1);
		
	}
	//creates a new character constructor with chosen stats, but no modifiers or equipment
	Character(String name, String description, int level, int hp, int currentHp, int energy, int currentEnergy, int stamina, int strength, int defense, int magic, int resistance,
			int speed, int crit, int accuracy, int skill, int avoidance) {
		
		super(name, description);
		this.baseStats = new Stats( level, hp, currentHp, energy, currentEnergy, stamina, strength, defense, magic, resistance, speed, crit, accuracy, skill, avoidance);
		this.inventory = new Inventory();
		this.attacks = new AttackList();
		
	}
	//creates a new character with default stats, no modifiers, and no equipment
	Character (String name, String description){
		super(name, description);
		this.baseStats = new Stats(1, 1, 1, 1, 1, 1);
		this.inventory = new Inventory();
		this.attacks = new AttackList();
	}
	//creates a new character with pre-made stats, modifiers, and inventory
	Character (String name, String description, Stats stats, Stats mods, Inventory inventory){
		super(name, description);
		this.baseStats = stats;
		this.inventory = inventory;
		this.attacks = new AttackList();
	}
	//creates a new character by copying another pre-made character
	Character (Character character){
		super(character.getName(), character.getDescription());
		this.baseStats = new Stats(character.getBaseStats());
		this.inventory = character.getInventory();
		this.attacks = character.getAttacks();
	}
	public Stats calculateTotalStats() {
		Stats temp = new Stats();
		
		temp.getLevel().setValue(this.getBaseStats().getLevel().getValue());
		temp.combine(this.getBaseStats());
		
		for (int i = 0; i < this.getInventory().getWeapons().length; i++) {
			try {
				temp.combine(this.getInventory().getWeapons()[i].getMods());
			}
			catch (Exception ex) {
				
			}
			
		}
		for (int i = 0; i < this.getInventory().getArmor().length; i++) {
			try {
				temp.combine(this.getInventory().getArmor()[i].getStats());
			}
		
			catch (Exception ex) {
			}
		}
		temp.calculateSecondaryStats();
		
		return temp;
		
		
	}
	public Stats getBaseStats() {
		return baseStats;
	}
	public void setBaseStats(Stats baseStats) {
		this.baseStats = baseStats;
	}
		

	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void setName (String name) {
		super.setName(name);
	}
	public String getName () {
		return super.getName();
	}
	
	public void setBackstory(String desc) {
		super.setDescription(desc);
	}
	public String getBackStory () {
		return super.getDescription();
	}
	
	public AttackList getAttacks() {
		return attacks;
	}
	public void setAttacks(AttackList attacks) {
		this.attacks = attacks;
	}
	

}
