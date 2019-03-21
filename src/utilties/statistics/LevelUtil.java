package utilties.statistics;

public class LevelUtil {
	public static final int DEFAULT_LEVEL = 1;
	
	public static int calcXpToNextLvl(int lvl) {
		return (int) (3 * Math.pow(lvl + 2, 3)) / 4;
	}
}
