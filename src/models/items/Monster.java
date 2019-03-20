package models.items;

import models.Attributes;
import models.Level;
import models.entities.CombatEntity;

public abstract class Monster extends CombatEntity {

	public Monster(String name, Attributes attribs) {
		super(name, attribs);
	}

	public Monster(String name, Level lvl, Attributes attribs) {
		super(name, lvl, attribs);
	}
}
