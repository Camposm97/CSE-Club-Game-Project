package utilties;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import view.CharacterBuilderPane;

public class CharacterBuilderPaneUtil {
	public static final int TOTAL_ATTRIBUTE_POINTS = 20;
	public static final Integer INIT_VALUE = -2;
	public static final String AV_POINTS = "Available Attribute Points: ";
	
	public static void displayControls(CharacterBuilderPane charPane) {
		charPane.setPadding(new Insets(20));
		charPane.setAlignment(Pos.CENTER);
		charPane.setVgap(10);
		charPane.setHgap(10);
		
		charPane.add(FXUtil.asHBox(Pos.CENTER_LEFT, new Label("Character's Name:"), charPane.getTfName()), 0, 0);
		charPane.add(charPane.getLblAvailablePoints(), 0, 1);
		charPane.add(charPane.getAttrViewer(), 0, 2);
		charPane.add(FXUtil.asHBox(charPane.getBtCreate()), 0, 10, 4, 1);
	
		charPane.add(charPane.getBackStory(), 0, 9, 4, 1);
	}
}
