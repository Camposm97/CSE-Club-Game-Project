package utilties;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarBuiltUtil {  
	public static void loadMenus(MenuBar menuBar) {
		menuBar.getMenus().addAll(loadMenuFile());
	}
	
	public static Menu loadMenuFile() {
		Menu menu = new Menu("File");
		menu.getItems().addAll(loadMIExit());
		return menu;
	}
	
	public static MenuItem loadMIExit() {
		MenuItem mi = new MenuItem("Exit");
		mi.setOnAction(e -> {
			Platform.exit();
		});
		return mi;
	}
}
