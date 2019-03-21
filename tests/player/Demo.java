package player;

import models.entities.Player;
import models.statistics.Attributes;

public class Demo {

	public static void main(String[] args) {
		Player p1 = new Player("Michael", new Attributes(1, 2, 3, 4, 5, 6), "Null");
		System.out.println("Name: " + p1.getName());
		System.out.println("Stats: " + p1.getStats());
		System.out.println("Backstory: " + p1.getBackStory());
		System.out.println("XP Required: " + p1.getStats().getLvl().getRequiredXp());
	}
}
