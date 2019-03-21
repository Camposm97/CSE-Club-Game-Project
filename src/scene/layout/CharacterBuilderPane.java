package scene.layout;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import scene.control.buttons.ButtonCreatePlayer;
import utilties.character.CharacterBuilderPaneUtil;

public class CharacterBuilderPane extends CharacterPane {
	private int totalAttrPoints, avAttrPoints;
	private Label lblAvailablePoints;
	private AttributesViewer attrViewer;
	private ButtonCreatePlayer btCreate;

	public CharacterBuilderPane(int totalAtrrPoints) {
		this.lblAvailablePoints = new Label(CharacterBuilderPaneUtil.AV_POINTS + String.valueOf(totalAtrrPoints));
		this.totalAttrPoints = totalAtrrPoints;
		this.avAttrPoints = totalAtrrPoints;
		this.attrViewer = new AttributesViewer(this);
		this.btCreate = new ButtonCreatePlayer(this);
		CharacterBuilderPaneUtil.displayControls(this);
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

	public AttributesViewer getAttrViewer() {
		return attrViewer;
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
		lblAvailablePoints.setText(CharacterBuilderPaneUtil.AV_POINTS + String.valueOf(avAttrPoints));
	}
}
