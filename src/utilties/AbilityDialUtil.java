package utilties;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import scene.control.AbilityDial;
import stats.Ability;

public class AbilityDialUtil {	
	public static void displayControls(AbilityDial dial) {
		dial.getLblAbility().setTooltip(new Tooltip(dial.getDesc()));
		dial.setAlignment(Pos.CENTER);
		HBox hBox = FXUtil.loadHBox(0, Pos.CENTER, dial.getBtMinus(), dial.getTfScore(), dial.getBtPlus());
		dial.add(hBox, 0, 0);
	}
	
	public static TextField loadTfModifer() {
		TextField tf = new TextField(Ability.computeModifier(CharBuilderUtil.INIT_ABILITY_SCORE.toString()));
		tf.setEditable(false);
		tf.setAlignment(Pos.CENTER);
		tf.setPrefColumnCount(2);
		return tf;
	}
	
	public static TextField loadTfNum() {
		TextField tf = new TextField(CharBuilderUtil.INIT_ABILITY_SCORE.toString());
		tf.setEditable(false);
		tf.setAlignment(Pos.CENTER);
		tf.setPrefColumnCount(2);
		return tf;
	}
}
