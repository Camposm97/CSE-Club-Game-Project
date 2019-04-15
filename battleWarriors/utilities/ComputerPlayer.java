package utilities;

import java.util.Random;

import models.Battle;
import models.Enemy;

public class ComputerPlayer {
	
	Battle battle;
	
	public ComputerPlayer(Battle battle){
		this.battle = battle;
		
	}
	public void makeRandomMove() {
		Random rand = new Random();
		
		battle.makeMove(this.battle.getEnemy().getAttacks().getAttack(rand.nextInt(this.battle.getEnemy().getAttacks().getNumOfAttacks())), this.battle.getPlayerStats(), this.battle.getPlayerBuffs(), this.battle.getEnemyStats(), this.battle.getEnemyBuffs());
	}

}
