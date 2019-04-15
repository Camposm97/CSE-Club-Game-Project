package animation;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import utilties.FXUtil;
import utilties.ImgUtil;

public class Demo extends Application {
	private StackPane pane;
	private ImageView iv;
	private BorderPane root;
	private Button btPlay;
	
	@Override
	public void init() {
		iv = new ImageView(ImgUtil.loadImg("resources/images/monsters/isaac.png"));
		pane = new StackPane(iv);
		root = new BorderPane(pane);
		root.setPadding(FXUtil.DEFAULT_INSETS);
		btPlay = new Button("Play");
		btPlay.setOnAction(e -> { attack(); });
		root.setBottom(new StackPane(btPlay));
		iv.xProperty().bind(pane.widthProperty().multiply(0.3));
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	public void attack() {		
		Line line = new Line();
//		pane.getChildren().add(line);
		line.startXProperty().bind(pane.widthProperty().divide(2));
		line.startYProperty().bind(pane.heightProperty().divide(2));
		line.endXProperty().bind(pane.widthProperty().divide(2).add(25));
		line.endYProperty().bind(pane.heightProperty().divide(2));
		PathTransition path = new PathTransition();
		path.setDuration(Duration.millis(25));
//		path.setRate();
//		path.setOnFinished(e -> {
//			System.out.println("Animation Finished");
//		});
//		path.setDelay(Duration.millis(500));
//		path.setCycleCount(PathTransition.INDEFINITE);
		path.setCycleCount(2);
		path.setPath(line);
		path.setNode(pane);
		path.setAutoReverse(true);
		path.play();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
