package composite.template_method;

import composite.LightElementNode;
import composite.LightNode;
import composite.LightTextNode;

public abstract class LifecycleTemplate {
    public final String render(LightElementNode node) {

        onCreated(node);

        onStylesApplied(node);
        onClassListApplied(node);

        StringBuilder sb = new StringBuilder();

        sb.append("<").append(node.getTagName());

        if (!node.getClasses().isEmpty()) {
            sb.append(" class=\"")
                    .append(String.join(" ", node.getClasses()))
                    .append("\"");
        }

        sb.append(">");

        onInserted(node);

        for (LightNode child : node.getChildren()) {
            if (child instanceof LightTextNode) {
                onTextRendered((LightTextNode) child);
            }
            sb.append(child.outerHTML());
        }

        sb.append("</").append(node.getTagName()).append(">");

        onRemoved(node);

        return sb.toString();
    }


    protected void onCreated(LightElementNode node) {}
    protected void onInserted(LightElementNode node) {}
    protected void onRemoved(LightElementNode node) {}
    protected void onStylesApplied(LightElementNode node) {}
    protected void onClassListApplied(LightElementNode node) {}
    protected void onTextRendered(LightTextNode node) {}
}
