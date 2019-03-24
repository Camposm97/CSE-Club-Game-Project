package models.statistics;

import java.io.Serializable;

public class Abilities implements Serializable {
	private Strength strength;
	private Dexterity dexerity;
	private Constitution constition;
	private Intelligence intelligence;
	private Wisdom wisdom;
	private Charisma charisma;
	
	public Abilities(int strScore, int dexScore, int conScore, int intScore, int wisScore, int chaScore) {
		this.strength = new Strength(strScore);
		this.dexerity = new Dexterity(dexScore);
		this.constition = new Constitution(conScore);
		this.intelligence = new Intelligence(intScore);
		this.wisdom = new Wisdom(wisScore);
		this.charisma = new Charisma(chaScore);
	}

	public Strength getStrength() {
		return strength;
	}

	public void setStrength(Strength strength) {
		this.strength = strength;
	}

	public Dexterity getDexerity() {
		return dexerity;
	}

	public void setDexerity(Dexterity dexerity) {
		this.dexerity = dexerity;
	}

	public Constitution getConstition() {
		return constition;
	}

	public void setConstition(Constitution constition) {
		this.constition = constition;
	}

	public Intelligence getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(Intelligence intelligence) {
		this.intelligence = intelligence;
	}

	public Wisdom getWisdom() {
		return wisdom;
	}

	public void setWisdom(Wisdom wisdom) {
		this.wisdom = wisdom;
	}

	public Charisma getCharisma() {
		return charisma;
	}

	public void setCharisma(Charisma charisma) {
		this.charisma = charisma;
	}

	@Override
	public String toString() {
		return "Abilities [strength=" + strength + ", dexerity=" + dexerity + ", constition=" + constition
				+ ", intelligence=" + intelligence + ", wisdom=" + wisdom + ", charisma=" + charisma + "]";
	}
}
