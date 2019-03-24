package models.entities;

import java.io.Serializable;

public abstract class Entity implements Serializable {
	private static int idNumber;
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
