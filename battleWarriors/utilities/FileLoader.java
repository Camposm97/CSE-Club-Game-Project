package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.Attack;

public class FileLoader {
	
	AttackMaker attackMaker;
	ItemMaker itemMaker;
	MonsterMaker monsterMaker;
	
	public FileLoader(){
			loadAttackList();
	}
	
	public void saveAttackList () {
		ObjectOutputStream oos = null;
		File file = new File("resources\\programFiles\\AttackMaker.data");
		
		try {
			if (!file.isFile()) {
				file.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(this.attackMaker);
			oos.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void loadAttackList () {
		ObjectInputStream ois = null;
		File file = new File("resources\\programFiles\\AttackMaker.data");
		
		try {
			if (!file.isFile()) {
				this.attackMaker = new AttackMaker();
			}
			else {
				ois = new ObjectInputStream(new FileInputStream(file));
				this.attackMaker = new AttackMaker((AttackMaker)ois.readObject());
				ois.close();
				
				}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

	public AttackMaker getAttackMaker() {
		return attackMaker;
	}

	public void setAttackMaker(AttackMaker attackMaker) {
		this.attackMaker = attackMaker;
	}

	public ItemMaker getItemMaker() {
		return itemMaker;
	}

	public void setItemMaker(ItemMaker itemMaker) {
		this.itemMaker = itemMaker;
	}

	public MonsterMaker getMonsterMaker() {
		return monsterMaker;
	}

	public void setMonsterMaker(MonsterMaker monsterMaker) {
		this.monsterMaker = monsterMaker;
	}
	
}
