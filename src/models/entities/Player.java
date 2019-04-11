package models.entities;

import stats.Abilities;

public class Player extends CombatEntity {
	private static final long serialVersionUID = 1L;
	private String backStory;

	public Player(String name, Abilities abils, String backStory) {
		super(name, abils);
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
