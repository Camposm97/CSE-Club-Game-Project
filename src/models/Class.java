package models;

public class Class {
	protected String type;
	
	public Class(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "Class [type=" + type + "]";
	}

	public static void main(String[] args) {
		Class c = new Class("Fighter");
		System.out.println(c);
	}
}
