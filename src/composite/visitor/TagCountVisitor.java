package composite.visitor;

import composite.LightElementNode;
import composite.LightTextNode;

import java.util.HashMap;
import java.util.Map;

public class TagCountVisitor implements Visitor{
    private final Map<String, Integer> tagCount = new HashMap<>();

    @Override
    public void visit(LightTextNode node) {
    }

    @Override
    public void visit(LightElementNode node) {
        String tag = node.getTagName();
        tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
    }

    public void printStats() {
        System.out.println("=== TAG STATS ===");
        for (var entry : tagCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
