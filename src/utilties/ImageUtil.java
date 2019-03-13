package utilties;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImageUtil {
	public static final String ICON_MAIN = "icons/main.png";
	
	public static void loadStageIcon(Stage stage) {
		stage.getIcons().add(loadImg(ICON_MAIN));
	}
	
	public static Image loadImg(String url) {
		return new Image(url);
	}
	
	public static ImageView loadImgView(String url) {
		return new ImageView(loadImg(url));
	}
	
	public static ImageView loadImgView(Image image) {
		return new ImageView(image);
	}
}
