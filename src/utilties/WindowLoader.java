package utilties;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WindowLoader {
	public static void showAlert(AlertType alertType, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
	
	public static void showHowToPlay() {
		showAlert(AlertType.INFORMATION, "How to Play", TitleScreenPaneUtil.TITLE, "Click and Go");
	}
	
	public static void showWarningAllAttrNotSpent() {
		showAlert(AlertType.ERROR, "Ability Points", "ERROR: Not all ability points are spent.", "You must spend all of your ability points!");
	}
}
