package models;

import utilties.LevelUtil;

public class Level {
	private short lvl;
	private int totalXp;
	private int xpToNextLvl;

	public Level(int lvl) {
		this.lvl = (short) lvl;
		this.totalXp = 0;
		this.xpToNextLvl = LevelUtil.calcXpToNextLvl(lvl);
	}

	public Level() {
		this.lvl = 1;
		this.totalXp = 0;
		this.xpToNextLvl = LevelUtil.calcXpToNextLvl(lvl);
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
			xpToNextLvl = LevelUtil.calcXpToNextLvl(lvl);
			System.out.println(toString());
		}
	}

	public void levelUp() { // Maybe for consumable item?
		lvl++;
		totalXp = xpToNextLvl;
		xpToNextLvl = LevelUtil.calcXpToNextLvl(lvl);
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
