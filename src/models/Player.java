package models;

import java.io.Serializable;

public class Player extends Entity implements Serializable {
	private static final long serialVersionUID = 1763320657859320071L;
	private Level level;
	private Attributes attributes;
	private String backStory;

	public Player(String name, Attributes attributes, String backStory) {
		super(name);
		this.level = new Level(1);
		this.attributes = attributes;
		this.backStory = backStory;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public String getBackStory() {
		return backStory;
	}
	
	public void setBackStory(String backStory) {
		this.backStory = backStory;
	}

	
}
