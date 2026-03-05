package decorator.model;

public class Mage implements Hero{
    public String getDescription() {
        return "Mage";
    }

    public int getHealth() {
        return 90;
    }

    public int getDefence() {
        return 20;
    }

    public int getAttack() {
        return 40;
    }
}
