package Displays;

public class DisplayWeapons {

    //---lists all weapons available with respective values
    public void weaponsDisplay() {
        StringBuilder weapons = new StringBuilder();
        weapons.append("----------------------- \n");
        weapons.append("name; lvl-required; damage; attacks/second; class \n");
        weapons.append("--------axes---------\n");
        weapons.append("Stone axe; 1; 2; 1.5; (Warriors) \n");
        weapons.append("Bronze axe; 2; 4; 2; (Warriors \n");
        weapons.append("Steel axe; 3; 6; 2.5; (Warriors) \n");
        weapons.append("--------hammers---------\n");
        weapons.append("Stone hammer; 1; 3; 1.5; (Warriors) \n");
        weapons.append("Bronze hammer; 2; 5; 2; (Warriors) \n");
        weapons.append("Steel hammer; 3; 7; 2.5; (Warriors) \n");
        weapons.append("--------swords---------\n");
        weapons.append("Wooden sword; 1; 2.5; 1.5; (Warriors, Rogues) \n");
        weapons.append("Bronze sword; 2; 4.5; 2; (Warriors, Rogues) \n");
        weapons.append("Steel sword; 3; 6.5; 2.5; (Warriors, Rogues) \n");
        weapons.append("--------daggers---------\n");
        weapons.append("Wooden dagger; 1; 2; 1.5; (Rogues) \n");
        weapons.append("Bronze dagger; 2; 4; 2; (Rogues) \n");
        weapons.append("Steel dagger; 3; 6; 2.5; (Rogues) \n");
        weapons.append("--------bows---------\n");
        weapons.append("Wooden bow; 1; 3; 1.5; (Rangers) \n");
        weapons.append("Compound bow; 2; 5; 2; (Rangers) \n");
        weapons.append("Long bow; 3; 7; 2.5; (Rangers) \n");
        weapons.append("--------staffs---------\n");
        weapons.append("Wooden staff; 1; 4; 1.5; (Mages) \n");
        weapons.append("Obsidian staff; 2; 5; 2; (Mages) \n");
        weapons.append("Fire staff; 3; 8; 2.5; (Mages) \n");
        weapons.append("--------wands---------\n");
        weapons.append("Wooden wand; 1; 3; 1.5; (Mages) \n");
        weapons.append("Obsidian wand; 2; 4; 2; (Mages) \n");
        weapons.append("Fire wand; 3; 6; 2.5; (Mages) \n");
        System.out.println(weapons);
    }
}

