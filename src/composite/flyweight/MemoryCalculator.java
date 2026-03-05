package composite.flyweight;

import composite.LightElementNode;
import composite.LightNode;

import java.util.List;

public class MemoryCalculator {

    public static int countNodes(List<LightNode> nodes) {
        int count = 0;

        for (LightNode node : nodes) {
            count += countNode(node);
        }

        return count;
    }

    private static int countNode(LightNode node) {
        int count = 1;

        if (node instanceof LightElementNode el) {
            for (LightNode child : el.getChildren()) {
                count += countNode(child);
            }
        }
        return count;
    }
}
