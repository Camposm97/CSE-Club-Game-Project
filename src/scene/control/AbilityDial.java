package scene.control;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import scene.layout.CharacterBuilderPane;
import utilties.AbilityDialUtil;

public abstract class AbilityDial extends GridPane {
	protected Label lblAbility;
	protected String desc;
	protected CharacterBuilderPane charPane;
	protected TextField tfScore, tfModifier;
	protected Button btPlus, btMinus;
	
	public AbilityDial(String abilityName, String desc, CharacterBuilderPane charPane) {
		this.lblAbility = new Label(abilityName);
		this.desc = desc;
		this.charPane = charPane;
		this.tfModifier = AbilityDialUtil.loadTfModifer();
		this.tfScore = AbilityDialUtil.loadTfNum();
		this.btPlus = new ButtonPlus(this);
		this.btMinus = new ButtonMinus(this);
		AbilityDialUtil.displayControls(this);
	}
	
	public Label getLblAbility() {
		return lblAbility;
	}
	
	public TextField getTfModifer() {
		return tfModifier;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public CharacterBuilderPane getCharPane() {
		return charPane;
	}

	public Button getBtPlus() {
		return btPlus;
	}

	public Button getBtMinus() {
		return btMinus;
	}

	public TextField getTfScore() {
		return tfScore;
	}
	
	public int getAbilityScore() {
		return Integer.parseInt(tfScore.getText());
	}
}
