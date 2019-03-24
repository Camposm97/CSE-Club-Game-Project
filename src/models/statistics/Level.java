package models.statistics;

import java.io.Serializable;

public class Level implements Serializable {
	public static final byte DEFAULT_LEVEL = 1;
	private short lvl;
	private int totalXp;
	private int xpToNextLvl;
	
	public static int calcXpToNextLvl(int lvl) {	// Level Up Formula
		return (int) (3 * Math.pow(lvl + 2, 3)) / 4;
	}
	
	public Level(int lvl) {
		this.lvl = (short) lvl;
		this.totalXp = 0;
		this.xpToNextLvl =calcXpToNextLvl(lvl);
	}

	public Level() {
		this.lvl = DEFAULT_LEVEL;
		this.totalXp = 0;
		this.xpToNextLvl = calcXpToNextLvl(lvl);
	}

	public int getLvl() {
		return lvl;
	}

	public int getTotalXp() {
		return totalXp;
	}

	public void addXp(int xp) {
		this.totalXp += xp;
		while (getRequiredXp() <= 0) {
			lvl++;
			xpToNextLvl = calcXpToNextLvl(lvl);
			System.out.println(toString());
		}
	}

	public void levelUp() { // Maybe for consumable item?
		lvl++;
		totalXp = xpToNextLvl;
		xpToNextLvl = calcXpToNextLvl(lvl);
		System.out.println(toString());
	}

	public int getXpToNextLvl() {
		return xpToNextLvl;
	}

	public int getRequiredXp() { // Returns XP required to level up
		return (xpToNextLvl - totalXp);
	}
	
	@Override
	public String toString() {
		return "Level [lvl=" + lvl + ", totalXp=" + totalXp + ", xpToNextLvl=" + xpToNextLvl + "]";
	}
}
