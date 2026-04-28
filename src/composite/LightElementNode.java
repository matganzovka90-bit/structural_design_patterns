package composite;

import composite.enums.ClosingType;
import composite.enums.DisplayType;
import composite.flyweight.ElementFlyweight;
import composite.iterator.BreadthFirstIterator;
import composite.iterator.DepthFirstIterator;
import composite.iterator.LightIterator;
import composite.state.ElementState;
import composite.state.NormalState;

import java.util.*;

public class LightElementNode extends LightNode {
    private final String tagName;
    private final DisplayType displayType;
    private final ClosingType closingType;

    private ElementState state = new NormalState();

    private final ElementFlyweight flyweight;

    private final List<String> cssClasses = new ArrayList<>();
    private final List<LightNode> children = new ArrayList<>();


    public LightElementNode(String tagName,
                            DisplayType displayType,
                            ClosingType closingType) {
        this.tagName = tagName;
        this.displayType = displayType;
        this.closingType = closingType;
        this.flyweight = null;
    }

    public LightElementNode(ElementFlyweight flyweight) {
        this.flyweight = flyweight;
        this.tagName = null;
        this.displayType = null;
        this.closingType = null;
    }

    private String tag() {
        return flyweight != null ? flyweight.tagName : tagName;
    }

    private ClosingType closing() {
        return flyweight != null ? flyweight.closingType : closingType;
    }

    public void addClass(String cssClass) {
        cssClasses.add(cssClass);
    }

    public void addChild(LightNode node) {
        children.add(node);
    }

    public int getChildrenCount() {
        return children.size();
    }

    public List<LightNode> getChildren() {
        return children;
    }

    public LightIterator createDFSIterator() {
        return new DepthFirstIterator(this);
    }

    public LightIterator createBFSIterator() {
        return new BreadthFirstIterator(this);
    }

    public List<String> getClasses() {
        return cssClasses;
    }

    public void setState(ElementState state) {
        this.state = state;
    }

    @Override
    public String innerHTML() {
        StringBuilder sb = new StringBuilder();
        for (LightNode child : children) {
            sb.append(child.outerHTML());
        }
        return sb.toString();
    }


    public String renderDefault() {
        StringBuilder sb = new StringBuilder();

        sb.append("<").append(tag());

        if (!cssClasses.isEmpty()) {
            sb.append(" class=\"")
                    .append(String.join(" ", cssClasses))
                    .append("\"");
        }

        if (closing() == ClosingType.SINGLE) {
            sb.append("/>");
            return sb.toString();
        }

        sb.append(">");
        sb.append(innerHTML());
        sb.append("</").append(tag()).append(">");

        return sb.toString();
    }

    @Override
    public String outerHTML() {
        return state.render(this);
    }
}