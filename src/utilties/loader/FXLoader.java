package utilties.loader;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import scene.control.menu.MenuBarBuilt;
import scene.layout.CharacterBuilderPane;
import utilties.character.CharacterBuilderPaneUtil;
import utilties.system.HandlerUtil;

public class FXLoader {
	public static BorderPane loadCharacterBuilder() {
		BorderPane root = new BorderPane();
		HandlerUtil.impExitKey(root);
		root.setCenter(new CharacterBuilderPane(CharacterBuilderPaneUtil.INIT_ATTRIBUTE_POINTS));
//		root.setTop(new MenuBarBuilt(root));
		return root;
	}
	
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
}
