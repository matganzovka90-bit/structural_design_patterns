package decorator.inventory;

import decorator.model.Hero;
import decorator.model.HeroDecorator;

public class Armor extends HeroDecorator {

    public Armor(Hero hero) {
        super(hero);
    }

    public String getDescription() {
        return hero.getDescription() + " у броні";
    }

    public int getAttack() {
        return hero.getAttack();
    }

    public int getDefence() {
        return hero.getDefence() + 30;
    }

    public int getHealth() {
        return hero.getHealth();
    }
}
