package composite.flyweight;

import composite.enums.ClosingType;
import composite.enums.DisplayType;

public class ElementFlyweight {

    public final String tagName;
    public final DisplayType displayType;
    public final ClosingType closingType;

    public ElementFlyweight(String tagName,
                            DisplayType displayType,
                            ClosingType closingType) {
        this.tagName = tagName;
        this.displayType = displayType;
        this.closingType = closingType;
    }
}