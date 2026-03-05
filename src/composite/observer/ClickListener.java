package composite.observer;

import composite.LightElementNode;

public class ClickListener implements EventListenerL {
    @Override
    public void handleEvent(String eventType, LightElementNode element) {
        System.out.println("Click event handled on <" + element.outerHTML() + ">");
    }
}
