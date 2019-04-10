package utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ImageUtil {
	public static final String ICON_MAIN = "resources/images/icons/main.png";
	public static final String ICON_OPTIONS = "resources/images/icons/options.png";
	public static final String ICON_CHAR = "resources/images/icons/character.png";
	
	public static void loadStageIcon(Stage stage) {
		stage.getIcons().add(loadImg(ICON_MAIN));
	}
	
	public static Image loadImg(String url) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(url));
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		return new Image(fis);
	}
}
