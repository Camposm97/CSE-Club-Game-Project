package utilties.system;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class HandlerUtil {	
	public static void impExitKey(Pane pane) {
		pane.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode().equals(KeyCode.ESCAPE))
				Platform.exit();
		});
	}
}
