package checkBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Demo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		CheckBox box = new CheckBox();
		Button bt = new Button("Check");
		bt.setOnAction(e -> {
			System.out.println(box.isSelected());
		});
		root.setCenter(box);
		root.setBottom(bt);
		stage.setScene(new Scene(root));
		stage.show();
	}
}
