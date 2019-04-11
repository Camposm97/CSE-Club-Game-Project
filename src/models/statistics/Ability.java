package models.statistics;

import java.io.Serializable;

public class Ability implements Serializable {
	private static final long serialVersionUID = 1L;
	private AbilityType type;
	private int score;
	
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
	
	public Ability(AbilityType type, int score) {	// Default Constructor
		this.type = type;
		this.score = score;
	}

	public AbilityType getType() {
		return type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getModifier() {
		return computeModifier(score);
	}
	
	@Override
	public String toString() {
		return "Ability [type=" + type + ", score=" + score + "]";
	}
}
