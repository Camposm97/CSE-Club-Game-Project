package scene.layout;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import models.bag.PlayerBag;
import models.statistics.Stat;
import models.statistics.StatType;
import scene.control.ButtonCreatePlayer;
import utilties.CharBuilderUtil;

public class PlayerBuilderPane extends GridPane {
	private PlayerBag playerBag;
	private Stat abilityPts;	// Replace totalPoints and currentPoints with this.
	private int totalPoints, currentPoints;
	private TextField tfName;
	private BackStoryPane backStory;
	private Label lblAvailPts;
	private AbilitiesViewer abilsViewer;
	private ButtonCreatePlayer btCreate;

	public PlayerBuilderPane(PlayerBag playerBag) { // Constructor
		this.playerBag = playerBag;
		this.abilityPts = new Stat(StatType.Ability, CharBuilderUtil.INIT_ABILITY_PTS);
		this.tfName = CharBuilderUtil.loadTfName(this);
		this.backStory = new BackStoryPane();
		this.lblAvailPts = new Label(CharBuilderUtil.AVAIL_PTS_TXT + String.valueOf(CharBuilderUtil.INIT_ABILITY_PTS));
		this.totalPoints = CharBuilderUtil.INIT_ABILITY_PTS;
		this.currentPoints = CharBuilderUtil.INIT_ABILITY_PTS;
		this.abilsViewer = new AbilitiesViewer(this);
		this.btCreate = new ButtonCreatePlayer(this);
		CharBuilderUtil.displayControls(this);
	}

	public PlayerBag getPlayerBag() {
		return playerBag;
	}
	
	public Stat getAbilityPts() {
		return abilityPts;
	}

	public int getTotalAbilPts() {
		return totalPoints;
	}

	public int getAvailAbilityPts() {
		return currentPoints;
	}

	public void setAvailAbilPts(int currentPoints) {
		this.currentPoints = currentPoints;
	}

	public AbilitiesViewer getAbilsViewer() {
		return abilsViewer;
	}

	public TextField getTfName() {
		return tfName;
	}

	public BackStoryPane getBackStory() {
		return backStory;
	}

	public Label getLblAvailPts() {
		return lblAvailPts;
	}

	public ButtonCreatePlayer getBtCreate() {
		return btCreate;
	}

	public boolean isAvailAbilPtsEmpty() {
		return currentPoints <= 0;
	}

	public boolean isAvailAbilPtsFull() {
		return totalPoints < currentPoints;
	}

	public void updateLblAvailPts() {
		lblAvailPts.setText(CharBuilderUtil.AVAIL_PTS_TXT + String.valueOf(currentPoints));
	}
}
