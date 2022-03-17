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

	}

	//---level up
	public void levelUp() {

		//---for warrior
		if (this.character.equals("warrior")) {

			this.level = this.level + 1;
			this.base_Strength = this.base_Strength + 3;
			this.base_Dexterity = this.base_Dexterity + 2;
			this.base_Intelligence = this.base_Intelligence + 1;
		}

		//---for rogue
		if (this.character.equals("rogue")) {

			this.level = this.level + 1;
			this.base_Strength = this.base_Strength + 1;
			this.base_Dexterity = this.base_Dexterity + 4;
			this.base_Intelligence = this.base_Intelligence + 1;
		}
		//---for ranger

		if (this.character.equals("ranger")) {

			this.level = this.level + 1;
			this.base_Strength = this.base_Strength + 1;
			this.base_Dexterity = this.base_Dexterity + 5;
			this.base_Intelligence = this.base_Intelligence + 1;
		}

		//---for mage
		if (this.character.equals("mage")) {

			this.level = this.level + 1;
			this.base_Strength = this.base_Strength + 1;
			this.base_Dexterity = this.base_Dexterity + 1;
			this.base_Intelligence = this.base_Intelligence + 5;
		}
	}

	//---setters
	public void setBaseAtt(float base_Strength, float base_Dexterity, float base_Intelligence) {
		this.base_Strength = base_Strength;
		this.base_Dexterity = base_Dexterity;
		this.base_Intelligence = base_Intelligence;
	}

	
	public void setLevel(int level) {
		this.level= level;
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

	public double getDmgPerSecond(){
		double CharDPS = 0;

		//---when no weapon is equipped
		if(equipment.get(slotType.WEAPON)==null) {
			if (this.character.equals("warrior")) {
				CharDPS = 1 * (1 + (this.getTotalstrengthWithArmor() / 100));
			} else if (this.character.equals("rogue")) {
				CharDPS = 1 * (1 + (this.getTotalDexWithArmor() / 100));
			} else if (this.character.equals("ranger")) {
				CharDPS = 1 * (1 + (this.getTotalDexWithArmor() / 100));
			} else if (this.character.equals("mage")) {
				CharDPS = 1 * (1 + (this.getTotalIntWithArmor() / 100));
			}
			//---when weapon is equipped
		}else if(equipment.get(slotType.WEAPON)!=null){

			double weaponAttackPerSec = ((Weapon) equipment.get(slotType.WEAPON)).getAttacks_per_second();
			double weaponDmg = ((Weapon) equipment.get(slotType.WEAPON)).getDamage();
			double weaponDmgPerSec = weaponDmg * weaponAttackPerSec;

			//---update DPS when armor is contributing
			if (equipment.get(slotType.HEAD)!=null||equipment.get(slotType.BODY)!=null ||equipment.get(slotType.LEGS)!=null) {

				if (this.character.equals("warrior")) {
					CharDPS = weaponDmgPerSec*(1+(this.getTotalstrengthWithArmor()/100));
				}
				else if (this.character.equals("rogue")) {
					CharDPS = weaponDmgPerSec*(1+(this.getTotalDexWithArmor()/100));
				}
				else if (this.character.equals("ranger")) {
					CharDPS = weaponDmgPerSec*(1+(this.getTotalDexWithArmor()/100));
				}
				else if (this.character.equals("mage")) {
					CharDPS = weaponDmgPerSec*(1+(this.getTotalIntWithArmor()/100));
				}

				//---update DPS when NO armor is contributing
			}else if (equipment.get(slotType.HEAD)==null && equipment.get(slotType.BODY)==null && equipment.get(slotType.LEGS)==null) {

				if (this.character.equals("warrior")) {
					CharDPS = weaponDmgPerSec*(1+(this.getBase_Strength()/100));
				}
				else if (this.character.equals("rogue")) {
					CharDPS = weaponDmgPerSec*(1+(this.getBase_Dexterity()/100));
				}
				else if (this.character.equals("ranger")) {
					CharDPS = weaponDmgPerSec*(1+(this.getBase_Dexterity()/100));
				}
				else if (this.character.equals("mage")) {
					CharDPS = weaponDmgPerSec*(1+(this.getBase_Intelligence()/100));
				}
			}
			}
		return CharDPS;
	}
}	
	
