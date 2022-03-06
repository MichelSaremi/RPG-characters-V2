import BuildObjects.BuildHero;
import BuildObjects.Hero;
import Main.RPGCharacters;
import Updates.HeroLevelUp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {

    //---A character is level 1 when created
    @Test
    public void newHero_initialLvl_lvlOne() {
        //---arrange
        BuildHero bh = new BuildHero();
        Hero player = null;
        String name = "Michel";
        String hero = "warrior";
        int expected = 1;
        //---act
        player = bh.buildHero(player, name, hero);
        int actual = player.getLevel();
        //---assert
        assertEquals(expected, actual);
    }


    //---when a character gains level, it should be lvl 2
    @Test
    public void levelUp_nextLvl_lvlTwo() {
        //---arrange
        BuildHero bh = new BuildHero();
        Hero player = null;
        HeroLevelUp hlu = new HeroLevelUp();
        String name = "Michel";
        String hero = "warrior";
        player = bh.buildHero(player, name, hero);
        int expected = 2;
        //---act
        player = hlu.levelUp(player);
        int actual = player.getLevel();
        //---assert
        assertEquals(expected, actual);
    }


	//---heros created with proper default values
	//---for Warrior
	@Test
	public void newWarrior_startAtt_warriorAtt() {
		//---arrange
        BuildHero bh = new BuildHero();
        Hero player = null;
		String name = "Michel";
		String hero = "warrior";
		double expected_str = 5;
		double expected_dex = 2;
		double expected_int = 1;
		//---act
		player = bh.buildHero(player, name, hero);
		double actual_str = player.getBase_Strength();
		double actual_dex = player.getBase_Dexterity();
		double actual_int = player.getBase_Intelligence();
		//---assert
		assertEquals(expected_str,actual_str);
		assertEquals(expected_dex,actual_dex);
		assertEquals(expected_int,actual_int);
	}

	//---for Rogue
	@Test
	public void newRogue_startAtt_rogueAtt() {
		//---arrange
        BuildHero bh = new BuildHero();
        Hero player = null;
		String name = "Michel";
		String hero = "rogue";
		double expected_str = 2;
		double expected_dex = 6;
		double expected_int = 1;
		//---act
		player = bh.buildHero(player, name, hero);
		double actual_str = player.getBase_Strength();
		double actual_dex = player.getBase_Dexterity();
		double actual_int = player.getBase_Intelligence();
		//---assert
		assertEquals(expected_str,actual_str);
		assertEquals(expected_dex,actual_dex);
		assertEquals(expected_int,actual_int);
	}
	
	//---for Ranger
	@Test
	public void newRanger_startAtt_rangerAtt() {
		//---arrange
        BuildHero bh = new BuildHero();
        Hero player = null;
		String name = "Michel";
		String hero = "ranger";
		double expected_str = 1;
		double expected_dex = 7;
		double expected_int = 1;
		//---act
		player = bh.buildHero(player, name, hero);
		double actual_str = player.getBase_Strength();
		double actual_dex = player.getBase_Dexterity();
		double actual_int = player.getBase_Intelligence();
		//---assert
		assertEquals(expected_str,actual_str);
		assertEquals(expected_dex,actual_dex);
		assertEquals(expected_int,actual_int);
	}
	
	//---for Mage
	@Test
	public void newMage_startAtt_mageAtt() {
		//---arrange
        BuildHero bh = new BuildHero();
        Hero player = null;
		String name = "Michel";
		String hero = "mage";
		double expected_str = 1;
		double expected_dex = 1;
		double expected_int = 8;
		//---act
		player = bh.buildHero(player, name, hero);
		double actual_str = player.getBase_Strength();
		double actual_dex = player.getBase_Dexterity();
		double actual_int = player.getBase_Intelligence();
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
            BuildHero bh = new BuildHero();
            Hero player = null;
            HeroLevelUp hlu = new HeroLevelUp();
			String name = "Michel";
			String hero = "warrior";
			player = bh.buildHero(player, name, hero);
			double expected_str = 8;
			double expected_dex = 4;
			double expected_int = 2;
			//---act
			player = hlu.levelUp(player);
			double actual_str = player.getBase_Strength();
			double actual_dex = player.getBase_Dexterity();
			double actual_int = player.getBase_Intelligence();
			//---assert
			assertEquals(expected_str,actual_str);
			assertEquals(expected_dex,actual_dex);
			assertEquals(expected_int,actual_int);
		}

		
		//---for Rogue
		@Test
		public void lvlUpRogue_LvlUpAtt_rogueLvlTwoAtt() {
			//---arrange
            BuildHero bh = new BuildHero();
            Hero player = null;
            HeroLevelUp hlu = new HeroLevelUp();
			String name = "Michel";
			String hero = "rogue";
			player = bh.buildHero(player, name, hero);
			double expected_str = 3;
			double expected_dex = 10;
			double expected_int = 2;
			//---act
			player = hlu.levelUp(player);
			double actual_str = player.getBase_Strength();
			double actual_dex = player.getBase_Dexterity();
			double actual_int = player.getBase_Intelligence();
			//---assert
			assertEquals(expected_str,actual_str);
			assertEquals(expected_dex,actual_dex);
			assertEquals(expected_int,actual_int);
		}

		//---for Ranger
		@Test
		public void lvlUpRanger_LvlUpAtt_rangerLvlTwoAtt() {
			//---arrange
            BuildHero bh = new BuildHero();
            Hero player = null;
            HeroLevelUp hlu = new HeroLevelUp();
			String name = "Michel";
			String hero = "ranger";
			player = bh.buildHero(player, name, hero);
			double expected_str = 2;
			double expected_dex = 12;
			double expected_int = 2;
			//---act
			player = hlu.levelUp(player);
			double actual_str = player.getBase_Strength();
			double actual_dex = player.getBase_Dexterity();
			double actual_int = player.getBase_Intelligence();
			//---assert
			assertEquals(expected_str,actual_str);
			assertEquals(expected_dex,actual_dex);
			assertEquals(expected_int,actual_int);
		}
		
		//---for Mage
		@Test
		public void lvlUpMage_LvlUpAtt_mageLvlTwoAtt(){
			//---arrange
            BuildHero bh = new BuildHero();
            Hero player = null;
            HeroLevelUp hlu = new HeroLevelUp();
			String name = "Michel";
			String hero = "mage";
			player = bh.buildHero(player, name, hero);
			double expected_str = 2;
			double expected_dex = 2;
			double expected_int = 13;
			//---act
			player = hlu.levelUp(player);
			double actual_str = player.getBase_Strength();
			double actual_dex = player.getBase_Dexterity();
			double actual_int = player.getBase_Intelligence();
			//---assert
			assertEquals(expected_str,actual_str);
			assertEquals(expected_dex,actual_dex);
			assertEquals(expected_int,actual_int);
		}
}