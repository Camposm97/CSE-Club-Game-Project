package utilties;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HandlerUtil {	
	/**
	 * Terminates the program when "Esc" key is pressed.
	 * @param pane
	 */
	public static void impExitKey(Pane pane) {
		pane.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode().equals(KeyCode.ESCAPE))
				Platform.exit();
		});
	}
	
	/**
	 * Sets the Stage to Full Screen when F11 is pressed
	 * @param pane
	 */
	public static void impFullScreen(Stage stage) {
		stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode().equals(KeyCode.F11)) {
				if (stage.isFullScreen()) {	// is fullscreen?
					stage.setFullScreen(false);
				} else { // else set fullscreen
					stage.setFullScreen(true);
				}
			}
		});
	}
}
