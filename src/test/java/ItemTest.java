import InvalidException.InvalidArmorException;
import InvalidException.InvalidWeaponException;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {
	

	//---Equipping a high level weapon (lvl 2) for warrior (lvl 1)
	
	@Test
	public void equipWeapon_LvlToHigh_InvalidWeaponExceptionWithProperMessage() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		app.MakeWeapons();
		String choice = "Bronze axe";
		String expected = "You dont have sufficient level to equip weapon!";
		//---act
		Exception exception = assertThrows(InvalidWeaponException.class, ()-> app.equipWeapon(choice));
		String actual = exception.getMessage();
		//---assert
		assertEquals(expected,actual);
	}
	
	//---Equipping a high level (lvl 2) armor for warrior (lvl 1)
	@Test
	public void equipArmor_LvlToHigh_InvalidArmorExceptionWithProperMessage() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		app.MakeArmor();
		String choice = "Steel plate";
		String slot = "Body";
		String expected = "You dont have sufficient level to equip armor!";
		//---act
		Exception exception = assertThrows(InvalidArmorException.class, ()-> app.equipArmor(choice, slot));
		String actual = exception.getMessage();
		//---assert
		assertEquals(expected,actual);
	}
	
	//---Equipping wrong weapon type, Warrior trying to equip bow
	@Test
	public void equipWeapon_WrongType_InvalidWeaponExceptionWithProperMessage() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		app.MakeWeapons();
		String choice = "Wooden bow";
		String expected = "This weapon is not available to your class!";
		//---act
		Exception exception = assertThrows(InvalidWeaponException.class, ()-> app.equipWeapon(choice));
		String actual = exception.getMessage();
		//---assert
		assertEquals(expected,actual);
	}
	
	//---Equipping wrong armor type, Warrior trying to equip cloth armor
	@Test
	public void equipArmor_WrongType_InvalidArmorExceptionWithProperMessage() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		app.MakeArmor();
		String choice = "Cloth";
		String slot = "Body";
		String expected = "This armor is not available to your class!";
		//---act
		Exception exception = assertThrows(InvalidArmorException.class, ()-> app.equipArmor(choice, slot));
		String actual = exception.getMessage();
		//---assert
		assertEquals(expected,actual);
	}
		
	//---Equipping a correct weapon
	@Test
	public void equipWeapon_rightType_BooleanTrueReturned() throws InvalidWeaponException {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		app.MakeWeapons();
		String choice = "Wooden sword";
		Boolean expected = true;
		//---act
		Boolean actual = app.equipWeapon(choice);
		//---assert
		AssertJUnit.assertEquals(expected,actual);
	}
		
	//---Equipping right armor type
	@Test
	public void equipArmor_rightType_BooleanTrueReturned() throws InvalidArmorException {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		app.MakeArmor();
		String choice = "Bronze plate";
		String slot = "Body";
		boolean expected = true;
		//---act
		boolean actual = app.equipArmor(choice, slot);
		//---assert
		assertEquals(expected,actual);
	}
	
	//---Attributes gained by armor
	@Test
	public void gainAttByArmor_equipArmor_TotalAttributesIncrease() throws InvalidArmorException{
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		app.MakeArmor();
		String choice = "Bronze plate"; //---adds str. 3, dex. 1, int. 1
		String slot = "Body";
		app.equipArmor(choice, slot);
		double expected_str = 8;
		double expected_dex = 3;
		double expected_int = 2;
		//---act
		app.updateStatsWithArmor();
		double actual_str = app.player.getTotal_Strength();
		double actual_dex = app.player.getTotal_Dexterity();
		double actual_int = app.player.getTotal_Intelligence();
		//---assert
		AssertJUnit.assertEquals(expected_str,actual_str);
		AssertJUnit.assertEquals(expected_dex,actual_dex);
		AssertJUnit.assertEquals(expected_int,actual_int);
	}
		
	//---Calculate DPS when no weapon is equipped
	@Test
	public void damagePerSecond_NoWeapons_damagePerSecondNoWeaponsReturned() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		int expected = 1*(1 + (5 / 100));
		//---act
		app.damagePerSecondNoWeapon();
		int actual = (int) app.player.getDPS();
		//---assert
		AssertJUnit.assertEquals(expected,actual);
	}
		
	//---Calculate DSP with valid weapon equipped
	@Test
	public void damagePerSecond_withWeapon_damagePerSecondWithWeaponReturned() throws InvalidWeaponException {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.MakeWeapons();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		String choice = "Wooden sword";
		app.equipWeapon(choice);
		int expected = (int) ((2.5*1.5)*(1 + (5 / 100)));
		//---act
		app.updateStatsWithWeapon();
		int actual = (int) app.player.getDPS();
		//---assert
		AssertJUnit.assertEquals(expected,actual);
	}
	
		
	//---Calculate DSP with valid weapon and armor equipped
	@Test
	public void damagePerSecond_withWeaponAndArmor_damagePerSecondWithWeaponAndArmorReturned() throws InvalidWeaponException, InvalidArmorException {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		app.MakeWeapons();
		app.MakeArmor();
		app.player = new Hero("Michel", "Warrior", 5, 2, 1);
		String choiceWeapon = "Wooden sword"; //---damage:2.5, attacks_per_second:1.5
		String choiceArmor = "Bronze plate"; //---3 strength added
		app.equipArmor(choiceArmor, "Body");
		app.updateStatsWithArmor();
		app.equipWeapon(choiceWeapon);
		app.updateStatsWithWeapon();
		int expected = (int) ((2.5*1.5)*(1.0+((5.0+3.0)/100.0)));
		//---act
		int actual = (int) app.player.getDPS();
		//---assert
		AssertJUnit.assertEquals(expected,actual);
	}
		
}