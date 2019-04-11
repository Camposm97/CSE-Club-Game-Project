package statistics;

import java.io.Serializable;

public class Stat implements Serializable {
	private static final long serialVersionUID = 1L;
	protected StatType type;
	protected int totalPoints;
	protected int currentPoints;

	public Stat(StatType type, int totalPoints, int currentPoints) {
		this.type = type;
		this.totalPoints = totalPoints;
		this.currentPoints = currentPoints;
	}
	
	public Stat(StatType type, int totalPoints) {
		this.type = type;
		this.totalPoints = totalPoints;
		this.currentPoints = totalPoints;
	}

	public StatType getType() {
		return type;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public int getCurrentPoints() {
		return currentPoints;
	}
	
	public void addToTotal(int n) {
		totalPoints += n;
	}
	
	public void addToCurrent(int n) {
		currentPoints += n;
	}
	
	public void minusFromCurrent(int n) {
		currentPoints -= n;
	}
	
	public void resetCurrent() {
		currentPoints = totalPoints;
	}

	@Override
	public String toString() {
		return "Stat [type=" + type + ", totalPoints=" + totalPoints + ", currentPoints=" + currentPoints + "]";
	}
}
