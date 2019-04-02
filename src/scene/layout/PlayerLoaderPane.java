package scene.layout;

import javafx.scene.layout.BorderPane;
import models.bag.PlayerBag;
import utilties.PlayerLoaderPaneUtil;

public class PlayerLoaderPane extends BorderPane {
	private PlayerBag playerBag;
	
	public PlayerLoaderPane(PlayerBag playerBag) {
		this.playerBag = playerBag;
		PlayerLoaderPaneUtil.displayControls(this);
	}

	public PlayerBag getPlayerBag() {
		return playerBag;
	}

	public void setPlayerBag(PlayerBag playerBag) {
		this.playerBag = playerBag;
	}
}
