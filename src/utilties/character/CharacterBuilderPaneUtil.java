package utilties.character;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import scene.layout.CharacterBuilderPane;
import utilties.loader.FXLoader;

public class CharacterBuilderPaneUtil {
	public static final int INIT_ATTRIBUTE_POINTS = 18;
	public static final Integer INIT_VALUE = -2;
	public static final String AV_POINTS = "Available Attribute Points: ";
	
	public static void displayControls(CharacterBuilderPane charPane) {
		charPane.setPadding(new Insets(20));
		charPane.setAlignment(Pos.CENTER);
		charPane.setVgap(10);
		charPane.setHgap(10);
		
		charPane.add(FXLoader.loadHBox(Pos.CENTER_LEFT, new Label("Character's Name:"), charPane.getTfName()), 0, 0);
		charPane.add(charPane.getLblAvailablePoints(), 0, 1);
		charPane.add(charPane.getAttrViewer(), 0, 2);
		charPane.add(FXLoader.loadHBox(charPane.getBtCreate()), 0, 10, 4, 1);
	
		charPane.add(charPane.getBackStory(), 0, 9, 4, 1);
	}
}
