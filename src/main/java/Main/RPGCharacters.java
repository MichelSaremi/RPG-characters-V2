package Main;

import BuildObjects.BuildHero;
import BuildObjects.Hero;
import Displays.DisplayArmor;
import Displays.DisplayStats;
import Displays.DisplayWeapons;
import EquipItems.EquipArmor;
import EquipItems.EquipWeapon;
import InvalidExceptions.InvalidArmorException;
import InvalidExceptions.InvalidWeaponException;
import java.util.Scanner;

public class RPGCharacters {


	String[] choice;
	public Hero player;
	BuildHero bh = new BuildHero();
	DisplayWeapons dw = new DisplayWeapons();
	EquipWeapon ew = new EquipWeapon();
	DisplayArmor da = new DisplayArmor();
	EquipArmor ea = new EquipArmor();
	DisplayStats ds = new DisplayStats();

	public static void main(String[] args) {

		RPGCharacters rpg = new RPGCharacters();
		rpg.Go();

	}

	//---Where the game loops
	public void Go() {

		while (true) {

			//---Prompt user for input, and split the input at ",",
			//---uses the word at first index to initiate further functionality
			//---Enter -> start,your_name,your_class
			commandinput();


			//---it user types exit then they exit the while loop
			if (choice[0].trim().toLowerCase().equals("exit")) {
				System.out.println("Thank you for playing, goodbye.");
				break;
			}

			//---Building the hero
			//---third word decides which hero to build
			if (choice[0].trim().toLowerCase().equals("start")) {
				player = bh.buildHero(player, choice[1].toLowerCase().trim(), choice[2].toLowerCase().trim());
			}

			if (player != null) {

				//---level up hero
				//---adds to main attributes
				//---Four different level up scenarios, one for each class
				//---Enter -> level up
				if (choice[0].trim().toLowerCase().equals("level up")) {
					player.levelUp();
					System.out.println("Hero leveled up!");
				}

				//---Display available weapons
				//---Enter -> display weapons
				if (choice[0].trim().toLowerCase().equals("display weapons")) {
					dw.weaponsDisplay();
				}

				//---Equip weapons
				//---Enter -> equip weapon,weapon name
				if (choice[0].trim().toLowerCase().equals("equip weapon")) {
					try {
						ew.equipWeapon(player, choice[1].trim().toLowerCase());
					} catch (InvalidWeaponException e) {
						e.printStackTrace();
					}
				}

				//---Display available armor
				//---Enter -> display armor
				if (choice[0].trim().toLowerCase().equals("display armor")) {
					da.armorDisplay();
				}

				//---Equip armor
				//---armor can only be equipped at "Head", "Body" or "Legs"
				//---Enter equip armor,armor name,slot

				//---If input is incorrect
				if (choice[0].trim().toLowerCase().equals("equip armor") && (choice.length!=3)) {
					System.out.println("Please follow instructions in Readme for equipping armor!");

				}else if (choice[0].trim().toLowerCase().equals("equip armor") && (choice.length==3)) {
					try {
						//---Attempt to equip armor
						ea.equipArmor(player, choice[1].trim().toLowerCase(), choice[2].trim().toLowerCase());
					} catch (InvalidArmorException e) {
						e.printStackTrace();
					}
				}

				//---automatically display status at the end of each command
				ds.statsDisplay(player);

				//---Display status of the player
				//---Enter -> status
				if (choice[0].trim().toLowerCase().equals("status")) {
					ds.statsDisplay(player);
				}

				//---if no hero is created prompt user
			} else {
				System.out.println("To start, follow instructions in Readme and choose your class: Warrior, Rogue, Ranger or Mage");
			}

			//---return to ask for input
			continue;
		}
	}


	//---prompts user for input and splits input at ","
	private void commandinput() {
		System.out.println("Enter your command : ");
		Scanner input = new Scanner(System.in);
		String Cstring = input.nextLine();
		choice = Cstring.split(",");
	}
}
