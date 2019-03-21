package utilties.statistics;

public class LevelUtil {
	public static final int DEFAULT_LEVEL = 1;
	public static final int XP_TO_NEXT_LVL = 3;
	
	public static int calcXpToNextLvl(int lvl) {
		return (int) (3 * Math.pow(lvl + 2, 3)) / 4;
	}
}
