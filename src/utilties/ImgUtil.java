package utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ImgUtil {
	public static final String ICON_MAIN = "resources/images/icons/main.png";
	public static final String ICON_CHAR = "resources/images/icons/character.png";
	public static final String ICON_INV = "resources/images/icons/inventory.png";
	public static final String ICON_OPTIONS = "resources/images/icons/options.png";
	
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
	
	public static ImageView loadIconChar() {
		return new ImageView(loadImg(ICON_CHAR));
	}
	
	public static ImageView loadIconInventory() {
		return new ImageView(loadImg(ICON_INV));
	}
	
	public static ImageView loadIconOptions() {
		return new ImageView(loadImg(ICON_OPTIONS));
	}
}
