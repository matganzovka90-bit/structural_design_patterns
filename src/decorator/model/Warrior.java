package decorator.model;

public class Warrior implements Hero{
    public String getDescription() {
        return "Warrior";
    }

    public int getHealth() {
        return 100;
    }

    public int getDefence() {
        return 70;
    }

    public int getAttack() {
        return 50;
    }
}
