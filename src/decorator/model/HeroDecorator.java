package decorator.model;

public abstract class HeroDecorator implements Hero{
    protected Hero hero;

    public HeroDecorator(Hero hero) {
        this.hero = hero;
    }
}