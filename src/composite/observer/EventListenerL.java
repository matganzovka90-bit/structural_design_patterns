package composite.observer;

import composite.LightElementNode;

public interface EventListenerL {
    void handleEvent(String eventType, LightElementNode element);
}
