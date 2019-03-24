package utilties;

import scene.layout.CharacterBuilderPane;
import scene.layout.PlayerLoaderPane;
import scene.layout.TitleScreenPane;

public class SceneLoader {
	public static void loadCharacterBuilder(TitleScreenPane titleScreenPane) {
		titleScreenPane.getScene().setRoot(new CharacterBuilderPane(titleScreenPane.getPlayerBag()));
	}
	
	public static void loadPlayerLoaderPane(TitleScreenPane titleScreenPane) {
		titleScreenPane.getScene().setRoot(new PlayerLoaderPane(titleScreenPane.getPlayerBag()));
	}
}
