package abilityScoreCalculator;

public class Demo {
	private static final int MAX_ATTR_POINT = 30;

	public static void main(String[] args) {
		displayAbiltiyScores();
	}

	public static void displayAbiltiyScores() {
		for (int i = -2; i <= MAX_ATTR_POINT; i++) {
			System.out.printf("%-3d | Ability Score: %-3.1f\n", i, computeAbilityScore(i));
		}
	}

	public static double computeAbilityScore(int num) {
		double score = (num - 10) / 2.0;
		if (score % 1 != 0)
			score -= 0.5;
		return score;
	}
}
