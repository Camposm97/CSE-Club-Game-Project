package scene.layout;

import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import models.entities.Player;
import utilties.CharEditorUtil;

public class CharacterEditorPane extends TabPane {
	private Player player;
	private TextField tfName;
	public CharacterEditorPane(Player player) {
		this.tfName = CharEditorUtil.loadTfName();
		this.player = player;
		new CharEditorUtil(this);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public TextField getTfName() {
		return tfName;
	}
}