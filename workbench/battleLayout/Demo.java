package battleLayout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import utilties.FXUtil;
import utilties.ImgUtil;

public class Demo extends Application {
	private BorderPane root;
	
	@Override
	public void start(Stage stage) throws Exception {
		root = new BorderPane();
		root.setCenter(loadCenterPane(stage));
		root.setBottom(loadBottomPane(stage));
		stage.setTitle("Demo (BattlePane)");
		stage.setScene(new Scene(root));
		stage.show();
		stage.setMinWidth(stage.getWidth());
		stage.setMinHeight(stage.getHeight());
		stage.setFullScreen(true);
	}
	
	/**
	 * Loads stats and background
	 * @param stage
	 * @return
	 */
	public Pane loadCenterPane(Stage stage) {
		ImageView imageView = new ImageView(ImgUtil.loadImg("resources/sample.gif"));
		imageView.setPreserveRatio(true);
		imageView.fitWidthProperty().bind(stage.widthProperty().multiply(0.99));
		imageView.fitHeightProperty().bind(stage.heightProperty().multiply(0.9));
		imageView.maxWidth(500);
		
		BorderPane borderPane = new BorderPane(getTriangle(), null, loadMonsterStats(), null, loadPlayerStats());		
		StackPane pane = new StackPane();
		pane.setStyle("-fx-background-color: black");
		pane.getChildren().addAll(imageView, borderPane);		
		return pane;
	}
	
	public Node loadBottomPane(Stage stage) {
		BorderPane pane = new BorderPane();
		pane.prefHeightProperty().bind(stage.heightProperty().multiply(0.05));
		pane.setPadding(FXUtil.DEFAULT_INSETS);
		pane.setRight(loadOptions(stage));
		return pane;
	}
	
	public Pane loadOptions(Stage stage) {
		Button btAttacks = new Button("Attacks");
		btAttacks.prefWidthProperty().bind(stage.widthProperty().multiply(0.1));
		Button btItems = new Button("Items");
		btItems.prefWidthProperty().bind(stage.widthProperty().multiply(0.1));
		Button btSkip = new Button("Skip Turn");
		btSkip.prefWidthProperty().bind(stage.widthProperty().multiply(0.1));
		Button btRun = new Button("Run");
		btRun.prefWidthProperty().bind(stage.widthProperty().multiply(0.1));
		VBox vBox = new VBox(5);
		vBox.getChildren().addAll(btAttacks, btItems, btSkip, btRun);
		
		Separator s1 = new Separator(Orientation.VERTICAL);
		Separator s2 = new Separator(Orientation.VERTICAL);
		
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(5);
		gridPane.addRow(0, s1, vBox, s2);
		return gridPane;
	}
	
	/**
	 * Returns Triangle on a StackPane
	 * @return StackPane
	 */
	public StackPane getTriangle() {
		Polygon poly = new Polygon();
		poly.setFill(Color.RED);
		poly.getPoints().addAll(new Double[] {0.0, 0.0, 100.0, 0.0, 50.0, 75.0});
		StackPane pane = new StackPane(poly);
		pane.setAlignment(Pos.TOP_CENTER);
		return pane;
	}
	
	/**
	 * No need to define two methods, use parameter CombatEntity
	 * @return VBox;
	 */
	public VBox loadPlayerStats() {
		ProgressBar hpBar = new ProgressBar(1.0);
		hpBar.prefWidthProperty().bind(root.widthProperty().divide(3));
		hpBar.setStyle("-fx-accent: #29E312;");
		ProgressBar mpBar = new ProgressBar(1.0);
		mpBar.prefWidthProperty().bind(root.widthProperty().divide(3)); // make 3 final
		mpBar.setStyle("-fx-accent: #268EEE;");
		
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(20));
//		vBox.setAlignment(Pos.TOP_RIGHT);
		vBox.getChildren().addAll(hpBar, mpBar);
		return vBox;
	}
	
	public VBox loadMonsterStats() {
		ProgressBar hpBar = new ProgressBar(1.0);
		hpBar.prefWidthProperty().bind(root.widthProperty().divide(3));
		hpBar.setStyle("-fx-accent: #29E312;");
		ProgressBar mpBar = new ProgressBar(1.0);
		mpBar.prefWidthProperty().bind(root.widthProperty().divide(3)); // make 3 final
		mpBar.setStyle("-fx-accent: #268EEE;");
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(20));
//		vBox.setAlignment(Pos.TOP_LEFT);
		vBox.getChildren().addAll(hpBar, mpBar);
		return vBox;
	}
	
	public static void main(String[] args) {
		launch(args);
//		RatioUtil.calcRatios(1032, 510);
	}
}
