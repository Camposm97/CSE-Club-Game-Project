package models;

import java.io.Serializable;

public class Buff implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6787989538509885429L;
	private String name;
	private String description;
	
	private Stats initialBuff;
	private Stats periodicBuff;
	private Stats finalBuff;
	
	private int duration;
	private int currentProgress;
	
	public Buff(String name, String description, Stats initialBuff, Stats periodicBuff, Stats finalBuff, int duration) {
		super();
		this.name = name;
		this.description = description;
		
		this.initialBuff = initialBuff;
		this.periodicBuff = periodicBuff;
		this.finalBuff = finalBuff;

		this.duration = duration;
		this.currentProgress = duration;
	}
	
	public Buff(Buff buff) {
		super();
		this.name = new String(buff.getName());
		this.description = new String(buff.getDescription());
		this.initialBuff = new Stats(buff.getInitialBuff());
		this.periodicBuff = new Stats(buff.getPeriodicBuff());
		this.finalBuff = new Stats(buff.getFinalBuff());
		this.duration = buff.getDuration();
		this.currentProgress = this.duration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void progress () {
		currentProgress--;
	}
	public void resetBuff () {
		currentProgress = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCurrentProgress() {
		return currentProgress;
	}
	public void setCurrentProgress(int currentProgress) {
		this.currentProgress = currentProgress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Stats getInitialBuff() {
		return initialBuff;
	}

	public void setInitialBuff(Stats initialBuff) {
		this.initialBuff = initialBuff;
	}

	public Stats getPeriodicBuff() {
		return periodicBuff;
	}

	public void setPeriodicBuff(Stats periodicBuff) {
		this.periodicBuff = periodicBuff;
	}

	public Stats getFinalBuff() {
		return finalBuff;
	}

	public void setFinalBuff(Stats finalBuff) {
		this.finalBuff = finalBuff;
	}
	
	
}
