package models;

import java.io.Serializable;

public class Consumable extends Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 967900365606332671L;
	Stats modifiers;

	Consumable(int id, String name, String description, Stats stats) {
		
		super(id, name, description);
		this.modifiers = new Stats(stats);
	}

	public Stats getModifiers() {
		return modifiers;
	}

	public void setModifiers(Stats modifiers) {
		this.modifiers = modifiers;
	}
	

}
