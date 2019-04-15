package models;

import java.io.Serializable;

public class Player extends Character implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 985619489594705796L;
	private int xpUntilLevel;
	private int currentXP;
	private int statPoints;
	private int battlesWon;

	public Player (){
		super();
		xpUntilLevel = 15;
		currentXP = 0;
		statPoints = 5;
		battlesWon = 0;
	}

	public int getXpUntilLevel() {
		return xpUntilLevel;
	}

	public void setXpUntilLevel(int xpUntilLevel) {
		this.xpUntilLevel = xpUntilLevel;
	}

	public int getCurrentXP() {
		return currentXP;
	}

	public void setCurrentXP(int currentXP) {
		this.currentXP = currentXP;
	}

	public int getStatPoints() {
		return statPoints;
	}

	public void setStatPoints(int StatPoints) {
		this.statPoints = StatPoints;
	}

	public int getBattlesWon() {
		return battlesWon;
	}

	public void setBattlesWon(int battlesWon) {
		this.battlesWon = battlesWon;
	}
	

}
