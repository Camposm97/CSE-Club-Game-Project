package scene.layout;

import javafx.scene.control.ScrollPane;
import models.bag.PlayerBag;

public class PlayerLoaderPane extends ScrollPane {
	private PlayerBag playerBag;
	
	public PlayerLoaderPane(PlayerBag playerBag) {
		this.playerBag = playerBag;
	}

	public PlayerBag getPlayerBag() {
		return playerBag;
	}

	public void setPlayerBag(PlayerBag playerBag) {
		this.playerBag = playerBag;
	}
}
