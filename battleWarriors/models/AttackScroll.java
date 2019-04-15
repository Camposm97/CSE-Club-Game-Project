package models;

import java.io.Serializable;

public class AttackScroll extends Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5580230173530049942L;
	Attack attack;

	AttackScroll(int id, String name, String description, Attack attack) {
		
		super(id, name, description);
		this.attack = attack;
	}

	public Attack getAttack() {
		return attack;
	}

	public void setAttack(Attack attack) {
		this.attack = attack;
	}

}
