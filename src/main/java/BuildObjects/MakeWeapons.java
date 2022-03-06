package BuildObjects;

import java.util.ArrayList;

public class MakeWeapons {

    ArrayList<Weapon> weaponslist = new ArrayList<Weapon>();

    //---Make weapon objects and store in weapons list
    //---Constructor parameters:
    //---weapon name, required lvl to equip, damage, attacks per second, characters that can equip
    public ArrayList<Weapon> MakeWeapons() {
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

        return weaponslist;
    }
}
