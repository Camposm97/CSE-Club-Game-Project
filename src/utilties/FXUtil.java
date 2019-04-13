package utilties;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.bag.PlayerBag;
import scene.control.ButtonCreatePlayer;
import scene.layout.PlayerBuilderPane;
import scene.layout.PlayerLoaderPane;
import scene.layout.TitleScreenPane;

public class FXUtil {	
	public static final Insets DEFAULT_INSETS = new Insets(10);
	
	/**
	 * Spacing = 10; Padding = 10; Alignment = Pos.CENTER;
	 * @param nodes
	 * @return vBox
	 */
	public static VBox loadVBox(Node...nodes) {
		VBox vBox = new VBox(10);
		vBox.setPadding(DEFAULT_INSETS);
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
		hBox.setPadding(DEFAULT_INSETS);
		hBox.setAlignment(Pos.CENTER);
		for (Node node : nodes)
			hBox.getChildren().add(node);
		return hBox;
	}
	
	public static HBox loadHBox(int spacing, Pos pos, Node...nodes) {
		HBox hBox = new HBox(spacing);
		hBox.setPadding(DEFAULT_INSETS);
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
		if (pane instanceof PlayerBuilderPane)
			bt.setPrefWidth(ButtonCreatePlayer.WIDTH);
		bt.setOnAction(e -> {
			PlayerBag playerBag = null;
			if (pane instanceof PlayerBuilderPane)
				playerBag = ((PlayerBuilderPane)pane).getPlayerBag();
			if (pane instanceof PlayerLoaderPane)
				playerBag = ((PlayerLoaderPane)pane).getPlayerBag();
			pane.getScene().setRoot(new TitleScreenPane(playerBag));
		});
		return bt;
	}
}
