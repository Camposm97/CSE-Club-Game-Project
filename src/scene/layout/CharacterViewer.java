package scene.layout;

import models.entities.Player;
import utilties.CharacterViewerUtil;

public class CharacterViewer extends CharacterPane {
	private Player player;
	
	public CharacterViewer(Player player) {
		this.tfName = CharacterViewerUtil.loadTfName();
		this.player = player;
		CharacterViewerUtil.displayControls(this);
	}
	
	public Player getPlayer() {
		return player;
	}
}