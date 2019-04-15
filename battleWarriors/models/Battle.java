package models;
import java.util.Random;

import utilities.ComputerPlayer;
import utilities.MonsterMaker;

public class Battle {
	
	Character player;
	Stats playerStats;
	
	Character enemy;
	Stats enemyStats;
	ComputerPlayer cpu;
	
	int turns;
	boolean inProgress;
	
	BattleBuffs playerBuffs;
	BattleBuffs enemyBuffs;
	
	Battle (Player player){
		
		this.player = player;
		playerStats = new Stats (player.calculateTotalStats());
		playerStats.getLevel().setValue(player.getBaseStats().getLevel().getValue());
		this.enemy = this.generateEnemy(player.getBaseStats().getLevel().getValue());
		enemyStats = new Stats (enemy.calculateTotalStats());
		enemyStats.getLevel().setValue(enemy.getBaseStats().getLevel().getValue());
		turns = 1;
		inProgress = true;
		cpu = new ComputerPlayer(this);
		
		playerBuffs = new BattleBuffs();
	
		enemyBuffs = new BattleBuffs();
	}
	
	public void startBattleLoop() {
		
			if (whoIsFaster() == 0){
				Random rand = new Random();
				if (rand.nextInt(2) == 0) {
					playerMove(1);
				}
				else {
					cpuMove(1);
				}
			}
			else if (whoIsFaster() == 1){
				playerMove(1);
			}
			else {
				cpuMove(1);
			}
		
	}
	
	public void playerMove(int firstOrSecond) {
		
		//sets the gui. the buttons in the gui will trigger the next step of the battle system.
		
		if (firstOrSecond == 1) {
			cpuMove(2);
		}
		else if (firstOrSecond == 2) {
			calculateBuffs();
			victoryCheck();
			turns++;
			this.startBattleLoop();
		}
		
	}
	public void cpuMove(int firstOrSecond) {
		
		cpu.makeRandomMove();
		this.victoryCheck();
		
		if (firstOrSecond == 1) {
			playerMove(2);
		}
		else if (firstOrSecond == 2) {
			calculateBuffs();
			victoryCheck();
			turns++;
			this.startBattleLoop();
		}
	}
	public void applyBuffs(Attack attack, Stats target, BattleBuffs targetBuff, Stats self, BattleBuffs selfBuff) {
		//debuffing target
		if (attack.getTargetBuff().getInitialBuff().getLevel().getValue() != 0) {
			target.changeAllStats(attack.getTargetBuff().getInitialBuff());
		}
		if (attack.getTargetBuff().getPeriodicBuff().getLevel().getValue() != 0 || attack.getTargetBuff().getFinalBuff().getLevel().getValue() != 0) {
			targetBuff.insertBuff(attack.getTargetBuff());
		}
		//buffing yourself
		if (attack.getSelfBuff().getInitialBuff().getLevel().getValue() != 0) {
			self.changeAllStats(attack.getSelfBuff().getInitialBuff());
		}
		if (attack.getTargetBuff().getPeriodicBuff().getLevel().getValue() != 0 || attack.getTargetBuff().getFinalBuff().getLevel().getValue() != 0) {
			selfBuff.insertBuff(attack.getSelfBuff());
		}
	}
	
