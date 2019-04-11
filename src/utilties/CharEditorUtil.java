package utilties;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import models.entities.Player;
import scene.layout.CharacterEditorPane;

public class CharEditorUtil {
	public static void displayControls(CharacterEditorPane charEditor) {
		charEditor.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
//		charEditor.setStyle("-fx-font-size: 18;");
		Tab tabChar = new Tab("Character");
		tabChar.setGraphic(ImageUtil.loadIconChar());
		tabChar.setContent(loadCharPane(charEditor));
		Tab tabInv = new Tab("Inventory");
		tabInv.setGraphic(ImageUtil.loadIconInventory());
		
		Tab tabSettings = new Tab("Options");
		tabSettings.setGraphic(ImageUtil.loadIconOptions());
		charEditor.getTabs().addAll(tabChar, tabInv, tabSettings);
	}

	public static TextField loadTfName() {
		TextField tf = new TextField();
		tf.setEditable(false);
		return tf;
	}
	
	public static ProgressBar loadHPBar(CharacterEditorPane charEditor) {
		Player p1 = charEditor.getPlayer();
		ProgressBar bar = new ProgressBar(p1.getStats().getHitPts().getPercentage());
		bar.setStyle("-fx-accent: #29E312;");
		bar.prefWidthProperty().bind(charEditor.widthProperty().multiply(0.5));
		return bar;
	}
	
	public static ProgressBar loadMPBar(CharacterEditorPane charEditor) {
		Player p1 = charEditor.getPlayer();
		ProgressBar bar = new ProgressBar(p1.getStats().getManaPts().getPercentage());
		bar.setStyle("-fx-accent: #268EEE;");
		bar.prefWidthProperty().bind(charEditor.widthProperty().multiply(0.5));
		return bar;
	}
	
	public static BorderPane loadCharPane(CharacterEditorPane charEditor) {
		Player p = charEditor.getPlayer();
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setPadding(new Insets(10));
		gridPane.add(new Label("Character's Name: "), 0, 0);
		gridPane.add(new Label(p.getName()), 1, 0);
		BorderPane root = new BorderPane(gridPane);
		return root;
	}
}
