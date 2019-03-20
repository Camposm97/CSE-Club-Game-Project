package utilties;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.entities.Player;

public class WindowLoader {
	public static void displayPlayer(Player player) {
		displayAlert(AlertType.INFORMATION, "Created New Player!", 
				"Name: " + player.getName() + "\n", 
				"Level: " + player.getLvl() + "\n" + 
				"Strength: " + player.getAttribs().getStr() + "\n" + 
				"Dexterity: " + player.getAttribs().getDex() + "\n" + 
				"Consitution: " + player.getAttribs().getCon() + "\n" + 
				"Intelligence: " + player.getAttribs().getInt() + "\n" + 
				"Wisdom: " + player.getAttribs().getWis() + "\n" + 
				"Charisma: " + player.getAttribs().getCha() + "\n" + 
				"Background: " + player.getBackStory());
	}
	
	public static void displayAlert(AlertType alertType, String title, String headerText, String contentText) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
}
