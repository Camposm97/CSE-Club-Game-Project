package models;

public class AttackList {
	
	private Attack[] attacks;
	private int numOfAttacks;
	
	AttackList(){
		attacks = new Attack[25];
		numOfAttacks = 0;
	}
	AttackList(int listSize){
		attacks = new Attack[listSize];
		numOfAttacks = 0;
	}
	public Attack getAttack(int i) {
		return attacks[i];
	}
	public boolean isFull () {
		return this.numOfAttacks >= this.attacks.length;
	}
	public void addAttack(Attack attack) {
		if (!isFull()) {
			this.attacks[numOfAttacks++] = attack; 
		}
	}
	public void removeAttack(int index) {
		
	}
	public void replaceAttack (int index, Attack attack) {
		this.attacks[index] = new Attack(attack);
	}
	public void shiftListUp (int index) {
		if (!isFull() && index < numOfAttacks && numOfAttacks > 0) {
			for (int i = numOfAttacks; i > index; i--) {
				attacks[i] = attacks[i - 1];
			}
		}
	}
	public Attack[] getAttacks() {
		return attacks;
	}
	public void setAttacks(Attack[] attacks) {
		this.attacks = attacks;
	}
	public int getNumOfAttacks() {
		return numOfAttacks;
	}
	public void setNumOfAttacks(int numOfAttacks) {
		this.numOfAttacks = numOfAttacks;
	}
	

}
