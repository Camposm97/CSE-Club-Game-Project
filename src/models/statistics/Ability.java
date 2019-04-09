package models.statistics;

import java.io.Serializable;

public abstract class Ability implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int score;
	
	public static int computeModifier(int score) {
		double modifier = (score - 10) / 2.0;
		if (modifier % 1 != 0)
			modifier -= 0.5;
		return (int) modifier;
	}
	
	public static String computeModifier(String score) {
		int modifier = computeModifier(Integer.parseInt(score));
		if (modifier > 0)
			return "+" + modifier;
		else 
			return "" + modifier;
	}
	
	public Ability(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getModifier() {
		return computeModifier(String.valueOf(score));
	}
}
