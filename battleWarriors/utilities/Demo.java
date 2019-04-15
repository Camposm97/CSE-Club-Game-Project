package utilities;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.*;
import models.Character;

public class Demo extends Application {

	@Override
	public void start(Stage mainStage) throws Exception {
		
		mainStage.setFullScreen(true);
		
		WindowBuilder windowBuilder = new WindowBuilder(mainStage);
		windowBuilder.getLoginWindow();
		
		Character chris = new Player();
		Character chris2 = new Enemy(); 
		Character[] collection = {chris, chris2};
		

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
