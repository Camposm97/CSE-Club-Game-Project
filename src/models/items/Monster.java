package models.items;

import models.entities.CombatEntity;
import models.statistics.Attributes;
import models.statistics.Level;

public abstract class Monster extends CombatEntity {

	public Monster(String name, Attributes attribs) {
		super(name, attribs);
	}

	public Monster(String name, Level lvl, Attributes attribs) {
		super(name, lvl, attribs);
	}
}
