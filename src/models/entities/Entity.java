package models.entities;

import java.io.Serializable;

public abstract class Entity implements Serializable {
	private static final long serialVersionUID = 2596708375689899578L;
	private static int idNumber = 0;
	protected String id;
	protected String name;

	public Entity(String name) {
		this.id = String.valueOf(idNumber++);
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Entity [name=" + name + "]";
	}
}
