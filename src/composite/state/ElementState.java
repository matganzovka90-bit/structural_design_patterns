package composite.state;

import composite.LightElementNode;

public interface ElementState {
    String render(LightElementNode node);
}
