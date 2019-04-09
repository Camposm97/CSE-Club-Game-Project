package utilties;

import java.io.File;

import io.ObjectFile;
import models.bag.PlayerBag;

public class DataSaver {
	public static void savePlayerBag(PlayerBag bag) {
		File file = new File(Paths.PLAYER_BAG_PATH);
		if (!file.exists())
			new File(Paths.SYSTEM_DATA).mkdir();
		ObjectFile file1 = new ObjectFile(file);
		file1.writeObject(bag);
	}
}
