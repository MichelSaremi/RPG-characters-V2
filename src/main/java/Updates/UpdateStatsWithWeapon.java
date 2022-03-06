package Updates;

import BuildObjects.Hero;

public class UpdateStatsWithWeapon {


    //---update damage per second(DPS) when weapon is equipped
    public Hero updateStatsWithWeapon(Hero player) {

        double weaponAttackPerSec = player.getWeapon().getAttacks_per_second();
        double weaponDmg = player.getWeapon().getDamage();
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
        return player;
    }
}
