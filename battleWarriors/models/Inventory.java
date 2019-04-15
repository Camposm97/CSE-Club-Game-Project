package models;

import java.io.Serializable;

public class Inventory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6412421920555286128L;
	private int bagSize;
	private Item[] bag;
	private Weapon[] weapons;
	private int handsUsed;
	private Armor[] armor;
	private int money;
	
	Inventory (int bagSize){
		this.bagSize = bagSize;
		bag = new Item[bagSize];
		weapons = new Weapon[2];
		handsUsed = 0;
		armor = new Armor[6];
		money = 0;
	}
	Inventory () {
		this(30);
	}
	Inventory (Item[] bag, Weapon[] weapons, Armor[] armor, int money){
		bagSize = bag.length;
		this.bag = bag;
		this.weapons = weapons;
		this.armor = armor;
		this.money = money;
	}
	public int getBagSize() {
		return bagSize;
	}
	public void setBagSize(int bagSize) {
		this.bagSize = bagSize;
	}
	public Item[] getBag() {
		return bag;
	}
	public void setBag(Item[] bag) {
		this.bag = bag;
	}
	public Weapon[] getWeapons() {
		return weapons;
	}
	public void setWeapons(Weapon[] weapons) {
		this.weapons = weapons;
	}
	public int getHandsUsed() {
		return handsUsed;
	}
	public void setHandsUsed(int handsUsed) {
		this.handsUsed = handsUsed;
	}
	public Armor[] getArmor() {
		return armor;
	}
	public void setArmor(Armor[] armor) {
		this.armor = armor;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
