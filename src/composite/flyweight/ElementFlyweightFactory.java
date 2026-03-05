package composite.flyweight;

import composite.enums.ClosingType;
import composite.enums.DisplayType;

import java.util.HashMap;
import java.util.Map;

public class ElementFlyweightFactory {

    private static final Map<String, ElementFlyweight> cache = new HashMap<>();

    public static ElementFlyweight get(String tag,
                                       DisplayType display,
                                       ClosingType closing) {

        String key = tag + display + closing;

        if (!cache.containsKey(key)) {
            cache.put(key, new ElementFlyweight(tag, display, closing));
        }
        return cache.get(key);
    }

    public static int cacheSize() {
        return cache.size();
    }
}