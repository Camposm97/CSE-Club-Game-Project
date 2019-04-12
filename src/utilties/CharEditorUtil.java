package utilties;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.entities.Player;
import models.statistics.Stat;
import scene.layout.CharacterEditorPane;

public class CharEditorUtil {
	private static final byte ICON_SIZE = 20;
	private static final float BAR_RATIO = (float) 0.35;
	private static final float HBOX_RATIO = (float) 0.5;
	private CharacterEditorPane charEditor;
	
	public CharEditorUtil(CharacterEditorPane charEditor) {
		this.charEditor = charEditor;
		displayControls();
	}
	
	public void displayControls() {
		charEditor.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		charEditor.setStyle("-fx-font-size: 20;");
		charEditor.getTabs().addAll(loadTabChar(), loadTabInventory(), loadTabOptions());
	}
	
	private Tab loadTabChar() {
		Tab tab = new Tab("Character", loadCharContent());
		ImageView iv = ImgUtil.loadIconChar();
		iv.setFitWidth(ICON_SIZE);
		iv.setFitHeight(ICON_SIZE);
		tab.setGraphic(iv);
		return tab;
	}
	
	private Tab loadTabInventory() {
		Tab tab = new Tab("Inventory");
		ImageView iv = ImgUtil.loadIconInventory();
		iv.setFitWidth(ICON_SIZE);
		iv.setFitHeight(ICON_SIZE);
		tab.setGraphic(iv);
		return tab;
	}
	
	private Tab loadTabOptions() {
		Tab tab = new Tab("Options");
		ImageView iv = ImgUtil.loadIconOptions();
		iv.setFitWidth(ICON_SIZE);
		iv.setFitHeight(ICON_SIZE);
		tab.setGraphic(iv);
		return tab;
	}
	
	private BorderPane loadCharContent() {
		Player p = charEditor.getPlayer();
		Label lblLvl = new Label("LVL: " + p.getStats().getLvl().getLvl());
		VBox vBox = new VBox(5);
		vBox.getChildren().addAll(loadHPBar(), loadMPBar());
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10));
		gridPane.add(new Label("Name: " + p.getName()), 0, 0);
		gridPane.add(lblLvl, 0, 1);
		gridPane.add(vBox, 0, 2);
		gridPane.add(new Separator(Orientation.VERTICAL), 1, 0, 1, 4);
		gridPane.add(new ImageView(ImgUtil.loadImg("resources/")), 2, 1);
//		gridPane.setGridLinesVisible(true);
		BorderPane root = new BorderPane(gridPane);
		return root;
	}
	
	private HBox loadHPBar() {
		Stat hitPts = charEditor.getPlayer().getStats().getHitPts();
		ProgressBar bar = new ProgressBar(hitPts.getPercentage());
		bar.setStyle("-fx-accent: #29E312;");
		bar.prefWidthProperty().bind(charEditor.widthProperty().multiply(BAR_RATIO));
		StackPane stackPane = new StackPane(bar);
		stackPane.getChildren().add(new Label("(" + hitPts.getCurrentPoints() + " / " + hitPts.getTotalPoints() + ")"));
		
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(new Label("HP:"), stackPane);
		hBox.prefWidthProperty().bind(charEditor.widthProperty().multiply(HBOX_RATIO));
		return hBox;
	}
	
	private HBox loadMPBar() {
		Stat manaPts = charEditor.getPlayer().getStats().getManaPts();
		ProgressBar bar = new ProgressBar(manaPts.getPercentage());
		bar.setStyle("-fx-accent: #268EEE;");
		bar.prefWidthProperty().bind(charEditor.widthProperty().multiply(BAR_RATIO));
		StackPane stackPane = new StackPane(bar);
		stackPane.getChildren().add(new Label("(" + manaPts.getCurrentPoints() + " / " + manaPts.getTotalPoints() + ")"));
		
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(new Label("MP:"), stackPane);
		hBox.prefWidthProperty().bind(charEditor.widthProperty().multiply(HBOX_RATIO));
		return hBox;
	}
	
	public static TextField loadTfName() {
		TextField tf = new TextField();
		tf.setEditable(false);
		return tf;
	}
}
