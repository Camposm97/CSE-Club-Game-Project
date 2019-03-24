package characterBuilder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.bag.PlayerBag;
import scene.layout.CharacterBuilderPane;

public class Demo extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(new CharacterBuilderPane(new PlayerBag(10))));
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
