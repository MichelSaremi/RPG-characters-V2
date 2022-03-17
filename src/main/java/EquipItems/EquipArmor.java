package EquipItems;

import BuildObjects.Armor;
import BuildObjects.Hero;
import BuildObjects.MakeArmor;
import InvalidExceptions.InvalidArmorException;


public class EquipArmor {


    MakeArmor ma = new MakeArmor();

    //---equip head armor if player class is valid and player level is valid
    public boolean equipArmor(Hero player, String choice, String slot) throws InvalidArmorException {
        for (Armor item : ma.MakeArmor()) {
            if (item.getName().equals(choice)) {
                if (!item.getChar().get(0).equals(player.getChar())
                        && !item.getChar().get(1).equals(player.getChar())
                        && !item.getChar().get(2).equals(player.getChar())) {

                    //---throw exception if armor not applicable to class
                    throw new InvalidArmorException("This armor is not available to your class!");

                } else if (item.getRequired_level() > player.getLevel()) {

                    //---throw exception if armor not applicable to level
                    throw new InvalidArmorException("You dont have sufficient level to equip armor!");

                //---otherwise equip armor at desired slot
            }else if (slot.equals("head")) {
                    player.setArmorHead(item);
                    return true;
            }else if (slot.equals("body")) {
                    player.setArmorBody(item);
                    return true;
            }else if (slot.equals("legs")) {
                    player.setArmorLegs(item);
                    return true;

                }else if (!slot.equals("head") && !slot.equals("body") && !slot.equals("legs")){
                    System.out.println("You can only equip armor on Head, Body or Legs !");
                }
            }
        }
        System.out.println("Armor not available!");
        return false;
}}

