package utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import models.bag.PlayerBag;

public class DataLoader {
	public static PlayerBag loadPlayerBag() {
		PlayerBag playerBag = null;
		File file = new File(PathUtil.PLAYER_BAG_PATH);
//		System.out.println("Does " + PathUtil.PLAYER_BAG_PATH + " exist? " + file.exists());
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			playerBag = (PlayerBag) ois.readObject();
			ois.close();
			System.out.println("Successfully loaded PlayerBag!");
			System.out.println("Loaded " + playerBag.size() + " players");
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("PlayerBag Data is Empty or Missing! :(");
			System.err.println(e);
			System.out.println("Alternative: Creating a new PlayerBag");
			playerBag = new PlayerBag(100); // Max Size
		}
//		if (playerBag == null) {
//			System.out.println("Alternative: Creating a new PlayerBag");
//			playerBag = new PlayerBag(100); // Max Size?
//		}
		return playerBag;
	}
}
