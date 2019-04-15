package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.Buff;
import models.Stats;

public class AttackBuilderBuffPane {
	int width;
	int height;
	Font font;
	
	TextField nameEntry;
	TextField descriptionEntry;
	TextField durationEntry;
	
	Label name;
	Label description;
	Label duration;
	
	AttackBuilderStatPane initialBuff;
	AttackBuilderStatPane periodicBuff;
	AttackBuilderStatPane finalBuff;
	
	int whichOne;
	
	public AttackBuilderBuffPane (GUISettings settings, int whichOne) {
		this.width = settings.getWidth();
		this.height = settings.getHeight();
		int fontSize = 14;
		if (height < 1000) {
			fontSize = 9;
			}
		this.font = new Font(fontSize);
		
		initialBuff = new AttackBuilderStatPane(settings, 0);
		periodicBuff = new AttackBuilderStatPane(settings, 1);
		finalBuff = new AttackBuilderStatPane(settings, 2);
		this.whichOne = whichOne;
	}
	public HBox getBuffBuilder () {
		int elementSpacing = 5;
		
		HBox root = new HBox(elementSpacing);
		VBox container = new VBox(elementSpacing);
		HBox[] rows = new HBox[4];
		String temp = "";
		if (whichOne == 0) {
			temp = "Target Buff";
		}
		if (whichOne == 1) {
			temp= "Self Buff";
		}
		Label whichBuff = new Label (temp);
		whichBuff.setMinSize(width * .1, height*.02);
		whichBuff.setMaxSize(width * .1, height*.02);
		whichBuff.setFont(font);
		Label spacing = new Label(" ");
		spacing.setMinSize(width * .05, height*.02);
		spacing.setMaxSize(width * .05, height*.02);
		
		name = new Label( "Name : ");
		name.setMinSize(width * .05, height*.02);
		name.setMaxSize(width * .05, height*.02);
		name.setFont(font);
		name.setAlignment(Pos.TOP_RIGHT);
		description = new Label( "Description : ");
		description.setMinSize(width * .05, height*.06);
		description.setMaxSize(width * .05, height*.06);
		description.setFont(font);
		description.setAlignment(Pos.BASELINE_RIGHT);
		duration = new Label( "Duration : ");
		duration.setMinSize(width * .05, height*.02);
		duration.setMaxSize(width * .05, height*.02);
		duration.setFont(font);
		duration.setAlignment(Pos.TOP_RIGHT);
		
		nameEntry = new TextField("");
		nameEntry.setMinSize(width * .1, height*.02);
		nameEntry.setMaxSize(width * .1, height*.02);
		nameEntry.setFont(font);
		descriptionEntry = new TextField("");
		descriptionEntry.setMinSize(width * .1, height*.06);
		descriptionEntry.setMaxSize(width * .1, height*.06);
		descriptionEntry.setFont(font);
		descriptionEntry.setAlignment(Pos.TOP_LEFT);
		durationEntry = new TextField("0");
		durationEntry.setMinSize(width * .1, height*.02);
		durationEntry.setMaxSize(width * .1, height*.02);
		durationEntry.setFont(font);
		
		for (int i = 0; i < 4; i++) {
			rows[i] = new HBox(elementSpacing);
			if (i == 0) {
				rows[i].getChildren().addAll(spacing, whichBuff);
			}
			if (i == 1) {
				rows[i].getChildren().addAll(name, nameEntry);
			}
			if (i == 2) {
				rows[i].getChildren().addAll(description, descriptionEntry);
			}
			if (i == 3) {
				rows[i].getChildren().addAll(duration, durationEntry);
			}
			container.getChildren().add(rows[i]);
		}
		
		root.getChildren().addAll(container,this.initialBuff.getStatPane(), this.periodicBuff.getStatPane(), this.finalBuff.getStatPane());
		
		return root;
	}
	public Buff getBuff () {
		Buff buff = null;
		try {
			buff = new Buff(nameEntry.getText(), descriptionEntry.getText(), new Stats(this.initialBuff.createStats()), new Stats(this.periodicBuff.createStats()), new Stats(this.finalBuff.createStats()), Integer.parseInt(durationEntry.getText()));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return buff;
	}
	public void setEntries (Buff buff) {
		nameEntry.setText(buff.getName());
		descriptionEntry.setText(buff.getDescription());
		durationEntry.setText("" + buff.getDuration());
		this.initialBuff.setEntries(buff.getInitialBuff());
		this.periodicBuff.setEntries(buff.getPeriodicBuff());
		this.finalBuff.setEntries(buff.getFinalBuff());
	}
	public void resetEntries() {
		nameEntry.setText("");
		descriptionEntry.setText("");
		durationEntry.setText("0");
		this.initialBuff.resetEntries();
		this.periodicBuff.resetEntries();
		this.finalBuff.resetEntries();
	}
}
