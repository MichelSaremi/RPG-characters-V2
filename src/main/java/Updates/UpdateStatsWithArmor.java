package Updates;

import BuildObjects.Hero;


public class UpdateStatsWithArmor {

    //---update total attributes once armor is equipped
    public Hero updateStatsWithArmor(Hero player) {

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

        return player;
    }
}
