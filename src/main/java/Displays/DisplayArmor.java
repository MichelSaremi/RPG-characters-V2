package Displays;

public class DisplayArmor {

    //---lists all armor available with respective values
    public void armorDisplay() {
        StringBuilder armor = new StringBuilder();
        armor.append("----------------------- \n");
        armor.append("name; lvl-required; slot; strength; dexterity; intelligence, class \n");
        armor.append("--------plate---------\n");
        armor.append("Bronze plate; 1; (Head, Body, Legs); 3; 1; 1; (Warrior) \n");
        armor.append("Steel plate; 2; (Head, Body, Legs); 4; 1; 1; (Warrior) \n");
        armor.append("--------mail---------\n");
        armor.append("Bronze mail; 1; (Head, Body, Legs); 2; 2; 1; (Warrior,Rogue,Ranger) \n");
        armor.append("Steel mail; 2; (Head, Body, Legs); 3; 3; 1; (Warrior,Rogue,Ranger) \n");
        armor.append("--------leather---------\n");
        armor.append("Leather; 1; (Head, Body, Legs); 1; 2; 1; (Rogue,Ranger) \n");
        armor.append("Hard leather; 2; (Head, Body, Legs); 2; 3; 1; (Rogue,Ranger) \n");
        armor.append("--------cloth---------\n");
        armor.append("Cloth; 1; (Head, Body, Legs); 1; 1; 3; (Mage) \n");
        armor.append("Long cloth; 2; (Head, Body, Legs); 1; 1; 4; (Mage) \n");
        System.out.println(armor);
    }
}
