package characterBuilder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilties.loader.FXLoader;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(FXLoader.loadCharacterBuilder()));
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
