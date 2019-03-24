package utilties;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.bag.PlayerBag;
import scene.control.ButtonCreatePlayer;
import scene.layout.CharacterBuilderPane;
import scene.layout.TitleScreenPane;

public class FXUtil {	
	/**
	 * Spacing = 10; Padding = 10; Alignment = Pos.CENTER;
	 * @param nodes
	 * @return vBox
	 */
	public static VBox loadVBox(Node...nodes) {
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(10));
		vBox.setAlignment(Pos.CENTER);
		for (Node node : nodes)
			vBox.getChildren().add(node);
		return vBox;
	}
	
	/**
	 * Spacing = 10; Padding = 10; Alignment = Pos.CENTER;
	 * @param nodes
	 * @return hBox
	 */
	public static HBox loadHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		hBox.setPadding(new Insets(10));
		hBox.setAlignment(Pos.CENTER);
		for (Node node : nodes)
			hBox.getChildren().add(node);
		return hBox;
	}
	
	public static HBox loadHBox(int spacing, Pos pos, Node...nodes) {
		HBox hBox = new HBox(spacing);
		hBox.setPadding(new Insets(10));
		hBox.setAlignment(pos);
		for (Node node : nodes)
			hBox.getChildren().add(node);
		return hBox;
	}
	
	public static HBox loadHBox(Pos pos, Node...nodes) {
		HBox hBox = new HBox(10);
		hBox.setAlignment(pos);
		for (Node node : nodes)
			hBox.getChildren().add(node);
		return hBox;
	}
	
	/**
	 * Changes scene to TitleScreenPane.  Pane MUST be root of a scene!
	 * @param pane
	 * @return Button
	 */
	public static Button loadBtCancel(Pane pane) {
		Button bt = new Button("Cancel");
		PlayerBag playerBag;
		
		if (pane instanceof CharacterBuilderPane)
			bt.setPrefWidth(ButtonCreatePlayer.WIDTH);
			playerBag = ((CharacterBuilderPane)pane).getPlayerBag();
	
		bt.setOnAction(e -> {
			pane.getScene().setRoot(new TitleScreenPane(playerBag));
		});
		return bt;
	}
}
