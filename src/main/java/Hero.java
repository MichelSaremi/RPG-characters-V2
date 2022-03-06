import java.util.HashMap;

public class Hero {
	
	//---char
	private String name;
	private String character;
	private int level = 1;
	
	//---attributes
	private float base_Strength;
	private float base_Dexterity;
	private float base_Intelligence;
	
	private float total_Strength;
	private float total_Dexterity;
	private float total_Intelligence;
	
	
	//---damage
	private double damage_per_second;
	
	
	//---equipment
	HashMap<String,Item> equipment = new HashMap<>();
	
	//---constructor
	public Hero(String name, String character, int base_Strength, int base_Dexterity, int base_Intelligence) {
		this.name = name;
		this.character = character;
		this.base_Strength = base_Strength;
		this.base_Dexterity = base_Dexterity;
		this.base_Intelligence = base_Intelligence;
		
		//---total attributes initially set to base value
		this.total_Strength = base_Strength;
		this.total_Dexterity = base_Dexterity;
		this.total_Intelligence = base_Intelligence;
		
	}
	//---setters
	public void setBaseAtt(float base_Strength, float base_Dexterity, float base_Intelligence) {
		this.base_Strength = base_Strength;
		this.base_Dexterity = base_Dexterity;
		this.base_Intelligence = base_Intelligence;
	}
	public void setTotalAtt(float total_Strength, float total_Dexterity, float total_Intelligence) {
		this.total_Strength = total_Strength;
		this.total_Dexterity = total_Dexterity;
		this.total_Intelligence = total_Intelligence;
	}
	
	public void setLevel(int level) {
		this.level= level;
	}
	
	public void setDPS(double DPS) {
		this.damage_per_second=DPS;
	}
	
	public void setWeapon(Weapon weapon) {
		equipment.put("Weapon", weapon);
	}
	
	public void setArmor(Armor armor, String slot) {
		equipment.put(slot, armor);
	}
	
	//---getters
	public String getName() {
		return name;
	}
	public String getChar() {
		return character;
	}
	public int getLevel() {
		return level;
	}
	public float getBase_Strength() {
		return base_Strength;
	}
	public float getBase_Dexterity() {
		return base_Dexterity;
	}
	public float getBase_Intelligence() {
		return base_Intelligence;
	}
	public float getTotal_Strength() {
		return total_Strength;
	}
	public float getTotal_Dexterity() {
		return total_Dexterity;
	}
	public float getTotal_Intelligence() {
		return total_Intelligence;
	}

	public double getDPS() {
		return damage_per_second;
	}
	public Weapon getWeapon() {
		return (Weapon) equipment.get("Weapon");
	}
	public String getArmorName(String slot) {
		return ((Armor) equipment.get(slot)).getName();
	}
	public Armor getArmor(String slot) {
		return (Armor) equipment.get(slot);
	}
}	
	
