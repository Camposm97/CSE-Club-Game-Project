package scene.layout;

import javafx.scene.control.Label;
import models.bag.PlayerBag;
import scene.control.ButtonCreatePlayer;
import utilties.CharacterBuilderPaneUtil;

public class CharacterBuilderPane extends CharacterPane {
	private PlayerBag playerBag;
	private int totalAttrPoints, avAttrPoints;
	private Label lblAvailablePoints;
	private AbilitiesViewer abilitiesViewer;
	private ButtonCreatePlayer btCreate;

	public CharacterBuilderPane(PlayerBag playerBag) {
		this.playerBag = playerBag;
		this.tfName = CharacterBuilderPaneUtil.loadTfName(this);
		this.lblAvailablePoints = new Label(
				CharacterBuilderPaneUtil.STR_AVAIL_PTS + String.valueOf(CharacterBuilderPaneUtil.INIT_ABILITY_POINTS));
		this.totalAttrPoints = CharacterBuilderPaneUtil.INIT_ABILITY_POINTS;
		this.avAttrPoints = CharacterBuilderPaneUtil.INIT_ABILITY_POINTS;
		this.abilitiesViewer = new AbilitiesViewer(this);
		this.btCreate = new ButtonCreatePlayer(this);
		CharacterBuilderPaneUtil.displayControls(this);
	}

	public PlayerBag getPlayerBag() {
		return playerBag;
	}

	public int getTotalAttrPoints() {
		return totalAttrPoints;
	}

	public int getAvailableAttrPoints() {
		return avAttrPoints;
	}

	public void setAvailableAttrPoints(int avAttributePoints) {
		this.avAttrPoints = avAttributePoints;
	}

	public AbilitiesViewer getAbilitiesViewer() {
		return abilitiesViewer;
	}

	public Label getLblAvailablePoints() {
		return lblAvailablePoints;
	}

	public BackStoryPane getBackStory() {
		return backStory;
	}

	public ButtonCreatePlayer getBtCreate() {
		return btCreate;
	}

	public boolean isAvAttrPtsEmpty() {
		return avAttrPoints <= 0;
	}

	public boolean isAvAttrPtsFull() {
		return totalAttrPoints < avAttrPoints;
	}

	public void updateLblAvailablePoints() {
		lblAvailablePoints.setText(CharacterBuilderPaneUtil.STR_AVAIL_PTS + String.valueOf(avAttrPoints));
	}
}
