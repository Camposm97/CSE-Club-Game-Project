package scene.layout;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.entities.Player;
import models.statistics.Abilities;
import models.statistics.Stat;
import utilties.FXUtil;
import utilties.ImgUtil;

public class PlayerEditorPane extends TabPane {
	private Player p;
	
	public PlayerEditorPane(Player player) {	// Constructor
		this.p = player;
		new PlayerEditorUtil(this);
	}
	
//	public Player getP() {
//		return p;
//	}
	
	private class PlayerEditorUtil {
		private static final byte ICON_SIZE = 32;
		private static final float BAR_RATIO = (float) 0.25;
		private static final float HBOX_RATIO = (float) 0.35;
		private PlayerEditorPane charEditor;
		
		public PlayerEditorUtil(PlayerEditorPane charEditor) {	// Constructor
			this.charEditor = charEditor;
			this.charEditor.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
			this.charEditor.setStyle("-fx-font-size: 24;");
			this.charEditor.getTabs().add(loadTabChar());
			this.charEditor.getTabs().add(loadTabInventory());
			this.charEditor.getTabs().add(loadTabOptions());
		}
		
		private Tab loadTabChar() {
			Tab tab = new Tab("Character", new CharPane());
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
			Tab tab = new Tab("Options", new OptionsPane());
			ImageView iv = ImgUtil.loadIconOptions();
			iv.setFitWidth(ICON_SIZE);
			iv.setFitHeight(ICON_SIZE);
			tab.setGraphic(iv);
			return tab;
		}
			
		private class CharPane extends BorderPane {
			public CharPane() {
				this.setCenter(loadCenter());
				this.setBottom(loadBottom());
				this.setLeft(loadLeft());
				this.setPadding(FXUtil.DEFAULT_INSETS);
			}
			
			private GridPane loadCenter() {
				Label lblLvl = new Label("LVL " + p.getStats().getLvl().getLvl());
				VBox vBox = new VBox(5);
				vBox.getChildren().addAll(loadHpBox(), loadMpBox());
				GridPane gridPane = new GridPane();
				gridPane.setPadding(FXUtil.DEFAULT_INSETS);
				gridPane.setHgap(10);
				gridPane.setVgap(10);
				gridPane.add(new Label("Name: " + p.getName()), 0, 0);
				gridPane.add(lblLvl, 0, 1);
				gridPane.add(vBox, 0, 2);
				gridPane.add(loadStats(), 0, 3, 3, 2);
				return gridPane;
			}
			
			private GridPane loadStats() {
				Abilities abils = p.getStats().getAbils();
				Label lblStr = new Label(abils.getAbilStr().toString());
				Label lblDex = new Label(abils.getAbilDex().toString());
				Label lblCon = new Label(abils.getAbilCon().toString());
				Label lblInt = new Label(abils.getAbilInt().toString());
				Label lblWis = new Label(abils.getAbilWis().toString());
				Label lblCha = new Label(abils.getAbilCha().toString());
				GridPane gridPane = new GridPane();
				gridPane.setStyle("-fx-border-color: lightgray");
//				gridPane.setAlignment(Pos.CENTER);
				gridPane.setPadding(FXUtil.DEFAULT_INSETS);
				gridPane.setVgap(10);
				gridPane.setHgap(20);
				gridPane.add(lblStr, 0, 0);
				gridPane.add(lblDex, 0, 1);
				gridPane.add(lblCon, 0, 2);
				gridPane.add(new Separator(Orientation.VERTICAL), 1, 0, 1, 4);
				gridPane.add(lblInt, 2, 0);
				gridPane.add(lblWis, 2, 1);
				gridPane.add(lblCha, 2, 2);
				return gridPane;
			}
			
			private VBox loadLeft() {
				ImageView ivChar = new ImageView(ImgUtil.loadImg("resources/images/monsters/isaac.png"));
				StackPane stackPane = new StackPane(ivChar);
				stackPane.setPadding(FXUtil.DEFAULT_INSETS);
				stackPane.setStyle("-fx-border-color: lightgray;");
				
				TextArea ta = new TextArea(p.getBackStory());
				ta.setStyle("-fx-font-size: 16");
				ta.setEditable(false);
				ta.setWrapText(true);
				ta.setPrefWidth(stackPane.getWidth());
				
				VBox vBox = new VBox(10);
				vBox.setPadding(FXUtil.DEFAULT_INSETS);
//				vBox.setAlignment(Pos.CENTER);
				vBox.getChildren().addAll(stackPane,ta);
				return vBox;
			}
			
