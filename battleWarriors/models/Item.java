package models;

import java.io.Serializable;

public class Item extends Entity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 605190315065325415L;
	private int id;
	private int price;
	
	Item (int id, String name, String description){
		
		super(name, description);
		this.setId(id);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
