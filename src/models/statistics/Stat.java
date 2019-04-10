package models.statistics;

import java.io.Serializable;

public class Stat implements Serializable {
	private static final long serialVersionUID = 1L;
	private StatType type;
	private int totalPoints;
	private int currentPoints;

	public Stat(StatType type, int totalPoints, int currentPoints) {
		super();
		this.type = type;
		this.totalPoints = totalPoints;
		this.currentPoints = currentPoints;
	}

	public StatType getType() {
		return type;
	}

	public void setType(StatType type) {
		this.type = type;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public int getCurrentPoints() {
		return currentPoints;
	}

	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}

}
