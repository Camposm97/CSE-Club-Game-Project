package stats;

import java.io.Serializable;

public class Statistics implements Serializable {
	private static final long serialVersionUID = 1L;
	private Level level;
	private Stat abilityPts, hitPts, manaPts;
	private Abilities abils;
	
	public Statistics(Stat abilityPts, Abilities abils) {
		this.level = new Level(this);
	}
	
	public Statistics(int lvl, Stat abilityPts, Stat hitPts, Stat manaPts, Abilities abils) {
		this.level = new Level(lvl, this);
		
	}

	public Statistics(Stat abilityPts, Stat hitPts, Stat manaPts, Abilities abils) {
		this.level = new Level(this);
		
	}
	
	
}
