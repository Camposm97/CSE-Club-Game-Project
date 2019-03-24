package models.entities;

import models.statistics.Abilities;

public class Player extends CombatEntity {
	private String backStory;

	public Player(String name, Abilities attribs, String backStory) {
		super(name, attribs);
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
