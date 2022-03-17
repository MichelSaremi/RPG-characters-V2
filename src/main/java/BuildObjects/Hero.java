package BuildObjects;

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
	
	//private float total_Strength;
	//private float total_Dexterity;
	//private float total_Intelligence;
	
	
	//---damage
	private double damage_per_second;
	
	
	//---equipment
	enum slotType{
		HEAD,
		BODY,
		LEGS,
		WEAPON,
	}

	HashMap<slotType, Item> equipment = new HashMap<>();


	//---constructor
	public Hero(String name, String character, int base_Strength, int base_Dexterity, int base_Intelligence) {
		this.name = name;
		this.character = character;
		this.base_Strength = base_Strength;
		this.base_Dexterity = base_Dexterity;
		this.base_Intelligence = base_Intelligence;

		//---total attributes initially set to base value
		//this.total_Strength = base_Strength;
		//this.total_Dexterity = base_Dexterity;
		//this.total_Intelligence = base_Intelligence;
	}

	//---setters
	public void setBaseAtt(float base_Strength, float base_Dexterity, float base_Intelligence) {
		this.base_Strength = base_Strength;
		this.base_Dexterity = base_Dexterity;
		this.base_Intelligence = base_Intelligence;
	}
	//public void setTotalAtt(float total_Strength, float total_Dexterity, float total_Intelligence) {
	//	this.total_Strength = total_Strength;
	//	this.total_Dexterity = total_Dexterity;
	//	this.total_Intelligence = total_Intelligence;
	//}
	
	public void setLevel(int level) {
		this.level= level;
	}
	
	public void setDPS(double DPS) {
		this.damage_per_second=DPS;
	}
	
	public void setWeapon(Weapon weapon) {
		equipment.put(slotType.WEAPON, weapon);
	}
	
	public void setArmorLegs(Armor armor) { equipment.put(slotType.LEGS, armor); }

	public void setArmorBody(Armor armor) {
		equipment.put(slotType.BODY, armor);
	}

	public void setArmorHead(Armor armor) {
		equipment.put(slotType.HEAD, armor);
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
	//public float getTotal_Strength() {
	//	return total_Strength;
	//}
	//public float getTotal_Dexterity() {
	//	return total_Dexterity;
	//}
	//public float getTotal_Intelligence() {
	//	return total_Intelligence;
	//}

	public double getDPS() {
		return damage_per_second;
	}
	public Weapon getWeapon() {
		return (Weapon) equipment.get(slotType.WEAPON);
	}

	public Armor getArmorHead() {
		return (Armor) equipment.get(slotType.HEAD);
	}
	public Armor getArmorBody() {
		return (Armor) equipment.get(slotType.BODY);
	}
	public Armor getArmorLegs() {
		return (Armor) equipment.get(slotType.LEGS);
	}

	public float getTotalstrengthWithArmor() {
		//---get base values
		float base_str = this.base_Strength;

		//---set initial armor attributes to zero
		int head_str = 0;
		int body_str = 0;
		int legs_str = 0;

		//---change initial atributes with armor attributes
		if (equipment.get(slotType.HEAD) != null) {
			head_str = ((Armor) equipment.get(slotType.HEAD)).getStrength();
		}
		if (equipment.get(slotType.BODY) != null) {
			body_str = ((Armor) equipment.get(slotType.BODY)).getStrength();
		}
		if (equipment.get(slotType.LEGS) != null) {
			legs_str = ((Armor) equipment.get(slotType.LEGS)).getStrength();
		}

		//---add all attributes together and set in hero
		float total_str = base_str + head_str + body_str + legs_str;

		return total_str;
	}

	public float getTotalDexWithArmor() {
		//---get base values
		float base_dex = this.base_Dexterity;

		//---set initial armor attributes to zero
		int head_dex = 0;
		int body_dex = 0;
		int legs_dex = 0;

		//---change initial atributes with armor attributes
		if (equipment.get(slotType.HEAD) != null) {
			head_dex = ((Armor) equipment.get(slotType.HEAD)).getDexterity();
		}
		if (equipment.get(slotType.BODY) != null) {
			body_dex = ((Armor) equipment.get(slotType.BODY)).getDexterity();
		}
		if (equipment.get(slotType.LEGS) != null) {
			legs_dex = ((Armor) equipment.get(slotType.LEGS)).getDexterity();
		}

		//---add all attributes together and set in hero
		float total_dex = base_dex + head_dex + body_dex + legs_dex;

		return total_dex;
	}

	public float getTotalIntWithArmor() {
		//---get base values
		float base_int = this.base_Intelligence;

		//---set initial armor attributes to zero
		int head_int = 0;
		int body_int = 0;
		int legs_int = 0;

		//---change initial atributes with armor attributes
		if (equipment.get(slotType.HEAD) != null) {
			head_int = ((Armor) equipment.get(slotType.HEAD)).getIntelligence();
		}
		if (equipment.get(slotType.BODY) != null) {
			body_int = ((Armor) equipment.get(slotType.BODY)).getIntelligence();
		}
		if (equipment.get(slotType.LEGS) != null) {
			legs_int = ((Armor) equipment.get(slotType.LEGS)).getIntelligence();
		}

		//---add all attributes together and set in hero
		float total_int = base_int + head_int + body_int + legs_int;

		return total_int;
	}
}	
	
