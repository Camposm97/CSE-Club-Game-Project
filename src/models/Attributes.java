package models;

public class Attributes {
	private int strength;
	private int dexterity;
	private int constituion;
	private int intelligence;
	private int wisdom;	
	private int charisma;
	
	public Attributes(int strength, int dexterity, int constituion, int intelligence, int wisdom, int charisma) {
		this.strength = strength;
		this.dexterity = dexterity;
		this.constituion = constituion;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
	}

	public int getStr() {
		return strength;
	}

	public void setStr(int strength) {
		this.strength = strength;
	}

	public int getDex() {
		return dexterity;
	}

	public void setDex(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getCon() {
		return constituion;
	}

	public void setCon(int constituion) {
		this.constituion = constituion;
	}

	public int getInt() {
		return intelligence;
	}

	public void setInt(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getWis() {
		return wisdom;
	}

	public void setWis(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCha() {
		return charisma;
	}

	public void setCha(int charisma) {
		this.charisma = charisma;
	}

	@Override
	public String toString() {
		return "Attributes [strength=" + strength + ", dexterity=" + dexterity + ", constituion=" + constituion
				+ ", intelligence=" + intelligence + ", wisdom=" + wisdom + ", charisma=" + charisma + "]";
	}
}
