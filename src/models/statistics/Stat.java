package models.statistics;

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
	
	public void addToCurrent(int amount) {
		if ((currentPoints + amount) >= totalPoints)
			currentPoints = totalPoints;
		else
			currentPoints += amount;
	}
	
	public void minusFromCurrent(int amount) {
		currentPoints -= amount;
	}
	
	public void resetCurrent() {
		currentPoints = totalPoints;
	}
	
	public boolean isCurrentEmpty() {
		return currentPoints <= 0;
	}
	
	public boolean isCurrentFull() {
		return currentPoints >= totalPoints;
	}
	
	public double getPercentage() {
		return (double) currentPoints / totalPoints;
	}

	@Override
	public String toString() {
		return "Stat [type=" + type + ", totalPoints=" + totalPoints + ", currentPoints=" + currentPoints + "]";
	}
}
