package utilties;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import scene.layout.TitleScreenPane;

public class TitleScreenPaneUtil {
	public static String TITLE = "CSE Club Game Project";
	private static int BT_WIDTH = 200;

	public static void displayControls(TitleScreenPane root) {
		HandlerUtil.impExitKey(root);
		root.setTop(root.getTxtTitle());
		root.setBottom(FXUtil.loadVBox(root.getBtNewGame(), root.getBtLoadGame(), root.getBtHow(), root.getBtExit()));
		BorderPane.setAlignment(root.getTop(), Pos.TOP_CENTER);
		root.setPadding(new Insets(50));
	}

	public static Text loadTxtTitle() {
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3);
		ds.setOffsetX(3);
		ds.setColor(Color.GRAY);

		Text txt = new Text(TITLE);
		txt.setFont(Font.font(40));
		txt.setEffect(ds);
		return txt;
	}

	public static Button loadBtNewGame(TitleScreenPane root) {
		Button bt = new Button("New Game");
		bt.setPrefWidth(BT_WIDTH);
		bt.setFont(Font.font(20));
		bt.setOnAction(e -> {
			SceneLoader.loadCharacterBuilder(root);
		});
		return bt;
	}

	public static Button loadBtLoadGame(TitleScreenPane root) {
		Button bt = new Button("Load Game");
		bt.setPrefWidth(BT_WIDTH);
		bt.setFont(Font.font(20));
		bt.setOnAction(e -> {
			System.out.println("Display scene with save files");
		});
		return bt;
	}

	public static Button loadBtHow() {
		Button bt = new Button("How to Play");
		bt.setPrefWidth(BT_WIDTH);
		bt.setFont(Font.font(20));
		bt.setOnAction(e -> {
			WindowLoader.showHowToPlay();
		});
		return bt;
	}

	public static Button loadBtExit() {
		Button bt = new Button("Exit");
		bt.setPrefWidth(BT_WIDTH);
		bt.setFont(Font.font(20));
		bt.setOnAction(e -> {
			Platform.exit();
		});
		return bt;
	}
}
