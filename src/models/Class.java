package models;

import java.io.Serializable;

import models.statistics.Abilities;

public class Class implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Role role;
	protected Abilities bonusAbilities;
	
	public Class(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}
	
	public Abilities getBonusAbilities() {
		return bonusAbilities;
	}
	
	@Override
	public String toString() {
		return "Class [role=" + role + "]";
	}

	public static void main(String[] args) {
		Class c = new Class(Role.Fighter);
		System.out.println(c);
	}
}
