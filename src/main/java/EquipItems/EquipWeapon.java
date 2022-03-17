package EquipItems;

import BuildObjects.Hero;
import BuildObjects.MakeWeapons;
import BuildObjects.Weapon;
import InvalidExceptions.InvalidWeaponException;

public class EquipWeapon {

    MakeWeapons mw = new MakeWeapons();

    //---equip level if player class is valid and player level is valid
    public boolean equipWeapon(Hero player, String choice) throws InvalidWeaponException {
        for(Weapon item : mw.MakeWeapons()) {
            if (item.getName().equals(choice)) {
                if (!item.getChar().get(0).equals(player.getChar()) && !item.getChar().get(1).equals(player.getChar())) {

                    //---throw exception if weapon not applicable to class
                    throw new InvalidWeaponException("This weapon is not available to your class!");
                }
                else if (item.getRequired_level()>player.getLevel()) {

                    //---throw exception if weapon not applicable to level
                    throw new InvalidWeaponException("You dont have sufficient level to equip weapon!");
                }
                else {
                    //---otherwise equip weapon
                    player.setWeapon(item);
                    return true;
                }
            }
        }
        System.out.println("Weapon not available!");
        return false;

    }
}
