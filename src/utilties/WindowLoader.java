package utilties;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Player;

public class WindowLoader {
	public static void displayPlayer(Player player) {
		displayAlert(AlertType.INFORMATION, "Created New Player!", 
				"Name: " + player.getName() + "\n", 
				"Level: " + player.getLevel() + "\n" + 
				"Strength: " + player.getAttributes().getStr() + "\n" + 
				"Dexterity: " + player.getAttributes().getDex() + "\n" + 
				"Consitution: " + player.getAttributes().getCon() + "\n" + 
				"Intelligence: " + player.getAttributes().getInt() + "\n" + 
				"Wisdom: " + player.getAttributes().getWis() + "\n" + 
				"Charisma: " + player.getAttributes().getCha() + "\n" + 
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
