package gui;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LogWindow {
	
	int windowWidth;
	int windowHeight;
	TextArea window;
	Log log;
	
	public LogWindow(GUISettings settings){
		windowWidth = ((int)(settings.getWidth() * .2));
		windowHeight = ((int)(settings.getHeight()* .7));
		window = new TextArea();
		window.setMaxSize(windowWidth, windowHeight);
		window.setMinSize(windowWidth, windowHeight);
		window.setWrapText(true);
		
	}
	public void printLog() {
		window.setText(log.printToBattleLog());
	}
}