	public void calculateBuffs() {
		
		for (int i = this.playerBuffs.getNumOfBuffs()- 1; i >= 0; i--) {
			this.playerStats.changeAllStats(this.playerBuffs.getBuffs()[i].getPeriodicBuff());
			this.playerBuffs.getBuffs()[i].progress();
			if (this.playerBuffs.getBuffs()[i].getCurrentProgress() == 0) {
				this.playerStats.changeAllStats(this.playerBuffs.getBuffs()[i].getFinalBuff());
				
				if (i == this.playerBuffs.getNumOfBuffs() - 1) {
					this.playerBuffs.decrimentBuffs();
				}
				else {
					for (int j = i; j < this.playerBuffs.getNumOfBuffs()- 1; j++) {
						this.playerBuffs.getBuffs()[j] = this.playerBuffs.getBuffs()[j+1];
						this.playerBuffs.decrimentBuffs();
					}
				}
			}
		}
		for (int i = this.enemyBuffs.getNumOfBuffs()- 1; i >= 0; i--) {
			this.enemyStats.changeAllStats(this.enemyBuffs.getBuffs()[i].getPeriodicBuff());
			this.enemyBuffs.getBuffs()[i].progress();
			if (this.enemyBuffs.getBuffs()[i].getCurrentProgress() == 0) {
				this.enemyStats.changeAllStats(this.enemyBuffs.getBuffs()[i].getFinalBuff());
				if (i == this.enemyBuffs.getNumOfBuffs() - 1) {
					this.enemyBuffs.decrimentBuffs();
				}
				else {
					for (int j = i; j < this.enemyBuffs.getNumOfBuffs()- 1; j++) {
						this.enemyBuffs.getBuffs()[j] = this.enemyBuffs.getBuffs()[j+1];
						this.enemyBuffs.decrimentBuffs();
					}
				}
			}
		}
	}
	//attack
	public void makeMove(Attack attack, Stats target, BattleBuffs targetBuffs, Stats self, BattleBuffs selfBuffs) {
		Random rand = new Random();
		if (accuracyCheck(attack, target, self)) {
			int critMod = this.critCheck(self);
			if (attack.getStrengthMultiplier() > 0) {
				
				int rawPhysicalDamage = ((critMod + attack.getStrengthMultiplier()) * (self.getStrength().getValue() + attack.getBonusDamage()))/100;
				int physicalDamage = rawPhysicalDamage - target.getDefense().getValue();
				if (physicalDamage < 0) {
					physicalDamage = 0;
				}
				target.reduceHP(physicalDamage);
			}
			
			if (attack.getMagicMultiplier() > 0) {
					
				int rawMagicDamage = ((critMod +attack.getMagicMultiplier()) * (self.getMagic().getValue() + attack.getBonusDamage()))/100;
				int magicDamage = rawMagicDamage - target.getResistance().getValue();
				if (magicDamage < 0) {
					magicDamage = 0;
				}
				target.reduceHP(magicDamage);
			}
			
			if (attack.getDoesBuffs()) {
				if (rand.nextInt(101) > attack.getBuffChance()) {
					applyBuffs(attack, target, targetBuffs, self, selfBuffs);
				}
			}
		}
	}
	//useItem
	public void makeMove(Consumable item, Stats target) {
		target.changeAllStats(item.getModifiers());
	}
	//skip a turn
	public void makeMove(Stats self) {
		self.getCurrentEnergy().modifyValue(1 + (self.getLevel().getValue() / 5));
	}
	//run
	public void makeMove() {
		
	}
	public void victoryCheck () {
		if (player.getBaseStats().getCurrentHP().getValue() <= 0) {
			looseBattle();
		}
		if (enemy.getBaseStats().getCurrentHP().getValue() <= 0) {
			winBattle();
		}
	}
	
	public void looseBattle() {
		
	}
	public void winBattle() {
		
	}
	
	public Enemy generateEnemy(int playerLevel) {
		Enemy enemy = null;
		MonsterMaker maker = new MonsterMaker();
		return enemy;
	}
	
	public int whoIsFaster() {
		if ((this.getPlayerStats().getSpeed().getValue() == (this.getEnemyStats().getSpeed().getValue()))){
			return 0;
		}
		else if ((this.getPlayerStats().getSpeed().getValue() == (this.getEnemyStats().getSpeed().getValue()))){
			return 1;
		}
		else {
			return -1;
		}
		
	}
	public boolean accuracyCheck(Attack attack, Stats target, Stats self) {
		Random rand = new Random();
		return ((self.getAccuracy().getValue() + attack.getAccuracy() - target.getAvoidance().getValue()) >= rand.nextInt(101));
	}
	public int critCheck (Stats self) {
		Random rand = new Random();
		int critMod = 0;
		if (rand.nextInt(101) <= self.getCrit().getValue()) {
			critMod = 50;
		}
		return critMod;
	}

	public Character getPlayer() {
		return player;
	}

	public void setPlayer(Character player) {
		this.player = player;
	}

	public Stats getPlayerStats() {
		return playerStats;
	}

	public void setPlayerStats(Stats playerStats) {
		this.playerStats = playerStats;
	}

	public Character getEnemy() {
		return enemy;
	}

	public void setEnemy(Character enemy) {
		this.enemy = enemy;
	}

	public Stats getEnemyStats() {
		return enemyStats;
	}

	public void setEnemyStats(Stats enemyStats) {
		this.enemyStats = enemyStats;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public BattleBuffs getPlayerBuffs() {
		return playerBuffs;
	}

	public void setPlayerBuffs(BattleBuffs playerBuffs) {
		this.playerBuffs = playerBuffs;
	}

	public BattleBuffs getEnemyBuffs() {
		return enemyBuffs;
	}

	public void setEnemyBuffs(BattleBuffs enemyBuffs) {
		this.enemyBuffs = enemyBuffs;
	}

}
