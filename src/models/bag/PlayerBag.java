package models.bag;

import java.io.Serializable;

import models.entities.Player;

public class PlayerBag implements Serializable {
	private static final long serialVersionUID = -8874281386635667594L;
	private Player[] arr;
	private int nElems;
	private int maxSize;
	
	public PlayerBag(int maxSize) {
		this.arr = new Player[maxSize];
		this.nElems = 0;
		this.maxSize = maxSize;
	}
	
	public Player get(int i) {
		return arr[i];
	}
	
	public boolean add(Player p) {
		if (!isFull()) {
			arr[nElems++] = p;
			sort();
			return true;
		} else {
			return false;
		}
	}
	
	public void sort() {
		int n = nElems; 
        for (int i = 1; i < n; ++i) { 
            Player key = arr[i];
            int j = i - 1; 
            
            while (j >= 0 && arr[j].getName().compareTo(key.getName()) > 0) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key;
        }
	}
	
	public Player findById(String id) {
		for (int i = 0; i < nElems; i++)
			if (arr[i].getId().equals(id))
					return arr[i];
		return null;
	}
	
	public Player deleteById(String id) {
		int i;
		for (i = 0; i < nElems; i++)
			if (arr[i].getId().equals(id))
				break;
		if (i == nElems) {
			return null;
		} else {
			Player temp = arr[i];
			for (int j = i; j < (nElems - 1); j++) {
				arr[j] = arr[j - 1];
			}
			nElems--;
			return temp;
		}
	}
	
	public boolean isFull() {
		return nElems == maxSize;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++)
			System.out.println(arr[i]);
		System.out.println();
	}

	public int size() {
		return nElems;
	}
}
