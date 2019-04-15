package models;

import java.io.Serializable;

public class Attack implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2407849367439099572L;
	private int ID;
	private String name;
	private String description;

	private int uses;
	private int usesLeft;
	private int energyCost;
	
	private int strengthMultiplier;
	private int magicMultiplier;
	private int bonusDamage;
	private int accuracy;
	private int crit;
	
	private Buff targetBuff;
	private Buff selfBuff;
	private boolean doesBuffs;
	private int buffChance;
	
	public Attack (int ID, String name, String description, int strengthMultiplier, int magicMultiplier, int bonusDamage, int accuracy, int crit,  int uses, int energyCost, Buff target, Buff self, boolean doesBuffs, int buffChance){
		
		this.ID = ID;
		this.name = new String(name);
		this.description = new String(description);
		
		this.strengthMultiplier = strengthMultiplier;
		this.magicMultiplier = magicMultiplier;
		this.bonusDamage = bonusDamage;
		this.accuracy = accuracy;
		this.crit = crit;
		this.uses = uses;
		this.usesLeft = uses;
		this.energyCost = energyCost;
		
		this.targetBuff = new Buff(target);
		this.selfBuff = new Buff(self);
		this.doesBuffs = doesBuffs;
		this.buffChance = buffChance;
	}

	public Attack (Attack attack) {
		
		this.ID = attack.getID();
		this.name = attack.getName();
		this.description = attack.getName();
		
		this.strengthMultiplier = attack.getStrengthMultiplier();
		this.magicMultiplier = attack.getMagicMultiplier();
		this.bonusDamage = attack.getBonusDamage();
		this.accuracy = attack.getAccuracy();
		this.crit = attack.getCrit();
		this.uses = attack.getUses();
		this.usesLeft = attack.getUses();
		this.energyCost = attack.getEnergyCost();
		
		this.targetBuff = new Buff(attack.getTargetBuff());
		this.selfBuff = new Buff(attack.getSelfBuff());
		this.doesBuffs = attack.getDoesBuffs();
		this.buffChance = attack.getBuffChance();
	}
	public Attack (){
		this.name = "fail";
	}
	public void resetUses () {
		this.usesLeft = this.uses;
	}
	public void modifyUses (int mod) {
		this.usesLeft += mod; 
		checkUsesCap();
	}
	public void checkUsesCap () {
		if (this.usesLeft > this.uses) {
			this.usesLeft = this.uses;
		}
		if (this.usesLeft < 0) {
			this.usesLeft = 0;
		}
	}
	public int compareByID (Attack attack) {
		if (this.getID() < attack.getID()) {
			return -1;
		}
		else if (this.getID() > attack.getID()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int compareByStrength (Attack attack) {
		if (this.getStrengthMultiplier()> attack.getStrengthMultiplier()) {
			return -1;
		}
		else if (this.getStrengthMultiplier() < attack.getStrengthMultiplier()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int compareByMagic (Attack attack) {
		if (this.getMagicMultiplier() > attack.getMagicMultiplier() ) {
			return -1;
		}
		else if (this.getMagicMultiplier()  < attack.getMagicMultiplier() ) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public String attackToString () {
		String temp = "";
		if (this.doesBuffs = true) {
			temp += "does buffs";
		}
		return (this.ID + " :\t" + this.name + "\t" + this.getStrengthMultiplier() + " strength\t" + this.getMagicMultiplier() + " magic\t" +  temp);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	public Buff getTargetBuff() {
		return targetBuff;
	}

	public void setTargetBuff(Buff targetBuff) {
		this.targetBuff = targetBuff;
	}

	public Buff getSelfBuff() {
		return selfBuff;
	}

	public void setSelfBuff(Buff selfBuff) {
		this.selfBuff = selfBuff;
	}

	public int getUses() {
		return uses;
	}
	public void setUses(int uses) {
		this.uses = uses;
	}

	public int getUsesLeft() {
		return usesLeft;
	}
	public void setUsesLeft(int usesLeft) {
		this.usesLeft = usesLeft;
		checkUsesCap();
	}

	public int getEnergyCost() {
		return energyCost;
	}
	public void setEnergyCost(int energyCost) {
		this.energyCost = energyCost;
	}


	public int getStrengthMultiplier() {
		return strengthMultiplier;
	}
	public void setStrengthMultiplier(int strengthMultiplier) {
		this.strengthMultiplier = strengthMultiplier;
	}
	public int getMagicMultiplier() {
		return magicMultiplier;
	}
	public void setMagicMultiplier(int magicMultiplier) {
		this.magicMultiplier = magicMultiplier;
	}
	public int getBonusDamage() {
		return bonusDamage;
	}
	public void setBonusDamage(int bonusDamage) {
		this.bonusDamage = bonusDamage;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public int getCrit() {
		return crit;
	}
	public void setCrit(int crit) {
		this.crit = crit;
	}
	public boolean getDoesBuffs() {
		return doesBuffs;
	}
	public void setDoesBuffs(boolean doesBuffs) {
		this.doesBuffs = doesBuffs;
	}

	public int getBuffChance() {
		return buffChance;
	}
	public void setBuffChance(int buffChance) {
		this.buffChance = buffChance;
	}

}
