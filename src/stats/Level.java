package stats;

import java.io.Serializable;

public class Level implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final byte DEFAULT_LVL = 1;
	private int lvl;
	private int totalXp;
	private int xpToNextLvl;
	private Statistics stats;
	
	public Level(Statistics stats) {
		this.lvl = DEFAULT_LVL;
		this.xpToNextLvl = calcXpToNextLvl(lvl);
		this.stats = stats;
	}
	
	public Level(int lvl, Statistics stats) {
		this.lvl = lvl;
		this.xpToNextLvl = calcXpToNextLvl(lvl);
		this.stats = stats;
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
			
//			System.out.println("Level Up! " + toString());
		}
	}

//	public void levelUp() { // Maybe for consumable item?
//		lvl++;
//		totalXp = xpToNextLvl;
//		xpToNextLvl = calcXpToNextLvl(lvl);
//		System.out.println(toString());
//	}
	
	public int getXpToNextLvl() {
		return xpToNextLvl;
	}

	public int getRequiredXp() { // Returns XP required to level up
		return (xpToNextLvl - totalXp);
	}
	
	public static int calcXpToNextLvl(int lvl) {	// Level Up Formula
		return (int) (3 * Math.pow(lvl + 2, 3)) / 4;
	}

	@Override
	public String toString() {
		return "Level [lvl=" + lvl + ", totalXp=" + totalXp + ", xpToNextLvl=" + xpToNextLvl + ", stats=" + stats + "]";
	}
}
