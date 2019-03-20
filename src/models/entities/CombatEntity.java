package models.entities;

import models.Attributes;
import models.Level;

public abstract class CombatEntity extends Entity {
	protected Level lvl;
	protected Attributes attribs;

	public CombatEntity(String name, Level lvl, Attributes attribs) {
		super(name);
		this.lvl = lvl;
		this.attribs = attribs;
	}

	public CombatEntity(String name, Attributes attribs) {
		super(name);
		this.lvl = new Level();
		this.attribs = attribs;
	}

	public Level getLvl() {
		return lvl;
	}

	public void setLvl(Level lvl) {
		this.lvl = lvl;
	}

	public Attributes getAttribs() {
		return attribs;
	}

	public void setAttribs(Attributes attribs) {
		this.attribs = attribs;
	}

	@Override
	public String toString() {
		return "CombatEntity [" + super.toString() + ", lvl=" + lvl + ", attribs=" + attribs + "]";
	}
}
