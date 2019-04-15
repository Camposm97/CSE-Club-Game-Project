package models;

import java.io.Serializable;

public class Stats implements Serializable {
	/**
	 * Attribute
	 */
	private static final long serialVersionUID = 3862654899932037826L;
	private Stat level;
	private Stat maxHP;
	private Stat currentHP;
	private Stat maxEnergy;
	private Stat currentEnergy;
	private Stat stamina;// *************
	private Stat strength;
	private Stat defense;
	private Stat magic;
	private Stat resistance;
	private Stat speed;
	private Stat skill;
	private Stat crit;
	private Stat accuracy;
	private Stat avoidance;

	// the constructor uses by the character builder. some stats are automatically
	// filled

	public Stats(int stamina, int strength, int defense, int magic, int resistance, int speed) {
		this.level = new Stat("Level", 1);
		this.stamina = new Stat("Stamina", stamina);
		this.strength = new Stat("Strength", strength);
		this.defense = new Stat("Defense", defense);
		this.magic = new Stat("Magic", magic);
		this.resistance = new Stat("Resistance", resistance);
		this.speed = new Stat("Speed", speed);
		this.skill = new Stat("Skill", 0);
		this.maxHP = new Stat("Health");
		this.calculateHealth();
		this.currentHP = new Stat("Current Health");
		this.maxEnergy = new Stat("Energy");
		this.calculateEnergy();
		this.currentEnergy = new Stat("Current Energy");
		this.accuracy = new Stat("Accuracy");
		this.calculateAccuracy();
		this.avoidance = new Stat("Avoidance");
		this.calculateAvoidance();
		this.crit = new Stat("Critical Hit");
		this.calculateCrit();
		this.resetResources();
	}

	// constructor with full control over customizing stats
	public Stats(int level, int maxHP, int currentHP, int maxEnergy, int currentEnergy, int stamina, int strength,
			int defense, int magic, int resistance, int speed, int skill, int crit, int accuracy, int avoidance) {
		this.level = new Stat("Level", level);
		this.maxHP = new Stat("Health", maxHP);
		this.currentHP = new Stat("Current Health", currentHP);
		this.maxEnergy = new Stat("Energy", maxEnergy);
		this.currentEnergy = new Stat("Current Energy", currentEnergy);
		this.stamina = new Stat("Stamina", stamina);
		this.strength = new Stat("Strength", strength);
		this.defense = new Stat("Defense", defense);
		this.magic = new Stat("Magic", magic);
		this.resistance = new Stat("Resistance", resistance);
		this.speed = new Stat("Speed", speed);
		this.skill = new Stat("Skill", 0);
		this.crit = new Stat("Critical Hit", crit);
		this.accuracy = new Stat("Accuracy", accuracy);
		this.avoidance = new Stat("Avoidance", avoidance);

	}

	// default stat modifiers
	public Stats() {
		this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

	}

	public Stats(Stats stats) {
		this(stats.getLevel().getValue(), 
				stats.getMaxHP().getValue(), 
				stats.getCurrentHP().getValue(),
				stats.getMaxEnergy().getValue(), 
				stats.getCurrentEnergy().getValue(), 
				stats.getStamina().getValue(),
				stats.getStrength().getValue(), 
				stats.getDefense().getValue(), 
				stats.getMagic().getValue(),
				stats.getResistance().getValue(),
				stats.getSpeed().getValue(),
				stats.getSkill().getValue(),
				stats.getCrit().getValue(),
				stats.getAccuracy().getValue(), 
				stats.getAvoidance().getValue());
		this.resetResources();
	}

	public void checkResourceCaps() {
		if (this.currentEnergy.getValue() > this.maxEnergy.getValue()) {
			this.currentEnergy.setValue(this.maxEnergy.getValue());
		}
		if (this.currentHP.getValue() > this.maxHP.getValue()) {
			this.currentHP.setValue(this.maxHP.getValue());
		}
	}

	public void resetResources() {
		this.currentHP.setValue(this.maxHP.getValue());
		this.currentEnergy.setValue(this.maxEnergy.getValue());
	}

	public void calculateHealth() {
		this.maxHP.setValue((this.level.getValue() * 4) + (this.stamina.getValue() * 4) + (this.defense.getValue() * 1)
				+ (this.resistance.getValue() * 1) + 5);

	}

	public void calculateEnergy() {
		this.maxEnergy.setValue(this.level.getValue() + this.stamina.getValue() + this.magic.getValue()
				+ this.strength.getValue() + this.speed.getValue());
	}

	public void calculateCrit() {
		this.crit.setValue(5 + ((int) (this.speed.getValue() * .2) - 1) + ((int) (this.skill.getValue() * .5)));
	}

	public void calculateAvoidance() {
		this.avoidance.setValue(5 + ((int) (this.speed.getValue() * .2) - 1) + ((int) (this.skill.getValue() * .5)));
	}

	public void calculateAccuracy() {
		this.accuracy.setValue(90 + ((int) (this.skill.getValue() * .2)));
	}
	public double getPercentHealth() {
		return (double)this.getCurrentHP().getValue() / (double)this.getMaxHP().getValue();
		
	}
	public double getPercentEnergy() {
		return (double)this.getCurrentEnergy().getValue() / (double)this.getMaxEnergy().getValue();
		
	}
	public void calculateSecondaryStats() {
		calculateHealth();
		calculateEnergy();
		calculateCrit();
		calculateAvoidance();
		calculateAccuracy();
		resetResources();
	}

