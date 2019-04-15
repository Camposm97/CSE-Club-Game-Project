package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.Stats;

public class AttackBuilderStatPane {
	int width;
	int height;
	Font font;
	Label[] labels = new Label[17];
	TextField[] entries= new TextField[15];
	int elementSpacing = 5;
	int whichOne;
	
	AttackBuilderStatPane(GUISettings settings, int whichOne){
		this.width = settings.getWidth();
		this.height = settings.getHeight();
		int fontSize = 14;
		if (height < 1000) {
			fontSize = 9;
			}
		this.font = new Font(fontSize);
		this.whichOne = whichOne;
	}
	
	public VBox getStatPane () {
		VBox root = new VBox (elementSpacing);
		root.setMinSize(width * .05, height * .45);
		HBox[] lines = new HBox[16];
		
		String temp = " ";
		
		if (whichOne == 0) {
			temp = new String("Initial");
		}
		if (whichOne == 1) {
			temp = new String("Periodic");
		}
		if (whichOne == 2) {
			temp = new String("Final");
		}
		
		
		String[] textFill = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		String[] labelText = {" ", "Buff Type: ", "Max HP : ", "Current HP : ", "Max Energy : ", "Energy : ", "Stamina :", "Strength : ", "Defense : ", "Magic : ", "Resistance : ", "Speed : ", "Skill : ", "Crit : ", "Accuracy : ", "Avoidance", temp};
		
		for (int i = 0; i < entries.length; i++ ) {
			entries[i] = new TextField(textFill[i]);
			entries[i].setMinSize(width * .05, height*.02);
			entries[i].setMaxSize(width * .05, height*.02);
			entries[i].setFont(this.font);
			root.getChildren().add(entries[i]);	
		}
		
		for (int i = 0; i < labels.length ; i++ ) {
			labels[i] = new Label(labelText[i]);
			labels[i].setMinSize(width * .05, height*.02);
			labels[i].setMaxSize(width * .05, height*.02);
			labels[i].setFont(this.font);
			labels[i].setAlignment(Pos.TOP_RIGHT);
		}
		
		for(int i = 0; i < lines.length; i++) {
			
			lines[i] = new HBox(elementSpacing);
			if (i == 0) {
				labels[16].setMinSize(width * .05, height*.02);
				labels[16].setMaxSize(width * .05, height*.02);
				lines[i].getChildren().addAll(labels[i], labels[16]);
			}
			else {
				lines[i].getChildren().addAll(labels[i], entries[i - 1]);
			}
			root.getChildren().add(lines[i]);	
		}
	
	
		
		
		
		return root;
	}
	public void setEntries (Stats stat) {
		String[] text = { ("" + stat.getLevel().getValue()), ("" + stat.getMaxHP().getValue()), ("" + stat.getCurrentHP().getValue()), ("" + stat.getMaxEnergy().getValue()), ("" + stat.getCurrentEnergy().getValue()), ("" + stat.getStamina().getValue()), ("" + stat.getStrength().getValue()),
				("" + stat.getDefense().getValue()), ("" + stat.getMagic().getValue()), ("" + stat.getResistance().getValue()), ("" + stat.getSpeed().getValue()), ("" + stat.getSkill().getValue()), ("" + stat.getCrit().getValue()), ("" + stat.getAccuracy().getValue()), ("" + stat.getAvoidance().getValue())};
		for (int i = 0; i < entries.length; i++ ) {
			entries[i].setText(text[i]);	
		}
	}
	public void resetEntries () {
		
		String[] text = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
		for (int i = 0; i < entries.length; i++ ) {
			entries[i].setText(text[i]);	
		}
	}
	public Stats createStats () {
		Stats stats = null;
		try {
			stats = new Stats (Integer.parseInt(entries[0].getText()), Integer.parseInt(entries[1].getText()), Integer.parseInt(entries[2].getText()), Integer.parseInt(entries[3].getText()), Integer.parseInt(entries[4].getText()), Integer.parseInt(entries[5].getText()), Integer.parseInt(entries[6].getText()), Integer.parseInt(entries[7].getText()), Integer.parseInt(entries[8].getText()),
					Integer.parseInt(entries[9].getText()), Integer.parseInt(entries[10].getText()), Integer.parseInt(entries[11].getText()), Integer.parseInt(entries[12].getText()), Integer.parseInt(entries[13].getText()), Integer.parseInt(entries[14].getText()));
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return stats;
	}

}