package models.entities;

import models.statistics.Statistics;

public class Player extends CombatEntity {
	private static final long serialVersionUID = 1L;
	private String backStory;

	public Player(String name, Statistics stats, String backStory) {
		super(name, stats);
		this.backStory = backStory;
	}

	public String getBackStory() {
		return backStory;
	}
	
	public void setBackStory(String backStory) {
		this.backStory = backStory;
	}

	@Override
	public String toString() {
		return "Player [" + super.toString() + ", backStory=" + backStory + "]";
	}
}
