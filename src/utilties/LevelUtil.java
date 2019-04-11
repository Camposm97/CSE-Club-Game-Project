package utilties;

import statistics.Level;
import statistics.Stat;
import statistics.Statistics;

public class LevelUtil {
	public static final byte DEFAULT_LVL = 1;
	
	public static void levelUp(Level level) {
		level.levelUp();
		level.getStats().getAbilityPts().addToTotal(Die.rollD4());
		addHitPoints(level.getStats());
		addManaPoints(level.getStats());
	}
	
	public static void autoLevelUp(Level level) {
		level.autoLevelUp();
		level.getStats().getAbilityPts().addToTotal(Die.rollD4());
		addHitPoints(level.getStats());
		addManaPoints(level.getStats());
	}
	
	public static void addHitPoints(Statistics stats) {
		Stat stat = stats.getHitPts();
		int bonus = stats.getAbils().getConstitution().getModifier();
		if (bonus > 0)
			stat.addToTotal(Die.rollD10() + bonus);
		else
			stat.addToTotal(Die.rollD10());
		stat.resetCurrent();
	}
	
	public static void addManaPoints(Statistics stats) {
		Stat stat = stats.getManaPts();
		int bonus = stats.getAbils().getIntelligence().getModifier();
		if (bonus > 0)
			stat.addToTotal(Die.rollD10() + bonus);
		else
			stat.addToTotal(Die.rollD10());
		stat.resetCurrent();
	}
}
