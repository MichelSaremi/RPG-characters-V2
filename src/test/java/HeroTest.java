/*import Main.RPGCharacters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {

	//---A character is level 1 when created
	@Test
	public void newHero_initialLvl_lvlOne() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		String name = "Michel";
		String hero = "Warrior";
		int expected = 1;
		//---act
		app.buildHero(name, hero);
		int actual = app.player.getLevel();
		//---assert
		assertEquals(expected,actual);
	}
	
	//---when a character gains level, it should be lvl 2
	@Test
	public void levelUp_nextLvl_lvlTwo() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		String name = "Michel";
		String hero = "Warrior";
		app.buildHero(name, hero);
		int expected = 2;
		//---act
		app.levelUp();
		int actual = app.player.getLevel(); 
		//---assert
		assertEquals(expected,actual);
	}
	
	//---heros created with proper default values
	//---for Warrior
	@Test
	public void newWarrior_startAtt_warriorAtt() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		String name = "Michel";
		String hero = "Warrior";
		double expected_str = 5;
		double expected_dex = 2;
		double expected_int = 1;
		//---act
		app.buildHero(name, hero);
		double actual_str = app.player.getBase_Strength();
		double actual_dex = app.player.getBase_Dexterity();
		double actual_int = app.player.getBase_Intelligence();
		//---assert
		assertEquals(expected_str,actual_str);
		assertEquals(expected_dex,actual_dex);
		assertEquals(expected_int,actual_int);
	}
	
	//---for Rogue
	@Test
	public void newRogue_startAtt_rogueAtt() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		String name = "Michel";
		String hero = "Rogue";
		double expected_str = 2;
		double expected_dex = 6;
		double expected_int = 1;
		//---act
		app.buildHero(name, hero);
		double actual_str = app.player.getBase_Strength();
		double actual_dex = app.player.getBase_Dexterity();
		double actual_int = app.player.getBase_Intelligence();
		//---assert
		assertEquals(expected_str,actual_str);
		assertEquals(expected_dex,actual_dex);
		assertEquals(expected_int,actual_int);
	}
	
	//---for Ranger
	@Test
	public void newRanger_startAtt_rangerAtt() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		String name = "Michel";
		String hero = "Ranger";
		double expected_str = 1;
		double expected_dex = 7;
		double expected_int = 1;
		//---act
		app.buildHero(name, hero);
		double actual_str = app.player.getBase_Strength();
		double actual_dex = app.player.getBase_Dexterity();
		double actual_int = app.player.getBase_Intelligence();
		//---assert
		assertEquals(expected_str,actual_str);
		assertEquals(expected_dex,actual_dex);
		assertEquals(expected_int,actual_int);
	}
	
	//---for Mage
	@Test
	public void newMage_startAtt_mageAtt() {
		//---arrange
		RPGCharacters app = new RPGCharacters();
		String name = "Michel";
		String hero = "Mage";
		double expected_str = 1;
		double expected_dex = 1;
		double expected_int = 8;
		//---act
		app.buildHero(name, hero);
		double actual_str = app.player.getBase_Strength();
		double actual_dex = app.player.getBase_Dexterity();
		double actual_int = app.player.getBase_Intelligence();
		//---assert
		assertEquals(expected_str,actual_str);
		assertEquals(expected_dex,actual_dex);
		assertEquals(expected_int,actual_int);
		}
	
		//---heros attributes when level up 
		//---for Warrior
		@Test
		public void lvlUpWarrior_LvlUpAtt_warriorLvlTwoAtt() {
			//---arrange
			RPGCharacters app = new RPGCharacters();
			String name = "Michel";
			String hero = "Warrior";
			app.buildHero(name, hero);
			double expected_str = 8;
			double expected_dex = 4;
			double expected_int = 2;
			//---act
			app.levelUp();
			double actual_str = app.player.getBase_Strength();
			double actual_dex = app.player.getBase_Dexterity();
			double actual_int = app.player.getBase_Intelligence();
			//---assert
			assertEquals(expected_str,actual_str);
			assertEquals(expected_dex,actual_dex);
			assertEquals(expected_int,actual_int);
		}
		
		//---for Rogue
		@Test
		public void lvlUpRogue_LvlUpAtt_rogueLvlTwoAtt() {
			//---arrange
			RPGCharacters app = new RPGCharacters();
			String name = "Michel";
			String hero = "Rogue";
			app.buildHero(name, hero);
			double expected_str = 3;
			double expected_dex = 10;
			double expected_int = 2;
			//---act
			app.levelUp();
			double actual_str = app.player.getBase_Strength();
			double actual_dex = app.player.getBase_Dexterity();
			double actual_int = app.player.getBase_Intelligence();
			//---assert
			assertEquals(expected_str,actual_str);
			assertEquals(expected_dex,actual_dex);
			assertEquals(expected_int,actual_int);
		}
		
		//---for Ranger
		@Test
		public void lvlUpRanger_LvlUpAtt_rangerLvlTwoAtt() {
			//---arrange
			RPGCharacters app = new RPGCharacters();
			String name = "Michel";
			String hero = "Ranger";
			app.buildHero(name, hero);
			double expected_str = 2;
			double expected_dex = 12;
			double expected_int = 2;
			//---act
			app.levelUp();
			double actual_str = app.player.getBase_Strength();
			double actual_dex = app.player.getBase_Dexterity();
			double actual_int = app.player.getBase_Intelligence();
			//---assert
			assertEquals(expected_str,actual_str);
			assertEquals(expected_dex,actual_dex);
			assertEquals(expected_int,actual_int);
		}
		
		//---for Mage
		@Test
		public void lvlUpMage_LvlUpAtt_mageLvlTwoAtt(){
			//---arrange
			RPGCharacters app = new RPGCharacters();
			String name = "Michel";
			String hero = "Mage";
			app.buildHero(name, hero);
			double expected_str = 2;
			double expected_dex = 2;
			double expected_int = 13;
			//---act
			app.levelUp();
			double actual_str = app.player.getBase_Strength();
			double actual_dex = app.player.getBase_Dexterity();
			double actual_int = app.player.getBase_Intelligence();
			//---assert
			assertEquals(expected_str,actual_str);
			assertEquals(expected_dex,actual_dex);
			assertEquals(expected_int,actual_int);
		}
}*/