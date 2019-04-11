package models;

import java.io.Serializable;

public class Class implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Role role;
	
	public Class(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
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
