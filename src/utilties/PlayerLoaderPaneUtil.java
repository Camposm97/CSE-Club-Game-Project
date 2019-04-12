package utilties;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import models.bag.PlayerBag;
import models.entities.Player;
import scene.layout.PlayerLoaderPane;

public class PlayerLoaderPaneUtil {
	public static void displayControls(PlayerLoaderPane pane) {
		pane.setCenter(loadPlayerPicker(pane.getPlayerBag()));
		pane.setBottom(new StackPane(FXUtil.loadBtCancel(pane)));
	}

	public static ScrollPane loadPlayerPicker(PlayerBag bag) {
		ScrollPane pane = new ScrollPane();
		pane.setFocusTraversable(false);
		
		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10));
		vBox.setAlignment(Pos.CENTER);
		
		for (int i = 0; i < bag.size(); i++) {
			Button bt = loadBtPlayerData(bag.get(i));
			bt.prefWidthProperty().bind(pane.widthProperty().multiply(0.95));
			vBox.getChildren().add(bt);
		}
		
		pane.setContent(vBox);
		return pane;
	}
	
	public static Button loadBtPlayerData(Player p) {
		Button bt = new Button(FormatUtil.format(p));
		bt.setStyle("-fx-font-size: 18;");
		bt.setAlignment(Pos.CENTER_LEFT);
		bt.setOnMouseEntered(e -> {
			bt.setTextFill(Color.web("#38A1E6"));
		});
		bt.setOnMouseExited(e -> {
			bt.setTextFill(Color.BLACK);
		});
		bt.setOnAction(e -> {
			System.out.println("Load Player: " + p.getName() + " with ID: " + p.getId());
		});
		ContextMenu c = new ContextMenu();
		c.getItems().addAll(new MenuItem("Delete"), new MenuItem("Export"));
		bt.setContextMenu(c);
		return bt;
	}
}
