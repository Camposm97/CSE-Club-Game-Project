package utilities;

import gui.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.*;

public class WindowBuilder {
	private GUISettings settings;
	private Pane window;
	private Pane display;
	private DisplayWindows displayWindows;
	
	
	WindowBuilder(Stage stage){
		int width = (int) Screen.getPrimary().getVisualBounds().getWidth();	// Nice! @Camposm97
		int height = (int) Screen.getPrimary().getVisualBounds().getHeight();
		displayWindows = new DisplayWindows();
		int font = 20;
		if (height < 900) {	// Is this some sort of principle?  A rule?  @Camposm97
			font = 16;
		}
		settings = new GUISettings(width, height, font);
		buildWindow(stage);
		
	}
	
	public void buildWindow(Stage stage) {
		int width = this.settings.getWidth();
		int height = this.settings.getHeight();
		window = new Pane();
		window.setPrefSize(width, height);	
		
		VBox container = new VBox();
		container.setPrefSize(width, height);
		container.setAlignment(Pos.CENTER);
		
		display = displayWindows.getDisplay(width, height);
		HBox topMenu = displayWindows.getTopMenu(this.settings, display);
		
		
		container.getChildren().addAll(topMenu, display);
		window.getChildren().add(container);
		
		stage.setScene(new Scene(window, width, height));
		stage.setTitle("Battle Warriors Developement 1.0");
		stage.show();
	}
	
	public void getLoginWindow () {
		this.display.getChildren().add(displayWindows.getLogin(this.settings, this.display));
	}
	public void getCharacterBuilderWindow() {
		
	}

	//getters and setters for the window and display.
	
	public Pane getWindow() {
		return window;
	}
	public void setWindow(Pane window) {
		this.window = window;
	}
	public Pane getDisplay() {
		return display;
	}

	public void setDisplay(Pane display) {
		this.display = display;
	}

	public GUISettings getSettings() {
		return settings;
	}

	public void setSettings(GUISettings settings) {
		this.settings = settings;
	}

}
