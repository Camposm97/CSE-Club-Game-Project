package attrModifierCalculator;

public class Demo {
	private static final int MAX_ABIL_POINT = 50;

	public static void main(String[] args) {
		displayAttrModifiers();
	}
	
	/**
	 * Displays ability score and modifier from -4 to MAX_ABIL_POINT
	 */
	public static void displayAttrModifiers() {
		for (int i = -4; i <= MAX_ABIL_POINT; i++) {
			System.out.printf("%-3d | Modifier: %-3d\n", i, computeModifier(i));
		}
	}
	
	public static int computeModifier(int num) {
		double modifier = (num - 10) / 2.0;
		if (modifier % 1 != 0)
			modifier -= 0.5;
		return (int) modifier;
	}
}
