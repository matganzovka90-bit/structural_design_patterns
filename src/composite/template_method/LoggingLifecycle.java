package composite.template_method;

import composite.LightElementNode;
import composite.LightTextNode;

public class LoggingLifecycle extends LifecycleTemplate{
    @Override
    protected void onCreated(LightElementNode node) {
        System.out.println("[HOOK] Created: " + node.getTagName());
    }

    @Override
    protected void onInserted(LightElementNode node) {
        System.out.println("[HOOK] Inserted into DOM: " + node.getTagName());
    }

    @Override
    protected void onRemoved(LightElementNode node) {
        System.out.println("[HOOK] Removed: " + node.getTagName());
    }

    @Override
    protected void onClassListApplied(LightElementNode node) {
        System.out.println("[HOOK] Classes applied: " + node.getClasses());
    }

    @Override
    protected void onTextRendered(LightTextNode node) {
        System.out.println("[HOOK] Text rendered: " + node.outerHTML());
    }
}
