package models.bag;

import models.item.Item;

/**
 * Add sort method
 * @author Camposm97
 *
 */
public class ItemBag {
	private Item[] items;
	private int nElems;
	
	public ItemBag(int maxSize) {
		this.items = new Item[maxSize];
		this.nElems = 0;
	}
	
	public void insert(Item item) {
		items[nElems++] = item;
	}
	
	public void getItemByName() {
		
	}
	
	public int size() {
		return nElems;
	}
}
