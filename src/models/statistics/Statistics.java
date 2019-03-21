package models.statistics;

public class Statistics {
	private Level lvl;
	private Attributes attribs;
	
	public Statistics(Level lvl, Attributes attribs) {
		this.lvl = lvl;
		this.attribs = attribs;
	}
	
	public Statistics(Attributes attribs) {
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
		return "Statistics [lvl=" + lvl + ", attribs=" + attribs + "]";
	}
}