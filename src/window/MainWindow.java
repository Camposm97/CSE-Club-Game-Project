package window;

import javafx.scene.Scene;
import javafx.stage.Stage;
import utilties.FXUtil;
import utilties.ImageUtil;

public class MainWindow {
	public MainWindow(Stage stage) {
		ImageUtil.loadStageIcon(stage);
		stage.setScene(new Scene(FXUtil.loadRoot()));
		stage.setTitle("Character Builder");
		stage.show();
	}
}
