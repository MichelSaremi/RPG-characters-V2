package BuildObjects;


public class BuildHero {

    //---build hero
    public Hero buildHero(Hero player, String name, String hero) {

        if(hero.equals("warrior")) {
            player = new Hero(name, hero, 5, 2, 1);
            System.out.println("Welcome "+name+" the "+hero);
        }
        else if(hero.equals("rogue")) {
            player = new Hero(name, hero, 2, 6, 1);
            System.out.println("Welcome "+name+" the "+hero);
        }
        else if(hero.equals("ranger")) {
            player = new Hero(name, hero, 1, 7, 1);
            System.out.println("Welcome "+name+" the "+hero);
        }
        else if(hero.equals("mage")) {
            player = new Hero(name, hero, 1, 1, 8);
            System.out.println("Welcome "+name+" the "+hero);
        }

        return player;
    }
}
