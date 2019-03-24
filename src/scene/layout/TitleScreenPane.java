package scene.layout;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import models.bag.PlayerBag;
import utilties.TitleScreenPaneUtil;

public class TitleScreenPane extends BorderPane {
	private PlayerBag playerBag;
	private Text txtTitle;
	private Button btNewGame, btLoadGame, btHow, btExit;

	public TitleScreenPane(PlayerBag playerBag) {
		this.playerBag = playerBag;
		this.txtTitle = TitleScreenPaneUtil.loadTxtTitle();
		this.btNewGame = TitleScreenPaneUtil.loadBtNewGame(this);
		this.btLoadGame = TitleScreenPaneUtil.loadBtLoadGame(this);
		this.btHow = TitleScreenPaneUtil.loadBtHow();
		this.btExit = TitleScreenPaneUtil.loadBtExit();
		TitleScreenPaneUtil.displayControls(this);
	}

	public PlayerBag getPlayerBag() {
		return playerBag;
	}

	public void setPlayerBag(PlayerBag playerBag) {
		this.playerBag = playerBag;
	}

	public Text getTxtTitle() {
		return txtTitle;
	}

	public Button getBtNewGame() {
		return btNewGame;
	}

	public Button getBtLoadGame() {
		return btLoadGame;
	}

	public Button getBtHow() {
		return btHow;
	}

	public Button getBtExit() {
		return btExit;
	}
}
