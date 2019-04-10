package models.statistics;

import java.io.Serializable;

public class Health implements Serializable {
	private static final long serialVersionUID = 1L;
	private int totalHitPoints, currentHitPoints;

	public Health(int totalHitPoints, int currentHitPoints) {
		super();
		this.totalHitPoints = totalHitPoints;
		this.currentHitPoints = currentHitPoints;
	}

	public int getTotalHitPoints() {
		return totalHitPoints;
	}

	public void setTotalHitPoints(int totalHitPoints) {
		this.totalHitPoints = totalHitPoints;
	}

	public int getCurrentHitPoints() {
		return currentHitPoints;
	}

	public void setCurrentHitPoints(int currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}

	@Override
	public String toString() {
		return "Health [totalHitPoints=" + totalHitPoints + ", currentHitPoints=" + currentHitPoints + "]";
	}
}
