package models;

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
