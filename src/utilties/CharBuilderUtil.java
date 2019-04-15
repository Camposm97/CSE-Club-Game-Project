package utilties;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import scene.layout.PlayerBuilderPane;

public class CharBuilderUtil {
	public static final int INIT_ABILITY_PTS = 30;
	public static final Integer INIT_ABILITY_SCORE = -2;
	public static final String AVAIL_PTS_TXT = "Available Ability Points: ";

	public static void displayControls(PlayerBuilderPane charPane) {
		charPane.setPadding(new Insets(20));
		charPane.setAlignment(Pos.CENTER);
		charPane.setVgap(10);
		charPane.setHgap(10);

		charPane.add(FXUtil.loadHBox(Pos.CENTER_LEFT, new Label("Character's Name:"), charPane.getTfName()), 0, 0);
		charPane.add(charPane.getLblAvailPts(), 0, 1);
		charPane.add(charPane.getAbilsViewer(), 0, 2);
		charPane.add(charPane.getBackStory(), 0, 9, 4, 1);
		charPane.add(FXUtil.loadHBox(charPane.getBtCreate(), FXUtil.loadBtCancel(charPane)), 0, 10, 4, 1);
	}

	public static TextField loadTfName(PlayerBuilderPane charPane) {
		TextField tf = new TextField();
		tf.setPrefColumnCount(48);
		tf.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.length() > 48)	{ // LIMIT Character Name
				tf.setStyle("-fx-border-color: red; -fx-background-color: #FFF0F0;");
				charPane.getBtCreate().setDisable(true);
			} else {
				tf.setStyle("");
				charPane.getBtCreate().setDisable(false);
			}
		});
		return tf;
	}
}
