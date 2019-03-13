package menu;

import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import utilties.MenuBarBuiltUtil;

public class MenuBarBuilt extends MenuBar {
	private BorderPane root;
	
	public MenuBarBuilt(BorderPane root) {
		this.root = root;
		MenuBarBuiltUtil.loadMenus(this);
	}
	
	public BorderPane getRoot() {
		return root;
	}
}
