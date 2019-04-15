package models;

public class BattleBuffs {

	Buff[] buffs;
	int numOfBuffs;
	
	public BattleBuffs() {
		super();
		this.buffs = new Buff[10];
		this.numOfBuffs = 0;
	}
	public void insertBuff(Buff buff) {
		buffs[numOfBuffs] = buff;
		numOfBuffs++;
	}
	public void decrimentBuffs () {
		numOfBuffs--;
	}

	public Buff[] getBuffs() {
		return buffs;
	}

	public void setBuffs(Buff[] buffs) {
		this.buffs = buffs;
	}

	public int getNumOfBuffs() {
		return numOfBuffs;
	}

	public void setNumOfBuffs(int numOfBuffs) {
		this.numOfBuffs = numOfBuffs;
	}
}
