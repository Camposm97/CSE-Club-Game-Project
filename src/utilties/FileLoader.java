package utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import models.bag.PlayerBag;

public class FileLoader {
	public static final String FILE_PLAYER_BAG = "playerBag.dat";
	
	public static PlayerBag loadPlayerBag() {
		PlayerBag playerBag = null;
		File file = new File(FILE_PLAYER_BAG);
		System.out.println(file.exists());
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			playerBag = (PlayerBag) ois.readObject();
			ois.close();
			System.out.println("Successfully loaded PlayerBag!");
			playerBag.display();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("PlayerBag Data is Empty or Missing!");
			e.printStackTrace();
		}
		finally {
			if (playerBag == null) {
				System.out.println("Creating a new PlayerBag");
				playerBag = new PlayerBag(100);	
			} else {
//				System.out.println("Successfully loaded PlayerBag!");
//				playerBag.display();
			}
		}
		return playerBag;
	}
}
