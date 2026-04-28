package composite.visitor;

import composite.LightElementNode;
import composite.LightTextNode;

public class PrintVisitor implements Visitor{
    @Override
    public void visit(LightTextNode node) {
        System.out.println(node.outerHTML());
    }

    @Override
    public void visit(LightElementNode node) {
        System.out.println(node.outerHTML());
    }
}
