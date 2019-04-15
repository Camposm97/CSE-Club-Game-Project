package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.*;
import utilities.AttackMaker;
import utilities.FileLoader;

public class DisplayWindows {
	
	public DisplayWindows(){
		
	}

	public HBox getTopMenu(GUISettings settings, Pane display) {
		int width = settings.getWidth();
		int height = settings.getHeight();
		Font font = settings.getFont();
		int elementSpacing = 5;
		
		HBox topMenu = new HBox(elementSpacing );
		topMenu.setPrefSize(width, height * .1);
		topMenu.setAlignment(Pos.BASELINE_RIGHT);
		topMenu.setPadding(new Insets(elementSpacing, elementSpacing ,elementSpacing ,elementSpacing  ));
		Button settingsButton = new Button("Settings");
		settingsButton.setPrefSize(width * .1, height * .04);
		settingsButton.setFont(font);
		Button exitButton = new Button ("Exit");
		exitButton.setPrefSize(width * .1, height * .04);
		exitButton.setFont(font);
		exitButton.setOnAction(e->{
			display.getChildren().clear();
			display.getChildren().add(getLogin(settings, display));
		});
		Button attackMakerButton = new Button ("AttackMaker");
		attackMakerButton.setPrefSize(width*.1, height * .04);
		attackMakerButton.setFont(font);
		attackMakerButton.setOnAction(e->{
			display.getChildren().clear();
			display.getChildren().add(this.getAttackDevToolNew(settings, display));
		});
		topMenu.getChildren().addAll(attackMakerButton, settingsButton, exitButton);
		
		return topMenu;
	}
	
	public Pane getDisplay(int width, int height) {
		Pane display = new Pane();
		display.setPrefSize(width, height * .9);
		
		return display;
	}
	
	public VBox getLogin (GUISettings settings, Pane display) {
		int width = settings.getWidth();
		int height = settings.getHeight();
		Font font = settings.getFont();
		int elementSpacing = 10;
		VBox container = new VBox(elementSpacing);
			container.setPrefSize(width, height);
			container.setPadding(new Insets(height * .3, 0, 0, (width *.5) - (width * .075)));
		
		HBox loadRow = new HBox(elementSpacing);	
		Button loadCharacter = new Button ("Load a Character");
		loadCharacter.setFont(font);
		loadCharacter.setPrefSize(width * .15 , height * .04);
		loadRow.getChildren().addAll(loadCharacter);
		
		loadCharacter.setDisable(true);
		
		HBox newCharacterRow = new HBox();
		Button createNewCharacter = new Button ("Create New Character");
			createNewCharacter.setFont(font);
			createNewCharacter.setPrefSize(width * .15 , height * .04);
			createNewCharacter.setOnAction(e->{
				display.getChildren().clear();
				display.getChildren().add(getCharacterBuilder(settings, display));
			});
		newCharacterRow.getChildren().add(createNewCharacter);
		
		Label output = new Label ();
		
		container.getChildren().addAll(loadRow, newCharacterRow, output);
	
		return container;
	}

	public HBox getCharacterBuilder(GUISettings settings, Pane display) {
		int width = settings.getWidth();
		int height = settings.getHeight();
		Font font = settings.getFont();
		
		int elementSpacing = 10;
		
		Player player = new Player();
		
		StatEditor statEditor = new StatEditor(player, settings);
		
		HBox hbox = new HBox(elementSpacing);
			
		VBox column1 = new VBox(elementSpacing * .5);
			column1.setPrefSize(width * .35, height * .9);
			column1.setAlignment(Pos.TOP_RIGHT);
		Label name = new Label("Name: ");
			name.setMinHeight(height * .04);
			name.setFont(font);
		Label backstory = new Label ("BackStory: ");
			backstory.setMinHeight((height * .08) + (elementSpacing * .5));
			backstory.setFont(font);
		Label startingClass = new Label ("Starting Class: ");
			startingClass.setMinHeight(height * .04);
			startingClass.setFont(font);
		column1.getChildren().addAll(name, backstory, statEditor.getLevel(), statEditor.getHp(), statEditor.getEnergy(), statEditor.getStamina(), statEditor.getStrength(), statEditor.getDefense(), statEditor.getMagic(), statEditor.getResistance(),
				statEditor.getSpeed(), statEditor.getSkill(), statEditor.getCrit(), statEditor.getAccuracy(), statEditor.getAvoidance(), statEditor.getSkillPointsLabelLeft(), startingClass);
			
		VBox column2 = new VBox(elementSpacing * .5);
			column2.setPadding(new Insets(0, 0, 0, width * .05));
			column2.setPrefSize(width * .5, height * .9);
			column2.setAlignment(Pos.TOP_LEFT);
		TextField nameEntry = new TextField();
			nameEntry.setMinSize(width * .25, height * .04);
			nameEntry.setMaxSize(width * .3 + (elementSpacing * 2), height * .04);
			nameEntry.setFont(font);
		TextField backstoryEntry = new TextField();
			backstoryEntry.setMinSize(width * .25, (height * .08) + elementSpacing * .5);
			backstoryEntry.setMaxSize(width * .3 + (elementSpacing * 2), (height * .08) + elementSpacing * .5);
			backstoryEntry.setFont(font);
		HBox startingClassButtons = new HBox(elementSpacing);
		Button soldier = new Button ("Soldier");
			soldier.setMinSize(width * .1, height * .04);
			soldier.setFont(font);
		Button knight = new Button ("Knight");
			knight.setMinSize(width * .1, height * .04);
			knight.setFont(font);
		Button mage = new Button ("Mage");
			mage.setMinSize(width * .1, height * .04);
			mage.setFont(font);
		startingClassButtons.getChildren().addAll(soldier, knight, mage);
		Button startGame = new Button("Start Game");
			startGame.setMinSize((width * .3) + (elementSpacing * 2), height * .04);
			startGame.setFont(font);
		column2.getChildren().addAll(nameEntry, backstoryEntry, statEditor.getLevelLabel(),statEditor.getHpLabel(), statEditor.getEnergyLabel(), statEditor.getStaminaButton().getContainer(), statEditor.getStrengthButton().getContainer(), statEditor.getDefenseButton().getContainer(),statEditor.getMagicButton().getContainer(), statEditor.getResistanceButton().getContainer(), 
				statEditor.getSpeedButton().getContainer(), statEditor.getSkillButton().getContainer(), statEditor.getCritLabel(), statEditor.getAccuracyLabel(), statEditor.getAvoidanceLabel(), statEditor.getSkillPointsLabelRight(), startingClassButtons, startGame);
		
			
		
		hbox.getChildren().addAll(column1, column2);
		return hbox;
	}
	public HBox getAttackDevToolNew (GUISettings settings, Pane display) {
		HBox root = new HBox();
		FileLoader fl = new FileLoader();
		//AttackMaker am = new AttackMaker();
	
		AttackBuilderAttackPane builder = new AttackBuilderAttackPane(settings, fl);
		root.getChildren().addAll(builder.getAttackBuilder());
		return root;
	}
	
}