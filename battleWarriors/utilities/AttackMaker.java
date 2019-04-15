package utilities;

import java.io.IOException;
import java.io.Serializable;

import models.*;

public class AttackMaker implements Serializable {
	private static final long serialVersionUID = 96305879098617050L;
	private Attack[] masterAttackList;
	private int numAttacks;

	public AttackMaker() {
		this.masterAttackList = new Attack[500];
		for (int i = 0; i < 500; i++) {
			masterAttackList[i] = null;
		}
		this.numAttacks = 0;
	}

	public AttackMaker(Attack[] list) {
		this.masterAttackList = list;
		this.numAttacks = list.length;
	}

	public AttackMaker(AttackMaker maker) {
		this.masterAttackList = new Attack[500];

		try {
			this.numAttacks = maker.getNumAttacks();
			for (int i = 0; i < maker.numAttacks; i++) {
				this.addToMasterList(maker.getMasterAttackList()[i]);
			}
		} catch (Exception io) {
			io.printStackTrace();
		}
	}

//	public void organizeList() {
//		for (int i = 0; i < numAttacks)
//	}

	public void removeAttack(int ID) {
		this.shiftList(ID);
	}

	public boolean isFull() {
		if (numAttacks >= 500) {
			return true;
		} else {
			return false;
		}
	}

	public void addToMasterList(Attack attack) {
		if (!isFull()) {
			masterAttackList[attack.getID()] = attack;
			this.numAttacks++;
		}
	}

	public Attack[] getMasterAttackList() {
		return masterAttackList;
	}

	public void shiftList(int ID) {
		for (int i = ID; i < this.getNumAttacks() - 1; i++) {
			this.masterAttackList[i] = this.masterAttackList[i + 1];

		}
		this.numAttacks--;
	}

	public void setMasterAttackList(Attack[] masterAttackList) {
		this.masterAttackList = masterAttackList;
	}

	public int getNumAttacks() {
		return numAttacks;
	}

	public void setNumAttacks(int numAttacks) {
		this.numAttacks = numAttacks;
	}

	public String attackListToString() {
		String temp = new String();
		for (int i = 0; i < numAttacks; i++) {
			temp += (masterAttackList[i].attackToString() + "\n");
		}
		return temp;
	}
}
