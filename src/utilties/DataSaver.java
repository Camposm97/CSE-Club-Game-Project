package utilties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import models.bag.PlayerBag;

public class DataSaver {
	public static void savePlayerBag(PlayerBag bag) {
		File file = new File(PathUtil.PLAYER_BAG_PATH);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.exists());
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(bag);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
