package models.statistics;

import java.io.Serializable;

public class Abilities implements Serializable {
	private Strength strength;
	private Dexterity dexterity;
	private Constitution constitution;
	private Intelligence intelligence;
	private Wisdom wisdom;
	private Charisma charisma;

	public Abilities(int strScore, int dexScore, int conScore, int intScore, int wisScore, int chaScore) {
		this.strength = new Strength(strScore);
		this.dexterity = new Dexterity(dexScore);
		this.constitution = new Constitution(conScore);
		this.intelligence = new Intelligence(intScore);
		this.wisdom = new Wisdom(wisScore);
		this.charisma = new Charisma(chaScore);
	}

	public Strength getStrength() {
		return strength;
	}

	public Dexterity getDexterity() {
		return dexterity;
	}

	public Constitution getConstitution() {
		return constitution;
	}

	public Intelligence getIntelligence() {
		return intelligence;
	}

	public Wisdom getWisdom() {
		return wisdom;
	}

	public Charisma getCharisma() {
		return charisma;
	}

	
	@Override
	public String toString() {
		return "Abilities [strength=" + strength + ", dexterity=" + dexterity + ", constitution=" + constitution
				+ ", intelligence=" + intelligence + ", wisdom=" + wisdom + ", charisma=" + charisma + "]";
	}
}
