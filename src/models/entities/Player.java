package models.entities;

import java.io.Serializable;

import models.Attributes;
import models.Level;

public class Player extends CombatEntity implements Serializable {
	private static final long serialVersionUID = 1763320657859320071L;
	private String backStory;

	public Player(String name, Attributes attribs, String backStory) {
		super(name, attribs);
		this.lvl = new Level();
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
