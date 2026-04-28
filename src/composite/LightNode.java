package composite;


import composite.visitor.Visitor;

public abstract class LightNode {
    public abstract String outerHTML();
    public abstract String innerHTML();

    public abstract void accept(Visitor visitor);
}
