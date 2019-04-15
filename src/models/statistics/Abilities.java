package models.statistics;

import java.io.Serializable;

public class Abilities implements Serializable {
	private static final long serialVersionUID = 1L;
	private Ability abilStr;
	private Ability abilDex;
	private Ability abilCon;
	private Ability abilInt;
	private Ability abilWis;
	private Ability abilCha;

	public Abilities(int strScore, int dexScore, int conScore, int intScore, int wisScore, int chaScore) {
		this.abilStr = new Ability(AbilityType.Strength, strScore);
		this.abilDex = new Ability(AbilityType.Dexterity, dexScore);
		this.abilCon = new Ability(AbilityType.Constitution, conScore);
		this.abilInt = new Ability(AbilityType.Intelligence, intScore);
		this.abilWis = new Ability(AbilityType.Wisdom, wisScore);
		this.abilCha = new Ability(AbilityType.Charisma, chaScore);
	}

	public Ability getAbilStr() {
		return abilStr;
	}

	public Ability getAbilDex() {
		return abilDex;
	}

	public Ability getAbilCon() {
		return abilCon;
	}

	public Ability getAbilInt() {
		return abilInt;
	}

	public Ability getAbilWis() {
		return abilWis;
	}

	public Ability getAbilCha() {
		return abilCha;
	}

	@Override
	public String toString() {
		return "Abilities [abilStr=" + abilStr + ", abilDex=" + abilDex + ", abilCon=" + abilCon + ", abilInt="
				+ abilInt + ", abilWis=" + abilWis + ", abilCha=" + abilCha + "]";
	}
}
