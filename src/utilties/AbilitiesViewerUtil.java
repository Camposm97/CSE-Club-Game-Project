package utilties;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import scene.layout.AbilitiesViewer;

public class AbilitiesViewerUtil {
	public static void displayControls(AbilitiesViewer abilViewer) {
		abilViewer.setAlignment(Pos.CENTER_LEFT);
		abilViewer.setHgap(10);
		abilViewer.add(loadLblAbilType(), 0, 0);
		
		for (int i = 0; i < abilViewer.getDialBag().size(); i++) {
			abilViewer.add(abilViewer.getDialBag().get(i).getLblAbility(), 0, (i + 1));
			abilViewer.add(abilViewer.getDialBag().get(i), 1, (i + 1));
			abilViewer.add(abilViewer.getDialBag().get(i).getTfModifer(), 3, (i + 1));
		}
		
		Separator sep = new Separator();
		sep.setOrientation(Orientation.VERTICAL);
		abilViewer.add(sep, 2, 0, 1, 7);
		
		abilViewer.add(loadLblModifer(), 3, 0);
	}
	
	public static Label loadLblAbilType() {
		Label lbl = new Label("Ability Type:");
		lbl.setStyle("-fx-underline: true");
		return lbl;
	}
	
	public static Label loadLblModifer() {
		Label lbl = new Label("Modifer:");
		lbl.setStyle("-fx-underline: true");
		return lbl;
	}
}
