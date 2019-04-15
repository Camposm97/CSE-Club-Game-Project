package utilties;

import scene.layout.PlayerBuilderPane;
import scene.layout.PlayerLoaderPane;
import scene.layout.TitleScreenPane;

public class SceneLoader {
	public static void loadCharacterBuilder(TitleScreenPane titleScreenPane) {
		titleScreenPane.getScene().setRoot(new PlayerBuilderPane(titleScreenPane.getPlayerBag()));
	}
	
	public static void loadPlayerLoaderPane(TitleScreenPane titleScreenPane) {
		titleScreenPane.getScene().setRoot(new PlayerLoaderPane(titleScreenPane.getPlayerBag()));
	}
}
