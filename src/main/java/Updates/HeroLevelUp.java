package Updates;

import BuildObjects.Hero;


public class HeroLevelUp {

    //---level up
    public Hero levelUp(Hero player) {

        //---for warrior
        if ((player.getChar()).equals("warrior")) {

            int new_level = player.getLevel() + 1;
            player.setLevel(new_level);

            float new_strength = player.getBase_Strength() + 3;
            float new_Dexterity = player.getBase_Dexterity() + 2;
            float new_Intelligence = player.getBase_Intelligence() + 1;
            player.setBaseAtt(new_strength, new_Dexterity, new_Intelligence);
        }

        //---for rogue
        if ((player.getChar()).equals("rogue")) {

            int new_level = player.getLevel() + 1;
            player.setLevel(new_level);

            float new_strength = player.getBase_Strength() + 1;
            float new_Dexterity = player.getBase_Dexterity() + 4;
            float new_Intelligence = player.getBase_Intelligence() + 1;
            player.setBaseAtt(new_strength, new_Dexterity, new_Intelligence);
        }
        //---for ranger

        if ((player.getChar()).equals("ranger")) {

            int new_level = player.getLevel() + 1;
            player.setLevel(new_level);

            float new_strength = player.getBase_Strength() + 1;
            float new_Dexterity = player.getBase_Dexterity() + 5;
            float new_Intelligence = player.getBase_Intelligence() + 1;
            player.setBaseAtt(new_strength, new_Dexterity, new_Intelligence);
        }

        //---for mage
        if ((player.getChar()).equals("mage")) {

            int new_level = player.getLevel() + 1;
            player.setLevel(new_level);

            float new_strength = player.getBase_Strength() + 1;
            float new_Dexterity = player.getBase_Dexterity() + 1;
            float new_Intelligence = player.getBase_Intelligence() + 5;
            player.setBaseAtt(new_strength, new_Dexterity, new_Intelligence);
        }
        return player;
    }
}
