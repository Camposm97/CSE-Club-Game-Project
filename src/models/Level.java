package models;

import utilties.LevelUtil;

public class Level {
	private int lvl;
	private int totalXp;
	private int xpToNextLvl;
	
	public Level(int lvl) {
		this.lvl = lvl;
		this.totalXp = 0;
		this.xpToNextLvl = LevelUtil.XP_TO_NEXT_LVL;
	}
	
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public int getTotalXp() {
		return totalXp;
	}
	public void setTotalXp(int totalXp) {
		this.totalXp = totalXp;
	}
	public int getXpToNextLvl() {
		return xpToNextLvl;
	}
	public void setXpToNextLvl(int xpToNextLvl) {
		this.xpToNextLvl = xpToNextLvl;
	}

	@Override
	public String toString() {
		return "Current Level: " + lvl;
	}
}
