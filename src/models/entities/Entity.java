package models.entities;

public abstract class Entity {
	protected String name;

	public Entity(String name) {
		super();
		this.name = name;
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
