import BuildObjects.Hero;
import EquipItems.EquipArmor;
import EquipItems.EquipWeapon;
import InvalidExceptions.InvalidArmorException;
import InvalidExceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemTest {

	//---Equipping a high level weapon (lvl 2) for warrior (lvl 1)
	@Test
	public void equipWeapon_LvlToHigh_InvalidWeaponExceptionWithProperMessage() {
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
        EquipWeapon ew = new EquipWeapon();
		String choice = "bronze axe";
		String expected = "You dont have sufficient level to equip weapon!";
		//---act
		Exception exception = assertThrows(InvalidWeaponException.class, ()-> ew.equipWeapon(player, choice));
		String actual = exception.getMessage();
		//---assert
		assertEquals(expected,actual);
	}

	//---Equipping a high level (lvl 2) armor for warrior (lvl 1)
	@Test
	public void equipArmor_LvlToHigh_InvalidArmorExceptionWithProperMessage() {
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
        EquipArmor ea = new EquipArmor();
		String choice = "steel plate";
		String slot = "body";
		String expected = "You dont have sufficient level to equip armor!";
		//---act
		Exception exception = assertThrows(InvalidArmorException.class, ()-> ea.equipArmor(player, choice, slot));
		String actual = exception.getMessage();
		//---assert
		assertEquals(expected,actual);
	}

	//---Equipping wrong weapon type, Warrior trying to equip bow
	@Test
	public void equipWeapon_WrongType_InvalidWeaponExceptionWithProperMessage() {
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
        EquipWeapon ew = new EquipWeapon();
		String choice = "wooden bow";
		String expected = "This weapon is not available to your class!";
		//---act
		Exception exception = assertThrows(InvalidWeaponException.class, ()-> ew.equipWeapon(player, choice));
		String actual = exception.getMessage();
		//---assert
		assertEquals(expected,actual);
	}

	//---Equipping wrong armor type, Warrior trying to equip cloth armor
	@Test
	public void equipArmor_WrongType_InvalidArmorExceptionWithProperMessage() {
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
		EquipArmor ea = new EquipArmor();
		String choice = "cloth";
		String slot = "body";
		String expected = "This armor is not available to your class!";
		//---act
		Exception exception = assertThrows(InvalidArmorException.class, ()-> ea.equipArmor(player, choice, slot));
		String actual = exception.getMessage();
		//---assert
		assertEquals(expected,actual);
	}

	//---Equipping a correct weapon
	@Test
	public void equipWeapon_rightType_BooleanTrueReturned() throws InvalidWeaponException {
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
        EquipWeapon ew = new EquipWeapon();
		String choice = "wooden sword";
		Boolean expected = true;
		//---act
		Boolean actual = ew.equipWeapon(player, choice);
		//---assert
		AssertJUnit.assertEquals(expected,actual);
	}

	//---Equipping right armor type
	@Test
	public void equipArmor_rightType_BooleanTrueReturned() throws InvalidArmorException {
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
        EquipArmor ea = new EquipArmor();
		String choice = "bronze plate";
		String slot = "body";
		boolean expected = true;
		//---act
		boolean actual = ea.equipArmor(player, choice, slot);
		//---assert
		assertEquals(expected,actual);
	}

	//---Attributes gained by armor
	@Test
	public void gainAttByArmor_equipArmor_TotalAttributesIncrease() throws InvalidArmorException{
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
        EquipArmor ea = new EquipArmor();
		String choice = "bronze plate"; //---adds str. 3, dex. 1, int. 1
		String slot = "body";
		ea.equipArmor(player, choice, slot);
		double expected_str = 8;
		double expected_dex = 3;
		double expected_int = 2;
		//---act
		double actual_str = player.getTotalstrengthWithArmor();
		double actual_dex = player.getTotalDexWithArmor();
		double actual_int = player.getTotalIntWithArmor();
		//---assert
		AssertJUnit.assertEquals(expected_str,actual_str);
		AssertJUnit.assertEquals(expected_dex,actual_dex);
		AssertJUnit.assertEquals(expected_int,actual_int);
	}
		
	//---Calculate DPS when no weapon is equipped
	@Test
	public void damagePerSecond_NoWeapons_damagePerSecondNoWeaponsReturned() {
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
		int expected = 1*(1 + (5 / 100));
		//---act
		int actual = (int) player.getDmgPerSecond();
		//---assert
		AssertJUnit.assertEquals(expected,actual);
	}

	//---Calculate DSP with valid weapon equipped
	@Test
	public void damagePerSecond_withWeapon_damagePerSecondWithWeaponReturned() throws InvalidWeaponException {
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
		EquipWeapon ew = new EquipWeapon();
		String choice = "wooden sword";
		ew.equipWeapon(player, choice);
		int expected = (int) ((2.5*1.5)*(1 + (5 / 100)));
		//---act
		int actual = (int) player.getDmgPerSecond();
		//---assert
		AssertJUnit.assertEquals(expected,actual);
	}

	//---Calculate DSP with valid weapon and armor equipped
	@Test
	public void damagePerSecond_withWeaponAndArmor_damagePerSecondWithWeaponAndArmorReturned() throws InvalidWeaponException, InvalidArmorException {
		//---arrange
		Hero player = new Hero("Michel", "warrior", 5, 2, 1);
		EquipArmor ea = new EquipArmor();
		EquipWeapon ew = new EquipWeapon();
		String choiceWeapon = "wooden sword"; //---damage:2.5, attacks_per_second:1.5
		String choiceArmor = "bronze plate"; //---3 strength added

		ea.equipArmor(player, choiceArmor, "body");
		ew.equipWeapon(player, choiceWeapon);

		int expected = (int) ((2.5*1.5)*(1.0+((5.0+3.0)/100.0)));
		//---act
		int actual = (int) player.getDmgPerSecond();
		//---assert
		AssertJUnit.assertEquals(expected,actual);
	}
		
}