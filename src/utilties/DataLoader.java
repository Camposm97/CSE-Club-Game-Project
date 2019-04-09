package utilties;

import io.ObjectFile;
import models.bag.PlayerBag;

public class DataLoader {
	public static PlayerBag loadPlayerBag() {
		PlayerBag playerBag = null;
		try {
			ObjectFile file = new ObjectFile(Paths.PLAYER_BAG_PATH);
			playerBag = (PlayerBag) file.readObject();
			System.out.println("Loaded " + playerBag.size() + " player(s)");
		} catch (Exception e) {
			System.err.println("PlayerBag Data is Empty or Missing! :(");
			System.out.println("Alternative: Creating a new PlayerBag Object");
			playerBag = new PlayerBag(100);	// Max Size? Make LinkedList?
		}
		return playerBag;
	}
}
