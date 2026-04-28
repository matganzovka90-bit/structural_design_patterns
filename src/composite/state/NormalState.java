package composite.state;

import composite.LightElementNode;

public class NormalState implements ElementState{
    @Override
    public String render(LightElementNode node) {
        return node.renderDefault();
    }
}
