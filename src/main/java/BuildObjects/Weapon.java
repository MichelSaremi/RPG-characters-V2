package BuildObjects;

public class Weapon extends Item {
	
	//---properties
	private double damage;
	private double attacks_per_second;
	

	//---constructors
	public Weapon(String name, int req_lvl, double damage, double a_p_s, String[] character) {
		super(name, req_lvl, character);
		this.damage = damage;
		this.attacks_per_second = a_p_s;

	}
	
	//---getters
	public double getDamage() {
		return damage;
	}
	public double getAttacks_per_second() {
		return attacks_per_second;
	}
	
}
