package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import models.Stat;

public class StatButton {
	
	private HBox container;
	private Button minus;
	private Button plus;
	private Label value;
	private Stat stat;
	private int pointsSpent;
	
	StatButton (Stat stat, GUISettings settings, StatEditor editor){
		this.pointsSpent = 0;
		this.stat = stat;
		this.buildButton(settings, editor);
	}
	
	public void buildButton(GUISettings settings, StatEditor editor) {
		int width = settings.getWidth();
		int height = settings.getHeight();
		Font font = settings.getFont();
		this.container = new HBox(5);
		this.value = new Label("" + this.stat.getValue());
			value.setFont(font);
			value.setPrefSize(width * .1, height * .04);
			value.setAlignment(Pos.CENTER);
		this.minus = new Button("-");
			minus.setFont(font);
			minus.setPrefSize(width * .1, height *.04);
		this.plus = new Button ("+");
			plus.setFont(font);
			plus.setPrefSize(width * .1, height *.04);
			
		buttonEnabler();
		
		minus.setOnAction(e->{
			stat.modifyValue(-1);
			pointsSpent--;
			StatEditor.modifySkillPointsUsed(-1);
			value.setText("" + this.stat.getValue());
			buttonEnabler();
			editor.updateStatEditor();
		});
		plus.setOnAction(e->{
			stat.modifyValue(1);
			pointsSpent++;
			StatEditor.modifySkillPointsUsed(1);
			value.setText("" + this.stat.getValue());
			buttonEnabler();
			editor.updateStatEditor();
		});
		container.getChildren().addAll(minus, value, plus);
	}
	public void buttonEnabler () {
		if (StatEditor.getSkillPointsUsed() < StatEditor.getSkillPoints() && this.pointsSpent < StatEditor.getSkillPointCap()) {
			plus.setDisable(false);
		}
		else {
			plus.setDisable(true);
		}
		if (pointsSpent > 0) {
			minus.setDisable(false);
		}
		else {
			minus.setDisable(true);
		}
	}

	public HBox getContainer() {
		return container;
	}

	public void setContainer(HBox container) {
		this.container = container;
	}

	public Button getMinus() {
		return minus;
	}

	public void setMinus(Button minus) {
		this.minus = minus;
	}

	public Button getPlus() {
		return plus;
	}

	public void setPlus(Button plus) {
		this.plus = plus;
	}

	public Label getValue() {
		return value;
	}

	public void setValue(Label value) {
		this.value = value;
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public int getPointsSpent() {
		return pointsSpent;
	}

	public void setPointsSpent(int pointsSpent) {
		this.pointsSpent = pointsSpent;
	}

}
