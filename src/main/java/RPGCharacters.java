import InvalidException.InvalidArmorException;
import InvalidException.InvalidWeaponException;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class RPGCharacters {

	
	String[] choice; 
	Hero player;
	int charDPS;
	ArrayList<Weapon> weaponslist = new ArrayList<Weapon>();
	ArrayList<Armor> armorlist = new ArrayList<Armor>();
	
	public static void main(String[] args) {
		
		RPGCharacters main = new RPGCharacters();
		main.MakeWeapons();
		main.MakeArmor();
		main.Go();
		
	}
	//---Make weapon objects and store in weapons list
	//---Constructor parameters: 
	//---weapon name, required lvl to equip, damage, attacks per second, characters that can equip
	public void MakeWeapons() {
		//---axes
		Weapon StoneAxe = new Weapon("stone axe", 1, 2, 1.5, new String[] {"warrior","",""});
		weaponslist.add(StoneAxe);
		Weapon BronzeAxe = new Weapon("bronze axe", 2, 4, 2, new String[] {"warrior","",""});
		weaponslist.add(BronzeAxe);
		Weapon SteelAxe = new Weapon("steel axe", 3, 6, 2.5, new String[] {"warrior","",""});
		weaponslist.add(SteelAxe);
		//---hammers
		Weapon StoneHammer = new Weapon("stone hammer", 1, 3, 1.5, new String[] {"warrior","",""});
		weaponslist.add(StoneHammer);
		Weapon BronzeHammer = new Weapon("bronze hammer", 2, 5, 2, new String[] {"warrior","",""});
		weaponslist.add(BronzeHammer);
		Weapon SteelHammer = new Weapon("steel hammer", 3, 7, 2.5, new String[] {"warrior","",""});
		weaponslist.add(SteelHammer);
		//---swords
		Weapon WoodenSword = new Weapon("wooden sword", 1, 2.5, 1.5, new String[]{"warrior","rogue",""});
		weaponslist.add(WoodenSword);
		Weapon BronzeSword = new Weapon("bronze sword", 2, 4.5, 2, new String[]{"warrior","rogue",""});
		weaponslist.add(BronzeSword);
		Weapon SteelSword = new Weapon("steel sword", 3, 6.5, 2.5, new String[]{"warrior","rogue",""});
		weaponslist.add(SteelSword);
		//---daggers
		Weapon WoodenDagger = new Weapon("wooden dagger", 1, 2, 1.5, new String[] {"rogue","",""});
		weaponslist.add(WoodenDagger);
		Weapon BronzeDagger = new Weapon("bronze dagger", 2, 4, 2, new String[] {"rogue","",""});
		weaponslist.add(BronzeDagger);
		Weapon SteelDagger = new Weapon("steel dagger", 3, 6, 2.5, new String[] {"Rogue","",""});
		weaponslist.add(SteelDagger);
		//---bows
		Weapon WoodenBow = new Weapon("wooden bow", 1, 3, 1.5, new String[] {"ranger","",""});
		weaponslist.add(WoodenBow);
		Weapon CompoundBow = new Weapon("compound bow", 2, 5, 2, new String[] {"ranger","",""});
		weaponslist.add(CompoundBow);
		Weapon LongBow = new Weapon("long bow", 3, 7, 2.5, new String[] {"ranger","",""});
		weaponslist.add(LongBow);
		//---staffs
		Weapon WoodenStaff = new Weapon("wooden staff", 1, 4, 1.5, new String[] {"mage","",""});
		weaponslist.add(WoodenStaff);
		Weapon ObsidianStaff = new Weapon("obsidian staff", 2, 5, 2, new String[] {"mage","",""});
		weaponslist.add(ObsidianStaff);
		Weapon FireStaff = new Weapon("fire staff", 3, 8, 2.5, new String[] {"mage","",""});
		weaponslist.add(FireStaff);
		//---wands
		Weapon WoodenWand = new Weapon("wooden wand", 1, 3, 1.5, new String[] {"mage","",""});
		weaponslist.add(WoodenWand);
		Weapon ObsidianWand = new Weapon("obsidian wand", 2, 4, 2, new String[] {"mage","",""});
		weaponslist.add(ObsidianWand);
		Weapon FireWand = new Weapon("fire wand", 3, 6, 2.5, new String[] {"mage","",""});
		weaponslist.add(FireWand);
	}

	//---Make armor objects and store in armor list
	//---Constructor parameters
	//---Parameters: armor name, required lvl to equip, strength gain, dexterity gain, intelligence gain, characters that can equip
	public void MakeArmor() {
		//---plate
		Armor BronzePlate = new Armor("bronze plate", 1,3,1,1, new String[]{"warrior","",""});
		armorlist.add(BronzePlate);
		Armor SteelPlate = new Armor("steel plate", 2,4,1,1, new String[]{"warrior","",""});
		armorlist.add(SteelPlate);
		//---mail
		Armor BronzeMail = new Armor("bronze mail", 1,2,2,1, new String[]{"warrior","rogue","ranger"});
		armorlist.add(BronzeMail);
		Armor SteelMail = new Armor("steel mail", 2,3,3,1, new String[]{"warrior","rogue","ranger"});
		armorlist.add(SteelMail);
		//--leather
		Armor Leather = new Armor("leather", 1,1,2,1, new String[]{"rogue","ranger",""});
		armorlist.add(Leather);
		Armor HardLeather = new Armor("hard leather", 2,2,3,1, new String[]{"rogue","ranger",""});
		armorlist.add(HardLeather);
		//---cloth
		Armor cloth = new Armor("cloth", 1,1,1,3, new String[]{"mage","",""});
		armorlist.add(cloth);
		Armor LongCloth = new Armor("long cloth", 2,1,1,4, new String[]{"mage","",""});
		armorlist.add(LongCloth);
	}
	
	//---Where the game loops
	public void Go() {
		
		while(true) {
		
		//---Prompt user for input, and split the input at ",",
		//---use the word at first index to initiate further functionality
		//---Enter -> start,your_name,your_class
		commandinput();
		
		//---it user types exit then exit while loop
		if (choice[0].trim().toLowerCase().equals("exit")) {
			System.out.println("Thank you for playing, goodbye.");
			break;
		}
		
		//---Building the hero
		//---third word decides which hero to build
		if(choice[0].trim().toLowerCase().equals("start")) {
			buildHero(choice[1].toLowerCase().trim(),choice[2].toLowerCase().trim());
		}
		
		if (player != null) {
		
		//---level up hero
		//---adds to main attributes
		//---Four different level up scenarios, one for each class
		//---Enter -> level up
		if (choice[0].trim().toLowerCase().equals("level up")){
			levelUp();
		}
		
		//---Display available weapons
		//---Enter -> display weapons
		if (choice[0].trim().toLowerCase().equals("display weapons")) {
			weaponsDisplay();
		}
		
		//---Equip weapons
		//---Enter -> equip weapon,weapon name
		if (choice[0].trim().toLowerCase().equals("equip weapon")) {
			try {
				equipWeapon(choice[1].trim().toLowerCase());
				System.out.println("Hero equiped with "+player.getWeapon().getName());
			} catch (InvalidWeaponException e) {
				e.printStackTrace();
			}
		}
		
		//---Display available armor 
		//---Enter -> display armor
		if(choice[0].trim().toLowerCase().equals("display armor")) {
			armorDisplay();
		}
		
		//---Equip armor
		//---armor can only be equiped at "Head", "Body" or "Legs"
		//---Enter equip armor,armor name,slot
		if (choice[0].trim().toLowerCase().equals("equip armor") && (choice[2].trim().toLowerCase().equals("head") || choice[2].trim().toLowerCase().equals("body") || choice[2].trim().toLowerCase().equals("legs"))) {
			try {
				//---armor is equiped
				equipArmor(choice[1].trim().toLowerCase(),choice[2].trim().toLowerCase());
				System.out.println("Hero "+choice[2].trim().toLowerCase()+" equiped with "+player.getArmorName(choice[2].trim().toLowerCase()));
			} catch (InvalidArmorException e) {
				e.printStackTrace();
			}
			//---primary attributes are update by armor
			updateStatsWithArmor();
		
		//---If correct slot name not typed, user is prompted
		}else if (choice[0].trim().toLowerCase().equals("equip armor") && (!choice[2].trim().toLowerCase().equals("head") || !choice[2].trim().toLowerCase().equals("body") || !choice[2].trim().toLowerCase().equals("legs")) ) {
			System.out.println("You can only equip armor on Head, Body or Legs !");
		}
		
		//---damage per second calculated if there are no weapons equipped
		if (player.getWeapon()== null) {
			damagePerSecondNoWeapon();
		//---damage per second calculated if weapons are equipped
		}else if(player.getWeapon()!= null) {
			updateStatsWithWeapon();
		}
		
		//---automatically display status at the end of each command
		statsDisplay();
		
		//---Display status of the player
		//---Enter -> status
		if (choice[0].trim().toLowerCase().equals("status")) {
			statsDisplay();
		}
		
		//---if no hero is created prompt user
		}else {
			System.out.println("To start choose your class: Warrior, Rogue, Ranger or Mage");
		}
		
		//---return to ask for input
		continue;
		}
	}
	//---Methods called in go()
	
	//---build hero
	public void buildHero(String name, String hero) {
	
			if(hero.equals("warrior")) {
				player = new Hero(name, hero, 5, 2, 1);
				System.out.println("Welcome "+name+" the "+hero);
			}	
			else if(hero.equals("rogue")) {
				player = new Hero(name, hero, 2, 6, 1);
				System.out.println("Welcome "+name+" the "+hero);
			}
			else if(hero.equals("ranger")) {
				player = new Hero(name, hero, 1, 7, 1);
				System.out.println("Welcome "+name+" the "+hero);
			}
			else if(hero.equals("mage")) {
				player = new Hero(name, hero, 1, 1, 8);
				System.out.println("Welcome "+name+" the "+hero);
			}
	}
	
	//---level up 
	//---for warrior
	public void levelUp() {
			if (player.getChar().equals("warrior")) {
				
				int new_level = player.getLevel() + 1;
				player.setLevel(new_level);
				
				float new_strength = player.getBase_Strength() + 3;
				float new_Dexterity = player.getBase_Dexterity() + 2;
				float new_Intelligence = player.getBase_Intelligence() + 1;
				player.setBaseAtt(new_strength, new_Dexterity, new_Intelligence);
				updateStatsWithArmor(); 
			}
			//---for rogue
			if (player.getChar().equals("rogue")) {
				
				int new_level = player.getLevel() + 1;
				player.setLevel(new_level);
				
				float new_strength = player.getBase_Strength() + 1;
				float new_Dexterity = player.getBase_Dexterity() + 4;
				float new_Intelligence = player.getBase_Intelligence() + 1;
				player.setBaseAtt(new_strength, new_Dexterity, new_Intelligence);
				updateStatsWithArmor(); 
			}
			//---for ranger
			if (player.getChar().equals("ranger")) {
				
				int new_level = player.getLevel() + 1;
				player.setLevel(new_level);
				
				float new_strength = player.getBase_Strength() + 1;
				float new_Dexterity = player.getBase_Dexterity() + 5;
				float new_Intelligence = player.getBase_Intelligence() + 1;
				player.setBaseAtt(new_strength, new_Dexterity, new_Intelligence);
				updateStatsWithArmor(); 
			}
			
			//---for mage
			if (player.getChar().equals("mage")) {
				
				int new_level = player.getLevel() + 1;
				player.setLevel(new_level);
				
				float new_strength = player.getBase_Strength() + 1;
				float new_Dexterity = player.getBase_Dexterity() + 1;
				float new_Intelligence = player.getBase_Intelligence() + 5;
				player.setBaseAtt(new_strength, new_Dexterity, new_Intelligence);
				updateStatsWithArmor(); 
			}
	}
	
	//---equip armor if player class is valid and player level is valid
	public boolean equipArmor(String choice, String slot) throws InvalidArmorException {
		for(Armor item : armorlist) {
			if (item.getName().equals(choice)) {
				if (!item.getChar().get(0).equals(player.getChar()) 
					&& !item.getChar().get(1).equals(player.getChar()) 
					&& !item.getChar().get(2).equals(player.getChar())) {
					
						//---throw exception if armor not applicable to class
						throw new InvalidArmorException("This armor is not available to your class!");
						
				}else if(item.getRequired_level()>player.getLevel()) {
					
						//---throw exception if armor not applicable to level
						throw new InvalidArmorException("You dont have sufficient level to equip armor!");
				}
				else {
					//---otherwise equip armor at desired slot
					player.setArmor(item, slot);
					return true;
				}
			}
		}
		return false;
	}
	
	//---equip level if player class is valid and player level is valid
	public boolean equipWeapon(String choice) throws InvalidWeaponException {
		for(Weapon item : weaponslist) {
			if (item.getName().equals(choice)) {
					if (!item.getChar().get(0).equals(player.getChar()) && !item.getChar().get(1).equals(player.getChar())) {
						
						//---throw exception if weapon not applicable to class
						throw new InvalidWeaponException("This weapon is not available to your class!");
					}
					else if (item.getRequired_level()>player.getLevel()) {
						
						//---throw exception if weapon not applicable to level
						throw new InvalidWeaponException("You dont have sufficient level to equip weapon!");
					}
					else {
						//---otherwise equip weapon 
						player.setWeapon(item);
						return true;
					}
			}
	}
		return false;
	
	}
	
	//---update total attributes once armor is equipped
	public void updateStatsWithArmor() {
		
		//---get base values
		float base_str = player.getBase_Strength(); 
		float base_dex = player.getBase_Dexterity(); 
		float base_int = player.getBase_Intelligence();
		
		//---set initial armor attributes to zero
		int head_str = 0; 
		int head_dex = 0; 
		int head_int = 0;
		
		int body_str = 0; 
		int body_dex = 0; 
		int body_int = 0;
		
		int legs_str = 0; 
		int legs_dex = 0; 
		int legs_int = 0;
		
		//---change initial atributes with armor attributes
		if(player.getArmor("head")!=null) {
			head_str = player.getArmor("head").getStrength();
			head_dex = player.getArmor("head").getDexterity();
			head_int = player.getArmor("head").getIntelligence();
		}
		if(player.getArmor("body")!=null) {
			body_str = player.getArmor("body").getStrength();
			body_dex = player.getArmor("body").getDexterity();
			body_int = player.getArmor("body").getIntelligence();
		}
		if(player.getArmor("legs")!=null) {
			legs_str = player.getArmor("legs").getStrength();
			legs_dex = player.getArmor("legs").getDexterity();
			legs_int = player.getArmor("legs").getIntelligence();
		}
		
		//---add all attributes together and set in hero
		float new_str = base_str + head_str + body_str + legs_str;
		float new_dex = base_dex + head_dex + body_dex + legs_dex;
		float new_int = base_int + head_int + body_int + legs_int;
		player.setTotalAtt(new_str, new_dex, new_int);	
		
	}
	
	//---update damage per second(DPS) when weapon is equipped
	public void updateStatsWithWeapon() {
		
		double weaponAttackPerSec = (double) player.getWeapon().getAttacks_per_second();
		double weaponDmg = (double) player.getWeapon().getDamage();
		double weaponDmgPerSec = weaponDmg * weaponAttackPerSec;
		
		//---update DPS when armor is contributing
		if (player.getArmor("head")!=null||player.getArmor("body")!=null || player.getArmor("legs")!=null) {
			
			if (player.getChar().equals("warrior")) {
				double CharDPS = weaponDmgPerSec*(1+(player.getTotal_Strength()/100));
				player.setDPS(CharDPS);
			}
			else if (player.getChar().equals("rogue")) {
				double CharDPS = weaponDmgPerSec*(1+(player.getTotal_Dexterity()/100));
				player.setDPS(CharDPS);
			}
			else if (player.getChar().equals("ranger")) {
				double CharDPS = weaponDmgPerSec*(1+(player.getTotal_Dexterity()/100));
				player.setDPS(CharDPS);
			}
			else if (player.getChar().equals("mage")) {
				double CharDPS = weaponDmgPerSec*(1+(player.getTotal_Intelligence()/100));
				player.setDPS(CharDPS);
			}
		
		//---update DPS when NO armor is contributing
		}else if (player.getArmor("head")==null && player.getArmor("body")==null && player.getArmor("legs")==null) {
			
			if (player.getChar().equals("warrior")) {
				double CharDPS = weaponDmgPerSec*(1+(player.getBase_Strength()/100));
				player.setDPS(CharDPS);
			}
			else if (player.getChar().equals("rogue")) {
				double CharDPS = weaponDmgPerSec*(1+(player.getBase_Dexterity()/100));
				player.setDPS(CharDPS);
			}
			else if (player.getChar().equals("ranger")) {
				double CharDPS = weaponDmgPerSec*(1+(player.getBase_Dexterity()/100));
				player.setDPS(CharDPS);
			}
			else if (player.getChar().equals("mage")) {
				double CharDPS = weaponDmgPerSec*(1+(player.getBase_Intelligence()/100));
				player.setDPS(CharDPS);
			}
		}
		
	}
	
	//---prompts user for input and splits input at ","
	private void commandinput() {
		System.out.println("Enter your command : ");
		Scanner input = new Scanner(System.in); 
		String Cstring = input.nextLine();
		choice = Cstring.split(",");
	}
	
	//---Display stats
	private void statsDisplay() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		//---display when armor is equipped
		if (player.getArmor("head")!=null||player.getArmor("body")!=null || player.getArmor("legs")!=null) {
			StringBuilder stats = new StringBuilder();
			stats.append("----------------------- \n");
			stats.append("Hero stats \n");
			stats.append("---------- \n");
			stats.append("Name : "+player.getName().toUpperCase()+"\n");
			stats.append("Type : "+player.getChar().toLowerCase()+"\n");
			stats.append("Level : "+player.getLevel()+"\n");
			stats.append("Strength :"+player.getTotal_Strength()+"\n");
			stats.append("Dexterity :"+player.getTotal_Dexterity()+"\n");
			stats.append("Intelligence :"+player.getTotal_Intelligence()+"\n");
			stats.append("Damage per second :"+df.format(player.getDPS())+"\n");
			stats.append("----------------------- \n");
			System.out.println(stats);
		
		//---display when NO armor is equipped
		}else if (player.getArmor("head")==null && player.getArmor("body")==null && player.getArmor("legs")==null) {
			StringBuilder stats = new StringBuilder();
			stats.append("----------------------- \n");
			stats.append("Hero stats \n");
			stats.append("---------- \n");
			stats.append("Name : "+player.getName().toUpperCase()+"\n");
			stats.append("Type : "+player.getChar().toUpperCase()+"\n");
			stats.append("Level : "+player.getLevel()+"\n");
			stats.append("Strength :"+player.getBase_Strength()+"\n");
			stats.append("Dexterity :"+player.getBase_Dexterity()+"\n");
			stats.append("Intelligence :"+player.getBase_Intelligence()+"\n");
			stats.append("Damage per second :"+df.format(player.getDPS())+"\n");
			stats.append("----------------------- \n");
			System.out.println(stats);
		}
		
	}
	
	//---calculate damage per second, when no weapon is equipped
	public void damagePerSecondNoWeapon() {
		if (player.getChar().equals("warrior")) {
			double CharDPS = 1*(1+(player.getTotal_Strength()/100));
			player.setDPS(CharDPS);
		}
		else if (player.getChar().equals("rogue")) {
			double CharDPS = 1*(1+(player.getTotal_Dexterity()/100));
			player.setDPS(CharDPS);
		}
		else if (player.getChar().equals("ranger")) {
			double CharDPS = 1*(1+(player.getTotal_Dexterity()/100));
			player.setDPS(CharDPS);
		}
		else if (player.getChar().equals("mage")) {
			double CharDPS = 1*(1+(player.getTotal_Intelligence()/100));
			player.setDPS(CharDPS);
		}	
	}
	//---lists all armor available with respective values
	private void armorDisplay() {
		StringBuilder armor = new StringBuilder();
		armor.append("----------------------- \n");
		armor.append("name; lvl-required; slot; strength; dexterity; intelligence, class \n");
		armor.append("--------plate---------\n");
		armor.append("Bronze plate; 1; (Head, Body, Legs); 3; 1; 1; (Warrior) \n");
		armor.append("Steel plate; 2; (Head, Body, Legs); 4; 1; 1; (Warrior) \n");
		armor.append("--------mail---------\n");
		armor.append("Bronze mail; 1; (Head, Body, Legs); 2; 2; 1; (Warrior,Rogue,Ranger) \n");
		armor.append("Steel mail; 2; (Head, Body, Legs); 3; 3; 1; (Warrior,Rogue,Ranger) \n");
		armor.append("--------leather---------\n");
		armor.append("Leather; 1; (Head, Body, Legs); 1; 2; 1; (Rogue,Ranger) \n");
		armor.append("Hard leather; 2; (Head, Body, Legs); 2; 3; 1; (Rogue,Ranger) \n");
		armor.append("--------cloth---------\n");
		armor.append("Cloth; 1; (Head, Body, Legs); 1; 1; 3; (Mage) \n");
		armor.append("Long cloth; 2; (Head, Body, Legs); 1; 1; 4; (Mage) \n");
		System.out.println(armor);
	}
	
	//---lists all weapons available with respective values
	private void weaponsDisplay() {
		StringBuilder weapons = new StringBuilder();
		weapons.append("----------------------- \n");
		weapons.append("name; lvl-required; damage; attacks/second; class \n");
		weapons.append("--------axes---------\n");
		weapons.append("Stone axe; 1; 2; 1.5; (Warriors) \n");
		weapons.append("Bronze axe; 2; 4; 2; (Warriors \n");
		weapons.append("Steel axe; 3; 6; 2.5; (Warriors) \n");
		weapons.append("--------hammers---------\n");
		weapons.append("Stone hammer; 1; 3; 1.5; (Warriors) \n");
		weapons.append("Bronze hammer; 2; 5; 2; (Warriors) \n");
		weapons.append("Steel hammer; 3; 7; 2.5; (Warriors) \n");
		weapons.append("--------swords---------\n");
		weapons.append("Wooden sword; 1; 2.5; 1.5; (Warriors, Rogues) \n");
		weapons.append("Bronze sword; 2; 4.5; 2; (Warriors, Rogues) \n");
		weapons.append("Steel sword; 3; 6.5; 2.5; (Warriors, Rogues) \n");
		weapons.append("--------daggers---------\n");
		weapons.append("Wooden dagger; 1; 2; 1.5; (Rogues) \n");
		weapons.append("Bronze dagger; 2; 4; 2; (Rogues) \n");
		weapons.append("Steel dagger; 3; 6; 2.5; (Rogues) \n");
		weapons.append("--------bows---------\n");
		weapons.append("Wooden bow; 1; 3; 1.5; (Rangers) \n");
		weapons.append("Compound bow; 2; 5; 2; (Rangers) \n");
		weapons.append("Long bow; 3; 7; 2.5; (Rangers) \n");
		weapons.append("--------staffs---------\n");
		weapons.append("Wooden staff; 1; 4; 1.5; (Mages) \n");
		weapons.append("Obsidian staff; 2; 5; 2; (Mages) \n");
		weapons.append("Fire staff; 3; 8; 2.5; (Mages) \n");
		weapons.append("--------wands---------\n");
		weapons.append("Wooden wand; 1; 3; 1.5; (Mages) \n");
		weapons.append("Obsidian wand; 2; 4; 2; (Mages) \n");
		weapons.append("Fire wand; 3; 6; 2.5; (Mages) \n");
		System.out.println(weapons);
	}
}
