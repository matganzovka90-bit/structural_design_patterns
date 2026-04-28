package composite.state;

import composite.LightElementNode;

public class DisabledState implements ElementState{
    @Override
    public String render(LightElementNode node) {
        node.addClass("disabled");
        return node.renderDefault();
    }
}
