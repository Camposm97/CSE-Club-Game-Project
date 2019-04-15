package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.Attack;
import models.Buff;
import models.Stats;
import utilities.AttackMaker;
import utilities.FileLoader;
import utilities.MonsterMaker;

public class AttackBuilderAttackPane {
	private int width;
	private int height;
	private Font font;
	Label[] labels = new Label[12];
	TextField[] entries = new TextField[11];
	CheckBox doesBuffs = new CheckBox();
	AttackBuilderBuffPane targetBuff;
	AttackBuilderBuffPane selfBuff;
	TextArea attackReader;
	Button submit;
	Button reset;
	AttackMaker maker;
	
	AttackBuilderAttackPane(GUISettings settings, FileLoader loader){
		this.width = settings.getWidth();
		this.height = settings.getHeight();
		int fontSize = 14;
		if (height < 1000) {
			fontSize = 9;
			}
		this.font = new Font(fontSize);
		this.targetBuff = new AttackBuilderBuffPane(settings, 0);
		this.selfBuff = new AttackBuilderBuffPane(settings, 1);
		submit = new Button ("Submit");
		reset = new Button ("reset");
		reset.setOnAction(e->{
			this.resetEntries();
		});
		maker = new AttackMaker();
		setSubmitAction(loader);
		attackReader = new TextArea();
		attackReader.setMinSize(settings.getWidth()*.2, settings.getHeight()*.6);
		attackReader.setMaxSize(settings.getWidth()*.2, settings.getHeight()*.6);
		attackReader.setText(loader.getAttackMaker().attackListToString());
	}
	public void setSubmitAction (FileLoader loader) {
		submit.setOnAction(e->{
			
			loader.getAttackMaker().addToMasterList(this.createAttack());
			attackReader.setText(loader.getAttackMaker().attackListToString());
			loader.saveAttackList();
		});
			
	}
	public HBox getAttackBuilder () {
		int elementSpacing = 5;
		HBox root = new HBox(elementSpacing);
		
		VBox container = new VBox(elementSpacing);
		container.setPadding(new Insets((height * .02) + elementSpacing, 0, 0, width* .02));
		VBox container2 = new VBox(elementSpacing);
		
		HBox[] rows = new HBox[12];
		
		String[] labelText = {"ID : ", "Name : ", "Description : ", "Strength Multiplier : ", "Magic Multiplier : ", "Bonus Damage : ", "Accuracy : ", "Crit Chance : ", "Uses :", "Energy Cost : ", "Does Buffs : ", "Buff Chance : "};
		String[] entryFill = {"0", "", "", "0", "0", "0","0", "0","0", "0","0"};
		int entryFillCounter = 0;
		
		for (int i = 0; i < rows.length; i++) {
			rows[i] = new HBox(elementSpacing);
			
			labels[i] = new Label(labelText[i]);
			labels[i].setMinSize(width * .05, height*.02);
			labels[i].setMaxSize(width * .05, height*.02);
			labels[i].setFont(font);
			labels[i].setAlignment(Pos.BASELINE_RIGHT);
			
			if (i != 10) {
				entries[entryFillCounter] = new TextField(entryFill[entryFillCounter]);
				entries[entryFillCounter].setMinSize(width * .1, height*.02);
				entries[entryFillCounter].setMaxSize(width * .1, height*.02);
				entries[entryFillCounter].setFont(font);
				rows[i].getChildren().addAll(labels[i], entries[entryFillCounter++]);
			}
			else {
				rows[i].getChildren().addAll(labels[i], this.doesBuffs);
			}
			container.getChildren().addAll(rows[i]);
		}
		rows[2].setMinSize(width * .05, height*.06);
		rows[2].setMaxSize(width * .05, height*.06);
		labels[2].setMinSize(width * .05, height*.06);
		labels[2].setMaxSize(width * .05, height*.06);
		entries[2].setMinSize(width * .1, height*.06);
		entries[2].setMaxSize(width * .1, height*.06);
		
		container.getChildren().addAll(reset,submit);
		container2.getChildren().addAll(this.targetBuff.getBuffBuilder(), this.selfBuff.getBuffBuilder());
		root.getChildren().addAll(container, container2, this.attackReader);
		return root;
	}
	public Attack createAttack() {
		Attack attack = null;
		
		try {
			attack = new Attack(
					Integer.parseInt(entries[0].getText()),
					entries[1].getText(),
					entries[2].getText(),
					Integer.parseInt(entries[3].getText()),
					Integer.parseInt(entries[4].getText()),
					Integer.parseInt(entries[5].getText()),
					Integer.parseInt(entries[6].getText()),
					Integer.parseInt(entries[7].getText()),
					Integer.parseInt(entries[8].getText()),
					Integer.parseInt(entries[9].getText()), 
					this.targetBuff.getBuff(),
					this.selfBuff.getBuff(), 
					this.doesBuffs.isSelected(),
					Integer.parseInt(entries[10].getText()));
		}
		catch (Exception ex) {
			attack = new Attack();
		}
		return attack;
	}
	public void setEntries (Attack attack) {
		String[] text = {""+ attack.getID(), attack.getName(), attack.getDescription(), "" + attack.getStrengthMultiplier(), "" + attack.getMagicMultiplier(), "" + attack.getBonusDamage(), "" + attack.getAccuracy(), "" + attack.getCrit(), "" + attack.getUses(), "" + attack.getEnergyCost(), "" + attack.getBuffChance()};
		for (int i = 0; i < entries.length; i++) {
			entries[i].setText(text[i]);
		}
		if (attack.getDoesBuffs()) {
			this.doesBuffs.setSelected(true);
		}
		else {
			this.doesBuffs.setSelected(false);
		}
		this.targetBuff.setEntries(attack.getTargetBuff());
		this.selfBuff.setEntries(attack.getSelfBuff());
	}
	public void resetEntries () {
		String[] text = {"0", "", "", "0", "0", "0","0", "0","0", "0","0"};
		for (int i = 0; i < entries.length; i++) {
			entries[i].setText(text[i]);
		}
		doesBuffs.setSelected(false);
		this.targetBuff.resetEntries();
		this.selfBuff.resetEntries();
	}
}
