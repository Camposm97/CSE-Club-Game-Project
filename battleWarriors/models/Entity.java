package models;

import java.io.Serializable;

public class Entity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6135810886416758279L;
	private String name;
	private String description;
	
	Entity (String name, String description){
		this.setName(name);
		this.setDescription(description);
	}
	Entity (){
		name = new String();
		description = new String();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
