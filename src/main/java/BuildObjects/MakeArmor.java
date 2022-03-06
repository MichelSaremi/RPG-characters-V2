package BuildObjects;

import java.util.ArrayList;

public class MakeArmor {

    ArrayList<Armor> armorlist = new ArrayList<Armor>();

    //---Make armor objects and store in armor list
    //---Constructor parameters
    //---Parameters: armor name, required lvl to equip, strength gain, dexterity gain, intelligence gain, characters that can equip
    public ArrayList<Armor> MakeArmor() {
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

        return armorlist;
    }
}
