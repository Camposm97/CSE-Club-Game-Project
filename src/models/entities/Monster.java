package models.entities;

import models.statistics.Abilities;
import models.statistics.Level;

public abstract class Monster extends CombatEntity {
	private static final long serialVersionUID = 1L;

	public Monster(String name, Abilities attribs) {
		super(name, attribs);
	}

	public Monster(String name, Level lvl, Abilities attribs) {
		super(name, lvl, attribs);
	}
}
