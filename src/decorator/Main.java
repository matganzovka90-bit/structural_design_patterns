package decorator;

import decorator.inventory.Amulet;
import decorator.inventory.Armor;
import decorator.inventory.Sword;
import decorator.model.Hero;
import decorator.model.Warrior;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Warrior();

        System.out.println(hero.getDescription());
        System.out.println("Attack: " + hero.getAttack());
        System.out.println("Defense: " + hero.getDefence());
        System.out.println("Health: " + hero.getHealth());

        hero = new Sword(hero);
        hero = new Armor(hero);
        hero = new Amulet(hero);

        System.out.println(hero.getDescription());
        System.out.println("Attack: " + hero.getAttack());
        System.out.println("Defense: " + hero.getDefence());
        System.out.println("Health: " + hero.getHealth());
    }
}
