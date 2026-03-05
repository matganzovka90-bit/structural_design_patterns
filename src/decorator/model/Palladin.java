package decorator.model;

public class Palladin implements Hero{
    public String getDescription() {
        return "Palladin";
    }

    public int getHealth() {
        return 110;
    }

    public int getDefence() {
        return 80;
    }

    public int getAttack() {
        return 20;
    }
}
