

public class Armor extends Item {
	
	//---properties
	private int strength_add;
	private int dexterity_add;
	private int intelligence_add;
	
	//---constructors
	
	public Armor(String name, int req_lvl, int str, int dex, int intel, String[] character) {
		super(name, req_lvl, character);
		this.strength_add = str;
		this.dexterity_add = dex;
		this.intelligence_add = intel;
	}
	
	//---getters
	public int getStrength() {
		return strength_add;
	}
	public int getDexterity() {
		return dexterity_add;
	}
	public int getIntelligence() {
		return intelligence_add;
	}
}
