package composite.visitor;

import composite.LightElementNode;
import composite.LightTextNode;

public interface Visitor {
    void visit(LightTextNode node);
    void visit(LightElementNode node);
}
