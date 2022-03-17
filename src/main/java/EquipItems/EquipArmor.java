package EquipItems;

import BuildObjects.Armor;
import BuildObjects.Hero;
import BuildObjects.MakeArmor;
import InvalidExceptions.InvalidArmorException;


public class EquipArmor {


    MakeArmor ma = new MakeArmor();

    //---equip head armor if player class is valid and player level is valid
    public boolean equipArmorHead(Hero player, String choice) throws InvalidArmorException {
        for(Armor item : ma.MakeArmor()) {
            if (item.getName().equals(choice)) {
                if (!item.getChar().get(0).equals(player.getChar())
                        && !item.getChar().get(1).equals(player.getChar())
                        && !item.getChar().get(2).equals(player.getChar())) {

                    //---throw exception if armor not applicable to class
                    throw new InvalidArmorException("This armor is not available to your class!");

                }else if(item.getRequired_level()>player.getLevel()) {

                    //---throw exception if armor not applicable to level
                    throw new InvalidArmorException("You dont have sufficient level to equip armor!");
                }
                else {
                    //---otherwise equip armor at desired slot
                    player.setArmorHead(item);
                    return true;
                }
            }
        }
        return false;
    }
    //---equip body armor if player class is valid and player level is valid
    public boolean equipArmorBody(Hero player, String choice) throws InvalidArmorException {
        for(Armor item : ma.MakeArmor()) {
            if (item.getName().equals(choice)) {
                if (!item.getChar().get(0).equals(player.getChar())
                        && !item.getChar().get(1).equals(player.getChar())
                        && !item.getChar().get(2).equals(player.getChar())) {

                    //---throw exception if armor not applicable to class
                    throw new InvalidArmorException("This armor is not available to your class!");

                }else if(item.getRequired_level()>player.getLevel()) {

                    //---throw exception if armor not applicable to level
                    throw new InvalidArmorException("You dont have sufficient level to equip armor!");
                }
                else {
                    //---otherwise equip armor at desired slot
                    player.setArmorBody(item);
                    return true;
                }
            }
        }
        return false;
    }

    //---equip legs armor if player class is valid and player level is valid
    public boolean equipArmorLegs(Hero player, String choice) throws InvalidArmorException {
        for(Armor item : ma.MakeArmor()) {
            if (item.getName().equals(choice)) {
                if (!item.getChar().get(0).equals(player.getChar())
                        && !item.getChar().get(1).equals(player.getChar())
                        && !item.getChar().get(2).equals(player.getChar())) {

                    //---throw exception if armor not applicable to class
                    throw new InvalidArmorException("This armor is not available to your class!");

                }else if(item.getRequired_level()>player.getLevel()) {

                    //---throw exception if armor not applicable to level
                    throw new InvalidArmorException("You dont have sufficient level to equip armor!");
                }
                else {
                    //---otherwise equip armor at desired slot
                    player.setArmorLegs(item);
                    return true;
                }
            }
        }
        return false;
    }

}
