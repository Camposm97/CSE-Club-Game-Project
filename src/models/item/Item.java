package models.item;

import models.entities.Entity;

public abstract class Item extends Entity {
	private static final long serialVersionUID = 1L;

	public Item(String name) {
		super(name);
	}	
}
