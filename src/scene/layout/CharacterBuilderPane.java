package scene.layout;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import models.bag.PlayerBag;
import scene.control.ButtonCreatePlayer;
import utilties.CharBuilderUtil;

public class CharacterBuilderPane extends GridPane {
	private PlayerBag playerBag;
	private int totalAttrPoints, avAttrPoints;
	private TextField tfName;
	private BackStoryPane backStory;
	private Label lblAvailablePoints;
	private AbilitiesViewer abilitiesViewer;
	private ButtonCreatePlayer btCreate;
	
	public CharacterBuilderPane(PlayerBag playerBag) {
		this.playerBag = playerBag;
		this.tfName = CharBuilderUtil.loadTfName(this);
		this.backStory = new BackStoryPane();
		this.lblAvailablePoints = new Label(
				CharBuilderUtil.STR_AVAIL_PTS + String.valueOf(CharBuilderUtil.INIT_ABILITY_POINTS));
		this.totalAttrPoints = CharBuilderUtil.INIT_ABILITY_POINTS;
		this.avAttrPoints = CharBuilderUtil.INIT_ABILITY_POINTS;
		this.abilitiesViewer = new AbilitiesViewer(this);
		this.btCreate = new ButtonCreatePlayer(this);
		CharBuilderUtil.displayControls(this);
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
	
	public TextField getTfName() {
		return tfName;
	}

	public BackStoryPane getBackStory() {
		return backStory;
	}

	public Label getLblAvailablePoints() {
		return lblAvailablePoints;
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
		lblAvailablePoints.setText(CharBuilderUtil.STR_AVAIL_PTS + String.valueOf(avAttrPoints));
	}
}
