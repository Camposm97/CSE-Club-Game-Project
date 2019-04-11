package statistics;

import java.io.Serializable;

public class Abilities implements Serializable {
	private static final long serialVersionUID = 1L;
	private Ability strength;
	private Ability dexterity;
	private Ability constitution;
	private Ability intelligence;
	private Ability wisdom;
	private Ability charisma;

	public Abilities(int strScore, int dexScore, int conScore, int intScore, int wisScore, int chaScore) {
		this.strength = new Ability(AbilityType.Strength, strScore);
		this.dexterity = new Ability(AbilityType.Dexterity, dexScore);
		this.constitution = new Ability(AbilityType.Constitution, conScore);
		this.intelligence = new Ability(AbilityType.Intelligence, intScore);
		this.wisdom = new Ability(AbilityType.Wisdom, wisScore);
		this.charisma = new Ability(AbilityType.Charisma, chaScore);
	}

	public Ability getStrength() {
		return strength;
	}

	public Ability getDexterity() {
		return dexterity;
	}

	public Ability getConstitution() {
		return constitution;
	}

	public Ability getIntelligence() {
		return intelligence;
	}

	public Ability getWisdom() {
		return wisdom;
	}

	public Ability getCharisma() {
		return charisma;
	}

	@Override
	public String toString() {
		return "Abilities [strength=" + strength + ", dexterity=" + dexterity + ", constitution=" + constitution
				+ ", intelligence=" + intelligence + ", wisdom=" + wisdom + ", charisma=" + charisma + "]";
	}
}
