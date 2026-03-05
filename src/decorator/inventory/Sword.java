package decorator.inventory;

import decorator.model.Hero;
import decorator.model.HeroDecorator;

public class Sword extends HeroDecorator {

    public Sword(Hero hero) {
        super(hero);
    }

    public String getDescription() {
        return hero.getDescription() + " з мечем";
    }

    public int getAttack() {
        return hero.getAttack() + 10;
    }

    public int getDefence() {
        return hero.getDefence();
    }

    public int getHealth() {
        return hero.getHealth();
    }
}