	public void combine(Stats stats) {
	
		this.getStamina().modifyValue(stats.getStamina().getValue());
		this.getStrength().modifyValue(stats.getStrength().getValue());
		this.getDefense().modifyValue(stats.getDefense().getValue());
		this.getMagic().modifyValue(stats.getMagic().getValue());
		this.getResistance().modifyValue(stats.getResistance().getValue());
		this.getSpeed().modifyValue(stats.getSpeed().getValue());
		this.getSkill().modifyValue(stats.getSkill().getValue());
	
		
	}

	public void setAllStats(int mod) {
		this.maxHP.setValue(mod);
		this.maxEnergy.setValue(mod);
		this.strength.setValue(mod);
		this.defense.setValue(mod);
		this.magic.setValue(mod);
		this.resistance.setValue(mod);
		this.speed.setValue(mod);
		this.crit.setValue(mod);
		this.accuracy.setValue(mod);
		this.skill.setValue(mod);
		this.avoidance.setValue(mod);

		checkResourceCaps();
	}

	public void changeAllStats(int mod) {
		this.maxHP.modifyValue(mod);
		this.currentHP.modifyValue(mod);
		this.maxEnergy.modifyValue(mod);
		this.currentEnergy.modifyValue(mod);
		this.stamina.modifyValue(mod);
		this.strength.modifyValue(mod);
		this.defense.modifyValue(mod);
		this.magic.modifyValue(mod);
		this.resistance.modifyValue(mod);
		this.speed.modifyValue(mod);
		this.crit.modifyValue(mod);
		this.accuracy.modifyValue(mod);
		this.skill.modifyValue(mod);
		this.avoidance.modifyValue(mod);

		checkResourceCaps();
	}
	public void changeAllStats(Stats stats) {
		
		this.maxHP.modifyValue(stats.getMaxHP().getValue());
		this.currentHP.modifyValue(stats.getCurrentHP().getValue());
		this.maxEnergy.modifyValue(stats.getMaxEnergy().getValue());
		this.currentEnergy.modifyValue(stats.getCurrentEnergy().getValue());
		this.stamina.modifyValue(stats.getStamina().getValue());
		this.strength.modifyValue(stats.getStrength().getValue());
		this.defense.modifyValue(stats.getDefense().getValue());
		this.magic.modifyValue(stats.getMagic().getValue());
		this.resistance.modifyValue(stats.getResistance().getValue());
		this.speed.modifyValue(stats.getSpeed().getValue());
		this.crit.modifyValue(stats.getCrit().getValue());
		this.accuracy.modifyValue(stats.getAccuracy().getValue());
		this.skill.modifyValue(stats.getSkill().getValue());
		this.avoidance.modifyValue(stats.getAvoidance().getValue());

		checkResourceCaps();
	}

	public Stat getLevel() {
		return level;
	}

	public void setLevel(Stat level) {
		this.level = level;
	}

	public Stat getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(Stat maxHP) {
		this.maxHP.setValue(maxHP.getValue());
	}

	public Stat getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(Stat currentHP) {
		this.currentHP.setValue(currentHP.getValue());
	}
	public void reduceHP (int i) {
		this.currentHP.setValue(currentHP.getValue() - i) ;
	}
	public Stat getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(Stat maxEnergy) {
		this.maxEnergy.setValue(maxEnergy.getValue());
	}

	public Stat getCurrentEnergy() {
		return currentEnergy;
	}

	public void setCurrentEnergy(Stat currentEnergy) {
		this.currentEnergy.setValue(currentEnergy.getValue());
	}

	public Stat getStamina() {
		return stamina;
	}

	public void setStamina(Stat stamina) {
		this.stamina .setValue(stamina.getValue());
	}

	public Stat getStrength() {
		return strength;
	}

	public void setStrength(Stat strength) {
		this.strength .setValue(strength.getValue());
	}

	public Stat getDefense() {
		return defense;
	}

	public void setDefense(Stat defense) {
		this.defense .setValue(defense.getValue());
	}

	public Stat getMagic() {
		return magic;
	}

	public void setMagic(Stat magic) {
		this.magic .setValue(magic.getValue());
	}

	public Stat getResistance() {
		return resistance;
	}

	public void setResistance(Stat resistance) {
		this.resistance .setValue(resistance.getValue());
	}

	public Stat getSpeed() {
		return speed;
	}

	public void setSpeed(Stat speed) {
		this.speed .setValue(speed.getValue());
	}

	public Stat getSkill() {
		return skill;
	}

	public void setSkill(Stat skill) {
		this.skill.setValue( skill.getValue());
	}

	public Stat getCrit() {
		return crit;
	}

	public void setCrit(Stat crit) {
		this.crit .setValue(crit.getValue());
	}

	public Stat getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Stat accuracy) {
		this.accuracy.setValue(accuracy.getValue());
	}

	public Stat getAvoidance() {
		return avoidance;
	}

	public void setAvoidance(Stat avoidance) {
		this.avoidance.setValue(avoidance.getValue());
	}

}
