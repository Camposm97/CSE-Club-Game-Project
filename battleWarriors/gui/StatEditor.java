package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import models.Player;
import models.Stats;

public class StatEditor {
	private static int skillPoints;
	private static int skillPointsUsed;
	private static int skillPointCap;
	private StatButton staminaButton;
	private StatButton strengthButton;
	private StatButton defenseButton;
	private StatButton magicButton;
	private StatButton resistanceButton;
	private StatButton speedButton;
	private StatButton skillButton;
	private Label level;
	private Label hp;
	private Label energy;
	private Label stamina;
	private Label strength;
	private Label defense;
	private Label magic;
	private Label resistance;
	private Label speed;
	private Label skill;
	private Label crit;
	private Label accuracy;
	private Label avoidance;
	private Label skillPointsLabelLeft;
	private Label levelLabel;
	private Label hpLabel;
	private Label energyLabel;
	private Label critLabel;
	private Label accuracyLabel;
	private Label avoidanceLabel;
	private Label skillPointsLabelRight;
	private static Stats tempStats;
	
	public StatEditor (Player player, GUISettings settings) {
		int width = settings.getHeight();
		int height = settings.getHeight();
		Font font = settings.getFont();
		skillPoints = player.getStatPoints();
		skillPointsUsed = 0;
		skillPointCap = ((int)(player.getBaseStats().getLevel().getValue() * .12)) + 2;
		tempStats = new Stats(player.getBaseStats());
		buildButtons(tempStats, settings, this);
		buildRightLabels(settings);
		buildLeftLabels(settings);
	}
	public void buildLeftLabels(GUISettings settings) {
		int width = settings.getWidth();
		int height = settings.getHeight();
		Font font = settings.getFont();
		level = new Label ("Level: ");
			level.setMinHeight(height * .04);
			level.setFont(font);
		hp = new Label ("Hit Points: ");
			hp.setMinHeight(height * .04);
			hp.setFont(font);
		energy = new Label ("Energy Points: ");
			energy.setMinHeight(height * .04);
			energy.setFont(font);
		stamina = new Label ("Stamina: ");
			stamina.setMinHeight(height * .04);
			stamina.setFont(font);
		strength = new Label ("Strength: ");
			strength.setMinHeight(height * .04);
			strength.setFont(font);
		defense = new Label ("Defense: ");
			defense.setMinHeight(height * .04);
			defense.setFont(font);
		magic = new Label ("Magic: ");
			magic.setMinHeight(height * .04);
			magic.setFont(font);
		resistance = new Label ("Resistance: ");
			resistance.setMinHeight(height * .04);
			resistance.setFont(font);
		speed = new Label ("Speed: ");
			speed.setMinHeight(height * .04);
			speed.setFont(font);
		skill = new Label ("Skill: ");
			skill.setMinHeight(height * .04);
			skill.setFont(font);
		crit = new Label ("Critical Hit: ");
			crit.setMinHeight(height * .04);
			crit.setFont(font);
		accuracy = new Label ("Accuracy: ");
			accuracy.setMinHeight(height * .04);
			accuracy.setFont(font);
		avoidance = new Label ("Avoidance: ");
			avoidance.setMinHeight(height * .04);
			avoidance.setFont(font);
		skillPointsLabelLeft = new Label ("Skill Points: ");
			skillPointsLabelLeft.setMinHeight(height * .04);
			skillPointsLabelLeft.setFont(font);
	}
	public void buildRightLabels(GUISettings settings) {
		int width = settings.getWidth();
		int height = settings.getHeight();
		Font font = settings.getFont();
		levelLabel = new Label("" + getTempStats().getLevel().getValue());
		levelLabel.setMinSize(width * .3, height * .04);
		levelLabel.setAlignment(Pos.CENTER);
		levelLabel.setFont(font);
		hpLabel = new Label (getTempStats().getCurrentHP().getValue() + "/" + getTempStats().getMaxHP().getValue());
		hpLabel.setMinSize(width * .3, height * .04);
		hpLabel.setAlignment(Pos.CENTER);
		hpLabel.setFont(font);
		energyLabel = new Label (getTempStats().getCurrentEnergy().getValue() + "/" + getTempStats().getMaxEnergy().getValue());
		energyLabel.setMinSize(width * .3, height * .04);
		energyLabel.setAlignment(Pos.CENTER);
		energyLabel.setFont(font);
		critLabel = new Label ("" + getTempStats().getCrit().getValue());
		critLabel.setMinSize(width * .3, height * .04);
		critLabel.setAlignment(Pos.CENTER);
		critLabel.setFont(font);
		accuracyLabel = new Label ("" + getTempStats().getAccuracy().getValue());
		accuracyLabel.setMinSize(width * .3, height * .04);
		accuracyLabel.setAlignment(Pos.CENTER);
		accuracyLabel.setFont(font);
		avoidanceLabel = new Label ("" + getTempStats().getAvoidance().getValue());
		avoidanceLabel.setMinSize(width * .3, height * .04);
		avoidanceLabel.setAlignment(Pos.CENTER);
		avoidanceLabel.setFont(font);
		skillPointsLabelRight = new Label ("" + getSkillPoints());
		skillPointsLabelRight.setMinSize(width * .3, height * .04);
		skillPointsLabelRight.setAlignment(Pos.CENTER);
		skillPointsLabelRight.setFont(font);
	}
	public void buildButtons (Stats tempStats, GUISettings settings, StatEditor editor) {
	
		staminaButton = new StatButton(tempStats.getStamina(), settings, editor);
		strengthButton = new StatButton(tempStats.getStrength(), settings, editor);
		defenseButton = new StatButton(tempStats.getDefense(), settings, editor);
		magicButton = new StatButton(tempStats.getMagic(), settings, editor);
		resistanceButton = new StatButton(tempStats.getResistance(), settings, editor);
		speedButton = new StatButton(tempStats.getSpeed(), settings, editor);
		skillButton = new StatButton(tempStats.getSkill(), settings, editor);
		
	}
	public void updateStatEditor() {
		staminaButton.getValue().setText("" + tempStats.getStamina().getValue());
		staminaButton.buttonEnabler();
		strengthButton.getValue().setText("" + tempStats.getStrength().getValue());
		strengthButton.buttonEnabler();
		defenseButton.getValue().setText("" + tempStats.getDefense().getValue());
		defenseButton.buttonEnabler();
		magicButton.getValue().setText("" + tempStats.getMagic().getValue());
		magicButton.buttonEnabler();
		resistanceButton.getValue().setText("" + tempStats.getResistance().getValue());
		resistanceButton.buttonEnabler();
		speedButton.getValue().setText("" + tempStats.getSpeed().getValue());
		speedButton.buttonEnabler();
		skillButton.getValue().setText("" + tempStats.getSkill().getValue());
		skillButton.buttonEnabler();
		levelLabel.setText("" + tempStats.getLevel().getValue());
		tempStats.calculateAccuracy();
		tempStats.calculateAvoidance();
		tempStats.calculateCrit();
		tempStats.calculateEnergy();
		tempStats.calculateHealth();
		tempStats.resetResources();
		hpLabel.setText(getTempStats().getCurrentHP().getValue() + "/" + getTempStats().getMaxHP().getValue());
		energyLabel.setText(getTempStats().getCurrentEnergy().getValue() + "/" + getTempStats().getMaxEnergy().getValue());
		critLabel.setText("" + tempStats.getCrit().getValue());
		accuracyLabel.setText("" + tempStats.getAccuracy().getValue());
		avoidanceLabel.setText("" + tempStats.getAvoidance().getValue());
		skillPointsLabelRight.setText("" + (StatEditor.getSkillPoints() - StatEditor.getSkillPointsUsed()));
	}
	public static int getSkillPoints() {
		return skillPoints;
	}
	public static void setSkillPoints(int skillPoints) {
		StatEditor.skillPoints = skillPoints;
	}
	public static void modifySkillPoints (int mod) {
		StatEditor.skillPoints += mod;
	}
	public static int getSkillPointsUsed() {
		return skillPointsUsed;
	}
	public static void setSkillPointsUsed(int skillPointsUsed) {
		StatEditor.skillPointsUsed = skillPointsUsed;
	}
	public static void modifySkillPointsUsed (int mod) {
		StatEditor.skillPointsUsed += mod;
	}
	public static int getSkillPointCap() {
		return skillPointCap;
	}
	public static void setSkillPointCap(int skillPointCap) {
		StatEditor.skillPointCap = skillPointCap;
	}
	public StatButton getStaminaButton() {
		return staminaButton;
	}
	public void setStaminaButton(StatButton staminaButton) {
		this.staminaButton = staminaButton;
	}
	public StatButton getStrengthButton() {
		return strengthButton;
	}
	public void setStrengthButton(StatButton strengthButton) {
		this.strengthButton = strengthButton;
	}
	public StatButton getDefenseButton() {
		return defenseButton;
	}
	public void setDefenseButton(StatButton defenseButton) {
		this.defenseButton = defenseButton;
	}
	public StatButton getMagicButton() {
		return magicButton;
	}
	public void setMagicButton(StatButton magicButton) {
		this.magicButton = magicButton;
	}
	public StatButton getResistanceButton() {
		return resistanceButton;
	}
	public void setResistanceButton(StatButton resistanceButton) {
		this.resistanceButton = resistanceButton;
	}
	public StatButton getSpeedButton() {
		return speedButton;
	}
	public void setSpeedButton(StatButton speedButton) {
		this.speedButton = speedButton;
	}
	public StatButton getSkillButton() {
		return skillButton;
	}
	public void setSkillButton(StatButton skillButton) {
		this.skillButton = skillButton;
	}
	public static Stats getTempStats() {
		return tempStats;
	}
	public static void setTempStats(Stats tempStats) {
		StatEditor.tempStats = tempStats;
	}
	public Label getLevelLabel() {
		return levelLabel;
	}
	public void setLevelLabel(Label levelLabel) {
		this.levelLabel = levelLabel;
	}
	public Label getHpLabel() {
		return hpLabel;
	}
	public void setHpLabel(Label hpLabel) {
		this.hpLabel = hpLabel;
	}
	public Label getEnergyLabel() {
		return energyLabel;
	}
	public void setEnergyLabel(Label energyLabel) {
		this.energyLabel = energyLabel;
	}
	public Label getCritLabel() {
		return critLabel;
	}
	public void setCritLabel(Label critLabel) {
		this.critLabel = critLabel;
	}
	public Label getAccuracyLabel() {
		return accuracyLabel;
	}
	public void setAccuracyLabel(Label accuracyLabel) {
		this.accuracyLabel = accuracyLabel;
	}
	public Label getAvoidanceLabel() {
		return avoidanceLabel;
	}
	public void setAvoidanceLabel(Label avoidanceLabel) {
		this.avoidanceLabel = avoidanceLabel;
	}
	public Label getLevel() {
		return level;
	}
	public void setLevel(Label level) {
		this.level = level;
	}
	public Label getHp() {
		return hp;
	}
	public void setHp(Label hp) {
		this.hp = hp;
	}
	public Label getEnergy() {
		return energy;
	}
	public void setEnergy(Label energy) {
		this.energy = energy;
	}
	public Label getStamina() {
		return stamina;
	}
	public void setStamina(Label stamina) {
		this.stamina = stamina;
	}
	public Label getStrength() {
		return strength;
	}
	public void setStrength(Label strength) {
		this.strength = strength;
	}
	public Label getDefense() {
		return defense;
	}
	public void setDefense(Label defense) {
		this.defense = defense;
	}
	public Label getMagic() {
		return magic;
	}
	public void setMagic(Label magic) {
		this.magic = magic;
	}
	public Label getResistance() {
		return resistance;
	}
	public void setResistance(Label resistance) {
		this.resistance = resistance;
	}
	public Label getSpeed() {
		return speed;
	}
	public void setSpeed(Label speed) {
		this.speed = speed;
	}
	public Label getSkill() {
		return skill;
	}
	public void setSkill(Label skill) {
		this.skill = skill;
	}
	public Label getCrit() {
		return crit;
	}
	public void setCrit(Label crit) {
		this.crit = crit;
	}
	public Label getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Label accuracy) {
		this.accuracy = accuracy;
	}
	public Label getAvoidance() {
		return avoidance;
	}
	public void setAvoidance(Label avoidance) {
		this.avoidance = avoidance;
	}
	public Label getSkillPointsLabelLeft() {
		return skillPointsLabelLeft;
	}
	public void setSkillPointsLabelLeft(Label skillPointsLabelLeft) {
		this.skillPointsLabelLeft = skillPointsLabelLeft;
	}
	public Label getSkillPointsLabelRight() {
		return skillPointsLabelRight;
	}
	public void setSkillPointsLabelRight(Label skillPointsLabelRight) {
		this.skillPointsLabelRight = skillPointsLabelRight;
	}
	
}
