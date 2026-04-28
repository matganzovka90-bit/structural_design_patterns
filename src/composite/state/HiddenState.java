package composite.state;

import composite.LightElementNode;

public class HiddenState implements ElementState{
    @Override
    public String render(LightElementNode node) {
        return "";
    }
}
