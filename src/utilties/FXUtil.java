package utilties;

import controller.menu.MenuBarBuilt;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.CharacterBuilderPane;

public class FXUtil {
	public static BorderPane loadRoot() {
		BorderPane root = new BorderPane();
		HandlerUtil.impExitKey(root);
		root.setCenter(new CharacterBuilderPane(CharacterBuilderPaneUtil.TOTAL_ATTRIBUTE_POINTS));
		root.setTop(new MenuBarBuilt(root));
		return root;
	}
	
	/**
	 * Spacing = 10; Padding = 10; Alignment = Pos.CENTER;
	 * @param nodes
	 * @return vBox
	 */
	public static VBox asVBox(Node...nodes) {
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
	public static HBox asHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		hBox.setPadding(new Insets(10));
		hBox.setAlignment(Pos.CENTER);
		for (Node node : nodes)
			hBox.getChildren().add(node);
		return hBox;
	}
	
	public static HBox asHBox(int spacing, Pos pos, Node...nodes) {
		HBox hBox = new HBox(spacing);
		hBox.setPadding(new Insets(10));
		hBox.setAlignment(pos);
		for (Node node : nodes)
			hBox.getChildren().add(node);
		return hBox;
	}
	
	public static HBox asHBox(Pos pos, Node...nodes) {
		HBox hBox = new HBox(10);
		hBox.setAlignment(pos);
		for (Node node : nodes)
			hBox.getChildren().add(node);
		return hBox;
	}
}
