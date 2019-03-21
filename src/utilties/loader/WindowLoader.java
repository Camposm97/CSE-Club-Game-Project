package utilties.loader;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WindowLoader {
	public static void displayAlert(AlertType alertType, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
	
	public static void displayHowToPlay() {
		displayAlert(AlertType.INFORMATION, "How to Play", "Instructions", "Click and Go");
	}
}