			private HBox loadBottom() {
				Separator sep = new Separator(Orientation.VERTICAL);
				Label lblTotalXp = new Label("Total XP: " + p.getStats().getLvl().getTotalXp());
				Label lblRequiredXp = new Label("XP Needed to Level Up: " + p.getStats().getLvl().getRequiredXp());
				HBox hBox = new HBox(10);
				hBox.setStyle("-fx-border-color: lightgray;");
				hBox.setPadding(FXUtil.DEFAULT_INSETS);
				hBox.setAlignment(Pos.CENTER);
				hBox.getChildren().addAll(lblTotalXp, sep, lblRequiredXp);
				return hBox;
			}
			
			private HBox loadHpBox() {
				Stat hitPts = p.getStats().getHitPts();
				ProgressBar bar = new ProgressBar(hitPts.getPercentage());
				bar.setStyle("-fx-accent: #29E312;");
				bar.prefWidthProperty().bind(charEditor.widthProperty().multiply(BAR_RATIO));
				StackPane stackPane = new StackPane(bar);
				stackPane.getChildren().add(new Label(hitPts.toString()));
				
				HBox hBox = new HBox(10);
				hBox.getChildren().addAll(new Label("HP:"), stackPane);
				hBox.prefWidthProperty().bind(charEditor.widthProperty().multiply(HBOX_RATIO));
				return hBox;
			}
			
			private HBox loadMpBox() {
				Stat manaPts = p.getStats().getManaPts();
				ProgressBar bar = new ProgressBar(manaPts.getPercentage());
				bar.setStyle("-fx-accent: #268EEE;");
				bar.prefWidthProperty().bind(charEditor.widthProperty().multiply(BAR_RATIO));
				StackPane stackPane = new StackPane(bar);
				stackPane.getChildren().add(new Label(manaPts.toString()));
				
				HBox hBox = new HBox(10);
				hBox.getChildren().addAll(new Label("MP:"), stackPane);
				hBox.prefWidthProperty().bind(charEditor.widthProperty().multiply(HBOX_RATIO));
				return hBox;
			}
		}
		
//		private class InventoryPane extends BorderPane {
//			
//		}
//		
		private class OptionsPane extends BorderPane {
			public OptionsPane() {
				this.setCenter(loadCenter());
				this.setPadding(FXUtil.DEFAULT_INSETS);
			}
			
			private GridPane loadCenter() {
				TextArea ta = new TextArea();
				ta.prefWidthProperty().bind(this.widthProperty().divide(2));
				ta.prefHeightProperty().bind(this.heightProperty().divide(2));
				ta.setEditable(false);
				ta.setWrapText(true);
				
				Button btSave = new Button("Save");
				btSave.prefWidthProperty().bind(this.widthProperty().divide(2));
				btSave.setOnMouseEntered(e -> {
					ta.setText("Save the current game.");
				});
				Button btLoad = new Button("Load");
				btLoad.setOnMouseEntered(e -> {
					ta.setText("Load a saved game.");
				});
				btLoad.prefWidthProperty().bind(this.widthProperty().divide(2));
				Button btGraphics = new Button("Graphics");
				btGraphics.setOnMouseEntered(e -> {
					ta.setText("Graphic Options");
				});
				btGraphics.prefWidthProperty().bind(this.widthProperty().divide(2));
				Button btExit = new Button("Exit Game");
				btExit.setOnMouseEntered(e -> {
					ta.setText("Exit the game and go to title screen.");
				});
				btExit.prefWidthProperty().bind(this.widthProperty().divide(2));
				
				VBox vBox = new VBox(10);
				vBox.setAlignment(Pos.TOP_CENTER);
				vBox.getChildren().addAll(btSave, btLoad, btGraphics, btExit);
				
				
				
				GridPane gridPane = new GridPane();
				gridPane.setHgap(10);
				gridPane.add(vBox, 0, 0, 1, 3);
				gridPane.add(ta, 1, 0, 1, 3);
				return gridPane;
			}
		}
	}
}