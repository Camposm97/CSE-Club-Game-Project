package levelUpSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.entities.Player;
import stats.Abilities;

public class Demo extends Application {
	private Player p1;
	private TextArea ta;

	@Override
	public void init() {
		p1 = new Player("Michael", new Abilities(0,0,0,0,0,0), "");
		ta = new TextArea();
		ta.setEditable(false);
		ta.setPrefColumnCount(28);
	}

	@Override
	public void start(Stage stage) {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.add(new Label("Name: "), 0, 0);
		gridPane.add(new Label(p1.getName()), 1, 0);
		gridPane.add(ta, 1, 1, 2, 50);
		gridPane.add(loadButtons(), 0, 1);
		StackPane root = new StackPane(gridPane);
		root.setPadding(new Insets(30));
		stage.setScene(new Scene(root));
		stage.show();
	}

	private VBox loadButtons() {
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER_LEFT);
		vBox.getChildren().addAll(loadBtAddXp(), loadBtAdd5Xp(), loadBtAdd10Xp(), loadBtAdd50Xp(), loadBtAdd100Xp(),
				loadBtAdd1000Xp(), loadBtLevelUp(), loadBtClear());
		return vBox;
	}

	private Button loadBtAddXp() {
		Button bt = new Button("+1 XP");
		bt.setOnAction(e -> {
			p1.getStats().getLvl().addXp(1);
			displayLevel();
		});
		return bt;
	}

	private Button loadBtAdd5Xp() {
		Button bt = new Button("+5 XP");
		bt.setOnAction(e -> {
			p1.getStats().getLvl().addXp(5);
			displayLevel();
		});
		return bt;
	}

	private Button loadBtAdd10Xp() {
		Button bt = new Button("+10 XP");
		bt.setOnAction(e -> {
			p1.getStats().getLvl().addXp(10);
			displayLevel();
		});
		return bt;
	}

	private Button loadBtAdd50Xp() {
		Button bt = new Button("+50 XP");
		bt.setOnAction(e -> {
			p1.getStats().getLvl().addXp(50);
			displayLevel();
		});
		return bt;
	}

	private Button loadBtAdd100Xp() {
		Button bt = new Button("+100 XP");
		bt.setOnAction(e -> {
			p1.getStats().getLvl().addXp(100);
			displayLevel();
		});
		return bt;
	}

	private Button loadBtAdd1000Xp() {
		Button bt = new Button("+ 1000 XP");
		bt.setOnAction(e -> {
			p1.getStats().getLvl().addXp(1000);
			displayLevel();
		});
		return bt;
	}
	
	private Button loadBtLevelUp() {
		Button bt = new Button("Level Up");
		bt.setOnAction(e -> {
			p1.getStats().getLvl().levelUp();
			displayLevel();
		});
		return bt;
	}
	
	private Button loadBtClear() {
		Button bt = new Button("Clear");
		bt.setOnAction(e -> {
			ta.clear();
		});
		return bt;
	}

	private void displayLevel() {
		ta.appendText(p1.getStats().getLvl() + "\n" + "XP needed to level up: " + p1.getStats().getLvl().getRequiredXp() + "\n");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
