package cursor;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utilties.ImgUtil;

public class Demo extends Application {
	private BorderPane root;
	@Override
	public void init() {
		root = new BorderPane();
	}
	
	@Override
	public void start(Stage stage) {
		Image image = ImgUtil.loadImg("resources/images/icons/cursor.png");
		Scene scene = new Scene(root);
		scene.setCursor(new ImageCursor(image));
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
