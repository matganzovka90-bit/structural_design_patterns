package decorator.inventory;

import decorator.model.Hero;
import decorator.model.HeroDecorator;

public class Amulet extends HeroDecorator {

    public Amulet(Hero hero) {
        super(hero);
    }

    public String getDescription() {
        return hero.getDescription() + " з амулетом";
    }

    public int getAttack() {
        return hero.getAttack();
    }

    public int getDefence() {
        return hero.getDefence();
    }

    public int getHealth() {
        return hero.getHealth() + 30;
    }
}
