package Displays;

import BuildObjects.Hero;
import java.text.DecimalFormat;

public class DisplayStats {


    //---Display stats
    public void statsDisplay(Hero player) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        //---display when armor is equipped
        if (player.getArmorHead()!=null||player.getArmorBody()!=null || player.getArmorLegs()!=null) {
            StringBuilder stats = new StringBuilder();
            stats.append("----------------------- \n");
            stats.append("Hero stats \n");
            stats.append("---------- \n");
            stats.append("Name : "+player.getName().toUpperCase()+"\n");
            stats.append("Type : "+player.getChar().toUpperCase()+"\n");
            stats.append("Level : "+player.getLevel()+"\n");
            stats.append("Strength :"+player.getTotalstrengthWithArmor()+"\n");
            stats.append("Dexterity :"+player.getTotalDexWithArmor()+"\n");
            stats.append("Intelligence :"+player.getTotalIntWithArmor()+"\n");
            stats.append("Damage per second :"+df.format(player.getDmgPerSecond())+"\n");
            stats.append("----------------------- \n");
            System.out.println(stats);

            //---display when NO armor is equipped
        }else if (player.getArmorHead()==null && player.getArmorBody()==null && player.getArmorLegs()==null) {
            StringBuilder stats = new StringBuilder();
            stats.append("----------------------- \n");
            stats.append("Hero stats \n");
            stats.append("---------- \n");
            stats.append("Name : "+player.getName().toUpperCase()+"\n");
            stats.append("Type : "+player.getChar().toUpperCase()+"\n");
            stats.append("Level : "+player.getLevel()+"\n");
            stats.append("Strength :"+player.getBase_Strength()+"\n");
            stats.append("Dexterity :"+player.getBase_Dexterity()+"\n");
            stats.append("Intelligence :"+player.getBase_Intelligence()+"\n");
            stats.append("Damage per second :"+df.format(player.getDmgPerSecond())+"\n");
            stats.append("----------------------- \n");
            System.out.println(stats);
        }

    }
}
