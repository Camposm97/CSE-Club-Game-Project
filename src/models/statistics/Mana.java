package models.statistics;

import java.io.Serializable;

public class Mana implements Serializable {
	private static final long serialVersionUID = 1L;
	private int totalManaPoints, currentManaPoints;

	public Mana(int totalManaPoints, int currentManaPoints) {
		super();
		this.totalManaPoints = totalManaPoints;
		this.currentManaPoints = currentManaPoints;
	}

	public int getTotalManaPoints() {
		return totalManaPoints;
	}

	public void setTotalManaPoints(int totalManaPoints) {
		this.totalManaPoints = totalManaPoints;
	}

	public int getCurrentManaPoints() {
		return currentManaPoints;
	}

	public void setCurrentManaPoints(int currentManaPoints) {
		this.currentManaPoints = currentManaPoints;
	}

	@Override
	public String toString() {
		return "Mana [totalManaPoints=" + totalManaPoints + ", currentManaPoints=" + currentManaPoints + "]";
	}
}
